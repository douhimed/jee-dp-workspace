package org.mql.biblio.actions;

public class AuthorAction extends AbstractAction {

	public AuthorAction(String actionName) {
		this.setActionName(actionName);
	}
	
	private String getAuthorsPage() {
		return "authors/authorsList";
	}
	
	private String getAuthorProfilPage() {
		return "authors/authorProfil";
	}
	
	@Override
	public String execute() {
		if(this.getActionName().equalsIgnoreCase(AUTHOR_PROFIL_ACTION))
			return this.getAuthorProfilPage();
		else
			return this.getAuthorsPage();
		
	}

}
