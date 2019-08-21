package org.mql.biblio.client;

import java.util.List;

import org.mql.biblio.dao.AuthorDAO;
import org.mql.biblio.dao.IModelDao;
import org.mql.biblio.dao.PublisherDAO;
import org.mql.biblio.dao.jdbc.DataSource;
import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.jdbc.MySQLDataSource;
import org.mql.biblio.web.models.Author;
import org.mql.biblio.web.models.Publisher;

public class App {

	private DataSource ds;
	private Database db;
	private IModelDao<Author> authorDao;
	private IModelDao<Publisher> publisherDao;
	
	public App() {
		init("biblio");
		//p01();	
		p02();
	}

	private void p02() {
		this.publisherDao.selectAll().forEach(System.out::println);
	}

	private void p01() {
		List<Author> authors = this.authorDao.selectAll();
		authors.forEach(System.out::println);
	}

	private void init(String dbName) {
		 ds = new MySQLDataSource(dbName);
		 db = new Database(ds);
		 authorDao = new AuthorDAO(db);
		 publisherDao = new PublisherDAO(db);
	}

	public static void main(String[] args) {
		new App();
	}

}
