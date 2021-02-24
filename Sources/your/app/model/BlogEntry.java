package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

public class BlogEntry extends _BlogEntry {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(BlogEntry.class);
	

	@Override
	public void awakeFromInsertion(EOEditingContext editingContext) {
		super.awakeFromInsertion(editingContext);
		NSTimestamp now = new NSTimestamp();
		setCreationDate(now);
		setLastModified(now);
	}
}
