package org.mql.biblio.business;

import java.util.Set;

import org.mql.biblio.dao.IAuthorDAO;
import org.mql.biblio.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BiblioServicesDI implements IBiblioServices {

	@Autowired
	@Qualifier("authorDAOExcel")
	private IAuthorDAO authorDao;

	public BiblioServicesDI() {
	}

	@Autowired
	public BiblioServicesDI(@Qualifier("authorDAOExcel") IAuthorDAO authorDao) {
		super();
		this.authorDao = authorDao;
	}

	@Autowired
	public void setAuthordao(@Qualifier("authorDAOExcel") IAuthorDAO authordao) {
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
