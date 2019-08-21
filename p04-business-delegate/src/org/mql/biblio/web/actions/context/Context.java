package org.mql.biblio.web.actions.context;

public interface Context {

	String getParameter(String nom);

	void setModel(String name, Object model);

	Object getModel(String name);
}
