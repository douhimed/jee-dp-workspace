package org.mql.biblio.web.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.biblio.business.BusinessDelegate;
import org.mql.biblio.business.BusinessLookup;
import org.mql.biblio.business.IBiblioServices;
import org.mql.biblio.business.ServiceType;
import org.mql.biblio.web.actions.AuthorActions;
import org.mql.biblio.web.actions.context.WebContext;

@WebServlet({ "/biblioLocal", "/biblioRemote", "/biblioMail" })
public class BiblioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthorActions authorActions;
	private BusinessDelegate businessDelegate;
	private BusinessLookup businessLookup;

	@Override
	public void init(ServletConfig config) throws ServletException {
		authorActions = new AuthorActions();
		businessDelegate = new BusinessDelegate();
		businessLookup = new BusinessLookup();
		businessDelegate.setBusinessLookup(businessLookup);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.endsWith("/biblioRemote")) {
			businessDelegate.setServiceType(ServiceType.REMOTE);
		} else if (uri.endsWith("/biblioMail")) {
			businessDelegate.setServiceType(ServiceType.MAIl);
		} else {
			businessDelegate.setServiceType(ServiceType.LOCAL);
		}
		this.authorActions.setBusinessDelegate(businessDelegate);
		String view = authorActions.executeAction(new WebContext(request));
		request.getRequestDispatcher("/WEB-INF/views/" + view).forward(request, response);
	}

}
