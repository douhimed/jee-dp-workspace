package org.mql.filters;

public class DebugFilter implements IFilter {

	public DebugFilter() {
	}

	@Override
	public void process(String request) {
	      System.out.println("Debug request: " + request);
	}

}
