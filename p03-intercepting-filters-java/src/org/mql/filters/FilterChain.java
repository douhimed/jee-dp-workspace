package org.mql.filters;

import java.util.ArrayList;
import java.util.List;

import org.mql.Actions.Target;

public class FilterChain {

	private List<IFilter> filters = new ArrayList<IFilter>();
	private Target target;

	public void addFilter(IFilter filter) {
		filters.add(filter);
	}

	public void execute(String request) {
		filters.forEach(f -> f.process(request));
		target.execute(request);
	}

	public void setTarget(Target target) {
		this.target = target;
	}
}
