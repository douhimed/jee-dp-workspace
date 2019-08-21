package org.mql.biblio.web.actions;

import org.mql.biblio.business.BusinessDelegate;
import org.mql.biblio.business.IBiblioServices;
import org.mql.biblio.web.actions.context.Context;

public class AuthorActions {

	private BusinessDelegate businessDelegate;

	public AuthorActions() {
	}
	
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;	
	}
	
	public String executeAction(Context webContext) {
		webContext.setModel("service", this.businessDelegate.executeService());
		return "biblio.jsp";
	}

	
	
}
