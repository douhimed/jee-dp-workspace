package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.AuthorMapper;
import org.mql.biblio.web.models.Author;

public class AuthorDAO implements IModelDao<Author> {

	private String tableName = "authors";
	private Database db;
	
	public AuthorDAO() {
	}
	
	public AuthorDAO(Database db) {
		super();
		this.db = db;
	}

	@Override
	public List<Author> selectAll() {
		String[][] data = this.db.selectAll(tableName);
		List<Author> authors = new Vector<Author>();
		for (int i = 1; i < data.length; i++) {
			authors.add(AuthorMapper.toAuthor(data[i]));
		}
		return authors;
	}

}
