package org.mql.biblio.dao.mappers;
import org.mql.biblio.web.models.Publisher;

public class PublisherMapper {

	public static Publisher toPublisher(String[] data) {
		int id = getIntegerValue(data[0]);
		String name = data[1];
		String company = data[2];
		return new Publisher(id, name, company);
	}


	public static String[] toArray(Publisher  publisher) {		
		String[] data =  {String.valueOf(publisher.getId()), publisher.getName(), publisher.getCompany()};
		return data;
	}
	
	private static int getIntegerValue(String valaue) {
		try {
			return Integer.parseInt(valaue);
		} catch (Exception e) {
			return 0;
		}
	}
	

}
