package org.mql.biblio.actions;

public abstract class AbstractAction {

	protected static final String AUTHORS_LIST_ACTION = "authorsList";
	protected static final String AUTHOR_PROFIL_ACTION = "authorProfil";
	protected static final String BOOKS_LIST_ACTION = "booksList";
	protected static final String BOOK_DETAILS_ACTION = "bookDetails";
	protected static final String NOT_SUPPORTED_ACTION = "notSupported";
	protected static final String NOT_FOUND_ACTION = "notFound";

	private String actionName = "home";

	public abstract String execute();

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionName() {
		return actionName;
	}
}
