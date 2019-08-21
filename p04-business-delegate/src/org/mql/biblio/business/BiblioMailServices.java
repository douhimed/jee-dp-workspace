package org.mql.biblio.business;

public class BiblioMailServices implements IBiblioServices {

	public BiblioMailServices() {
	}

	@Override
	public String processService() {
		System.out.println("Processing Messaging Services");
		return "Processing Messaging Services";
	}

}
