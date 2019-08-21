package org.mql.biblio.business;

import java.util.Set;

import org.mql.biblio.dao.IAuthorDAO;
import org.mql.biblio.models.Author;

public class BiblioServicesDefault implements IBiblioServices {

	private IAuthorDAO authorDao;

	public BiblioServicesDefault() {
	}

	public BiblioServicesDefault(IAuthorDAO authordao) {
		super();
		this.authorDao = authordao;
	}

	public void setAuthordao(IAuthorDAO authordao) {
		this.authorDao = authordao;
	}

	public IAuthorDAO getAuthordao() {
		return authorDao;
	}

	@Override
	public Set<Author> getAuthors() {
		System.out.println("Biblio defaul services : getAuthors");
		return this.authorDao.selectAuthors();
	}

	@Override
	public int addAuthor(Author author) {
		System.out.println("Biblio default services : saveAuthor");
		return this.authorDao.saveAuthor(author);
	}

}
