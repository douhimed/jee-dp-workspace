package org.mql.biblio.actions;

public class BookAction extends AbstractAction {

	public BookAction(String actionName) {
		this.setActionName(actionName);
	}
	
	private String getBooksPage() {
		return "books/booksList";
	}

	private String getBookDetailsPage() {
		return "books/bookDetails";
	}

	@Override
	public String execute() {
		if (this.getActionName().equalsIgnoreCase(BOOK_DETAILS_ACTION))
			return this.getBookDetailsPage();
		else
			return this.getBooksPage();
	}

}
