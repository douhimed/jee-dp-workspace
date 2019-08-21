package org.mql.biblio.dao;

import java.util.List;

public interface IModelDao<T> {

	List<T> selectAll();
	
}
