package org.mql;

import org.mql.dao.IDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private ClassPathXmlApplicationContext context;
	
	public App() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		exp01();
		context.close();
	}

	private void exp01() {
		IDAO dao = context.getBean("dao", IDAO.class);
		System.out.println(dao.getData(1));
	}

	public static void main(String[] args) {
		new App();
	}

}
