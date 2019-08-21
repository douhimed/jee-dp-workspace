package org.mql.biblio.business;

public class BiblioLocalServices implements IBiblioServices {

	public BiblioLocalServices() {
	}

	@Override
	public String processService() {
		System.out.println("Processing Local Services");
		return "Processing Local Services";
	}

}
