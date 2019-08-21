package org.mql.biblio.dao;

import java.util.List;
import java.util.Vector;

import org.mql.biblio.dao.jdbc.Database;
import org.mql.biblio.dao.mappers.AuthorMapper;
import org.mql.biblio.dao.mappers.PublisherMapper;
import org.mql.biblio.web.models.Author;
import org.mql.biblio.web.models.Publisher;

public class PublisherDAO implements IModelDao<Publisher> {

	private String tableName = "publishers";
	private Database db;
	
	public PublisherDAO() {
	}
	
	public PublisherDAO(Database db) {
		super();
		this.db = db;
	}

	@Override
	public List<Publisher> selectAll() {
		String[][] data = this.db.selectAll(tableName);
		List<Publisher> publishers = new Vector<Publisher>();
		for (int i = 1; i < data.length; i++) {
			publishers.add(PublisherMapper.toPublisher(data[i]));
		}
		return publishers;
	}

}
