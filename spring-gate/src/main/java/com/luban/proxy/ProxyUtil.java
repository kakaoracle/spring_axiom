package com.luban.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {
	/**
	 *  整个过程相当于根据聚合式静态代理内容,自动生成一份形式完全一致的文件,包括每个标点符号
	 *  和生成一份pdf差不多,每行内容都要用代码生成
	 *  classLoader并没有用到,用的是URLClassLoader,只是为了和jdk参数列表统一
	 */
	public static Object newInstance(ClassLoader classLoader, Class[] classes,Object handler) throws Exception {

		Object proxy=null;
		// 这里classes仅有一个class
		Method methods[] =classes[0].getDeclaredMethods();
		String line="\n";// 换行
		String tab ="\t";// tab
		String infName = classes[0].getSimpleName(); // 不带包路径的类名
		String implName = handler.getClass().getSimpleName();
		String content ="";
		String packageContent = "package com.luban.proxy;"+line;//指定动态代理类都放在哪个目录下
		// 代理哪个接口就引入哪个接口
		String importContent = "import "+classes[0].getName()+";"+line
				+"import com.luban.proxy.KakaInvocationHandler;"+line
				+"import java.lang.Exception;"+line
				+"import java.lang.reflect.Method;"+line;
		String clazzFirstLineContent = "public class $ProxyKaka implements "+infName+"{"+line;// $Proxy是随便一个实现类的类名
		String filedContent  =tab+"private "+implName+" target;"+line;// 引入接口,private Service target;加换行
		String constructorContent =tab+"public $ProxyKaka ("+implName+" target){" +line
				+tab+tab+"this.target =target;"
				+line+tab+"}"+line;
		String methodContent = "";
		for (Method method : methods) {
			// 获取返回值,比如string
			String returnTypeName = method.getReturnType().getSimpleName();
			// 获取方法名
			String methodName =method.getName();
			// 获取目标接口中的方法中的参数类型(如果有参数的话),不过是参数类型名.class文件,比如String.class
			Class args[] = method.getParameterTypes();
			// argsContent与paramsContent区别是前者是入参列表String p0,String p1,后者是传参列表,p0,p1
			String argsContent = "";
			String paramsContent="";
			int flag =0;
			for (Class arg : args) {
				// 参数类型.class取名就是参数类型
				String temp = arg.getSimpleName();
				// 命名入参为p,比如String p0,Sting p1,
				argsContent+=temp+" p"+flag+",";
				// argsContent与paramsContent区别是前者是入参列表String p0,String p1,后者是传参列表,p0,p1
				paramsContent+="p"+flag+",";
				flag++;
			}
			if (argsContent.length()>0){
				argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
				paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
			}
			// 这块加一个动态代理的内容,并且执行被代理对象的方法
			// 难点就在于即使入参是method,也无法直接执行,必须要生成一个实例才能调用该方法,因此用class.forname生成实例
			// 因此不能直接传一个method,新设计一个Handler
			methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+")throws Exception {"+line
					+tab+tab+"Method method = Class.forName(\""+classes[0].getName()+"\").getDeclaredMethod(\""+methodName+"\");"
					+line +tab+tab+"return ("+returnTypeName+")target.invoke(method);"+line
					+tab+"}"+line;

		}

		content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";
		// 生成一份空文件,将刚才生成的类写到这个文件中,类名是$开头的实际情况类名也是类随机生成的
		// 注意这里的目录路径应该与import包路径是一致的
		File file =new File("D:\\com\\luban\\proxy\\$ProxyKaka.java");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();
			// 可以单独对上面进行测试,上面的已经是能生成一份java文件
			// 接下来的是将java文件编译成class文件,因为生成java后往往已经工程已经编译完了,因此不能依赖让jdk编译,要自己编译
			// 下面的编译不需要记,只要知道就好
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

			StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
			Iterable units = fileMgr.getJavaFileObjects(file);

			JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
			t.call();
			fileMgr.close();

			// 由于class文件不在工程目录下不能用Class.name(),因此要单独找到加载,这里用URL类加载器,注意由于class中已经包含路径,因此这里只指定磁盘名
			URL[] urls = new URL[]{new URL("file:D:\\\\")};
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			Class clazz = urlClassLoader.loadClass("com.luban.proxy.$ProxyKaka");
			// 获取构造方法
			//  参数就是class文件,用构造方法就可以由class文件生成一个java文件
			Constructor constructor = clazz.getConstructor(handler.getClass());
			proxy = constructor.newInstance(handler);
			return proxy;
	}
}
