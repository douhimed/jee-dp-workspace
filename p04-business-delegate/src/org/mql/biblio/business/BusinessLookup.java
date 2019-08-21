package org.mql.biblio.business;

public class BusinessLookup {

	private BiblioLocalServices localServices;
	private BiblioRemoteServices remoteServices;
	private BiblioMailServices mailServices;

	{
		localServices = new BiblioLocalServices();
		remoteServices = new BiblioRemoteServices();
		mailServices = new BiblioMailServices();
	}

	public IBiblioServices getBusinesService(ServiceType type) {
		if (ServiceType.REMOTE.equals(type))
			return this.remoteServices;
		else if (ServiceType.MAIl.equals(type))
			return this.mailServices;
		return this.localServices;
	}

	public void setRemoteServices(BiblioRemoteServices remoteServices) {
		this.remoteServices = remoteServices;
	}

	public void setLocalServices(BiblioLocalServices localServices) {
		this.localServices = localServices;
	}

	public void setMailServices(BiblioMailServices mailServices) {
		this.mailServices = mailServices;
	}

}
