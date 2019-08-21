package org.mql.biblio.dao;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import org.mql.biblio.models.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOExcel implements IAuthorDAO {

	private static Map<Integer, Author> authors;

	static {
		authors = new Hashtable<Integer, Author>();
		authors.put(100, new Author(100, "John"));
		authors.put(101, new Author(101, "Michael"));
	}

	@Override
	public Set<Author> selectAuthors() {
		System.out.println("selectAuthors : Excel");
		return new HashSet<Author>(authors.values());
	}

	@Override
	public int saveAuthor(Author author) {
		System.out.println("saveAuthor : Excel");
		this.authors.put(author.getId(), author);
		return author.getId();
	}

}
