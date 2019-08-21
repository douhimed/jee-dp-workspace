package org.mql;

import org.mql.Actions.Target;
import org.mql.filters.AuthenticationFilter;
import org.mql.filters.DebugFilter;
import org.mql.filters.FilterManager;

public class Client {

	private FilterManager filterManager;
	
	public Client() {
		exp01();
	}

	private void exp01() {
		filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new DebugFilter());
		filterManager.filterRequest("GET HTTP/1.0 Authors");
	}

	public static void main(String[] args) {
		new Client();
	}

}
