package org.mql.biblio.client;

import org.mql.biblio.business.BiblioServicesDefault;
import org.mql.biblio.business.IBiblioServices;
import org.mql.biblio.dao.AuthorDAOMySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	// injection by setter and getter without a IoC Framework
	private IBiblioServices biblioServices;
	private BiblioServicesDefault biblioServices2;
	
	// injection by setter and getter with a IoC Framework
	private ClassPathXmlApplicationContext context;

	public App() {
		exp03();
	}

	private void exp03() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IBiblioServices  biblioServices3  = context.getBean("biblioServicesDI", IBiblioServices.class);
		biblioServices3.getAuthors().forEach(System.out::println);
		context.close();
	}

	private void exp02() {
		this.biblioServices2 = new BiblioServicesDefault();
		this.biblioServices2.setAuthordao(new AuthorDAOMySQL());
		this.biblioServices2.getAuthors().forEach(System.out::println);
	}

	private void exp01() {
		this.biblioServices = new BiblioServicesDefault(new AuthorDAOMySQL());
		this.biblioServices.getAuthors().forEach(System.out::println);
	}

	public static void main(String[] args) {
		new App();
	}

}
