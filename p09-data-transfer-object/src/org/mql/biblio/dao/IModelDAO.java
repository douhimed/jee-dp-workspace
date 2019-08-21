package org.mql.biblio.dao;

import java.util.Set;

public interface IModelDAO<T> {

	Set<T> selectModels();

	int saveModel(T t);

}
