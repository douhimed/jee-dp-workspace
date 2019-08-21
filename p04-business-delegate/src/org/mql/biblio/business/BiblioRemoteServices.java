package org.mql.biblio.business;

public class BiblioRemoteServices implements IBiblioServices {

	public BiblioRemoteServices() {
	}

	@Override
	public String processService() {
		System.out.println("Processing Remoting Services");
		return "Processing Remoting Services";
	}

}
