package org.mql.biblio.business;

import java.util.Set;

import org.mql.biblio.dao.IModelDAO;
import org.mql.biblio.web.models.Author;

public class BiblioServicesDefault implements IBiblioServices {

	private IModelDAO<Author> authorDao;

	public BiblioServicesDefault() {
	}

	public BiblioServicesDefault(IModelDAO<Author> authordao) {
		super();
		this.authorDao = authordao;
	}

	public void setAuthordao(IModelDAO<Author> authordao) {
		this.authorDao = authordao;
	}

	@Override
	public Set<Author> getAuthors() {
		System.out.println("Biblio defaul services : getAuthors");
		return this.authorDao.selectModels();
	}

	@Override
	public int addAuthor(Author author) {
		System.out.println("Biblio default services : saveAuthor");
		return this.authorDao.saveModel(author);
	}

}
