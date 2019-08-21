package org.mql.biblio.business;

import javax.xml.bind.annotation.XmlRootElement;

import org.mql.biblio.web.models.Author;
import org.mql.biblio.web.models.Publisher;

@XmlRootElement
public class DTO {

	private int authorId, publisherId, authorYearBorn;
	private String authorName, publisherName;
	
	public DTO(int authorId, int publisherId, int authorYearBorn, String authorName, String publisherName) {
		super();
		this.authorId = authorId;
		this.publisherId = publisherId;
		this.authorYearBorn = authorYearBorn;
		this.authorName = authorName;
		this.publisherName = publisherName;
	}

	public static DTO getDTO(Author author, Publisher publisher) {
		return new DTO(author.getId(), publisher.getId(), author.getYearBorn(), author.getName(), publisher.getName());
	}

}
