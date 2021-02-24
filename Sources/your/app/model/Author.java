package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Author extends _Author {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Author.class);
	
	public String fullName() {
		return this.firstName() + " " + this.lastName();
	}
	
	
}

