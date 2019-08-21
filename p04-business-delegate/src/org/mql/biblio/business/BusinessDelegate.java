package org.mql.biblio.business;

public class BusinessDelegate {

	private IBiblioServices biblioServices;
	private ServiceType serviceType;
	private BusinessLookup businessLookup;
	
	public String executeService() {
		biblioServices = this.businessLookup.getBusinesService(this.serviceType);
		return biblioServices.processService();
	}
	
	public void setBusinessLookup(BusinessLookup businessLookup) {
		this.businessLookup = businessLookup;
	}
	
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

}
