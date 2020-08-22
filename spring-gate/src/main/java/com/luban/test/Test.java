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
		// ��ʼ��spring����
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		// getBean�������һ��Ҫ��class�ļ�,����ᱨ�ܹ���Ĵ���
		//System.out.println(ac.getBean(AppConfig.class));
		// ��xml��ʼ������
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
		//context.getBean(LuBanService.class).xx();
		/*DataSource dataSource = null;
		TransactionFactory transactionFactory =
				new JdbcTransactionFactory();
		Environment environment =
				new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		// һ����dao��ӿ���
		configuration.addMapper(AppConfig.class);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ����һ��proxy����
		AppConfig mapper = sqlSession.getMapper(AppConfig.class);*/

		/*UserDao userDao = (UserDao) KakaFactory.getMapper(UserDao.class);
		userDao.query();*/

	}
}












