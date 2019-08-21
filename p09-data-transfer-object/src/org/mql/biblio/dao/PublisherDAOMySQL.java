package org.mql.biblio.dao;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.mql.biblio.web.models.Author;
import org.mql.biblio.web.models.Publisher;

public class PublisherDAOMySQL implements IModelDAO<Publisher> {

	private static Map<Integer, Publisher> publishers;

	static {
		publishers = new Hashtable<Integer, Publisher>();
		publishers.put(200, new Publisher(200, "DONUD"));
		publishers.put(201, new Publisher(200, "DZONE"));
	}

	@Override
	public Set<Publisher> selectModels() {
		return new HashSet<Publisher>(publishers.values());
	}

	@Override
	public int saveModel(Publisher publisher) {
		return this.publishers.put(publisher.getId(), publisher).getId();
	}

}
