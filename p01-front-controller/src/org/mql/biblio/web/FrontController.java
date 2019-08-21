package org.mql.biblio.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.biblio.actions.AbstractAction;
import org.mql.biblio.actions.AuthorAction;
import org.mql.biblio.actions.BookAction;
import org.mql.biblio.actions.ErrorAction;

public class FrontController extends HttpServlet {

	private static AbstractAction action;
	private String view = "Error";
	private String actionName = "";
	private String preffix = "/WEB-INF/views/";
	private String suffix = ".jsp";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.endsWith("/authors"))
			action = new AuthorAction("authorsList");
		else if (uri.endsWith("/author"))
			action = new AuthorAction("authorProfil");
		else if (uri.endsWith("/books") || uri.endsWith("/biblio") || uri.endsWith("/biblio/"))
			action = new BookAction("booksList");
		else if (uri.endsWith("/book"))
			action = new BookAction("bookDetails");
		else
			action = new ErrorAction("notFound");
		view = action.execute();
		req.getRequestDispatcher(preffix + view + suffix).forward(req, resp);
	}
}
