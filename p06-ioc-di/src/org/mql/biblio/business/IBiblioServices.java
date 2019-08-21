package org.mql.biblio.business;

import java.util.Set;

import org.mql.biblio.models.Author;

public interface IBiblioServices {

	Set<Author> getAuthors();
	int addAuthor(Author author);
	
}
