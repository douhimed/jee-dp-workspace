package org.mql.biblio.console;

import org.mql.biblio.business.BusinessDelegate;
import org.mql.biblio.business.BusinessLookup;
import org.mql.biblio.business.ServiceType;

public class App {

	private BusinessLookup businessLookup;
	private BusinessDelegate businessDelegate;

	public App() {
		init();
		exp02();
	}

	private void exp01() {
		businessDelegate.setServiceType(ServiceType.LOCAL);
		businessDelegate.executeService();
	}

	private void exp02() {
		businessDelegate.setServiceType(ServiceType.REMOTE);
		businessDelegate.executeService();
	}

	private void init() {
		businessDelegate = new BusinessDelegate();
		businessLookup = new BusinessLookup();
		businessDelegate.setBusinessLookup(businessLookup);
	}

	public static void main(String[] args) {
		new App();
	}

}
