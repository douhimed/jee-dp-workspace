package org.mql.biblio.dao;

import java.util.Set;

import org.mql.biblio.models.Author;

public interface IAuthorDAO {

	Set<Author> selectAuthors();
	int saveAuthor(Author author);
	
	
}
