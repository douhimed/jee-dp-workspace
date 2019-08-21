package org.mql.biblio.dao;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.mql.biblio.web.models.Author;

public class AuthorDAOMySQL implements IModelDAO<Author> {

	private static Map<Integer, Author> authors;

	static {
		authors = new Hashtable<Integer, Author>();
		authors.put(100, new Author(100, "John", 1975));
		authors.put(101, new Author(101, "Michael", 1985));
	}

	@Override
	public Set<Author> selectModels() {
		System.out.println("selectAuthors : MySQL");
		return new HashSet<Author>(authors.values());
	}

	@Override
	public int saveModel(Author author) {
		System.out.println("saveAuthor : MySQL");
		this.authors.put(author.getId(), author);
		return author.getId();
	}

}
