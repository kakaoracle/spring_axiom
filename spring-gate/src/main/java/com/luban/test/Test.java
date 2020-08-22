package com.luban.test;

import com.luban.batis.KakaFactory;
import com.luban.proxy.KakaInvocationHandler;
import com.luban.proxy.ProxyUtil;
import com.luban.service.UserDao;
import com.luban.service.UserDaoImpl;
import org.springframework.context.ApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {

		UserDao userDao= (UserDao) ProxyUtil.newInstance(UserDao.class.getClassLoader(),new Class[]{UserDao.class},new KakaInvocationHandler(new UserDaoImpl()));
		userDao.proxy();
		// 初始化spring容器
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		// getBean方法入参一定要是class文件,否则会报很诡异的错误
		//System.out.println(ac.getBean(AppConfig.class));
		// 用xml初始化容器
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		//context.getBean(LuBanService.class).xx();
		/*DataSource dataSource = null;
		TransactionFactory transactionFactory =
				new JdbcTransactionFactory();
		Environment environment =
				new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		// 一般是dao层接口类
		configuration.addMapper(AppConfig.class);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 返回一个proxy对象
		AppConfig mapper = sqlSession.getMapper(AppConfig.class);*/

		/*UserDao userDao = (UserDao) KakaFactory.getMapper(UserDao.class);
		userDao.query();*/

	}
}












