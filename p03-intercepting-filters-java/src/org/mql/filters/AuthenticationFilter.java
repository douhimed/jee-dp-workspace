package org.mql.filters;

public class AuthenticationFilter implements IFilter {

	public AuthenticationFilter() {
	}

	@Override
	public void process(String request) {
		  System.out.println("Authentification filter : " + request);
	}

}
