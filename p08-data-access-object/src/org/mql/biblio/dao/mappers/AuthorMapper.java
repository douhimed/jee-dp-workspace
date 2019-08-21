package org.mql.biblio.dao.mappers;

import org.mql.biblio.web.models.Author;

public class AuthorMapper {

	public static Author toAuthor(String[] data) {
		int id = getIntegerValue(data[0]);
		String name = data[1];
		int yearBorn = getIntegerValue(data[2]);
		return new Author(id, name, yearBorn);
	}

	public static String[] toArray(Author author) {		
		String[] data =  {String.valueOf(author.getId()), author.getName(), String.valueOf(author.getYearBorn())};
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
