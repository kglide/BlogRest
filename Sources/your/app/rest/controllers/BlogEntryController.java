package your.app.rest.controllers;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXKeyFilter;
import er.rest.routes.ERXDefaultRouteController;
import your.app.model.BlogEntry;

public class BlogEntryController extends ERXDefaultRouteController {

	public BlogEntryController(WORequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public WOActionResults newAction() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WOActionResults updateAction() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WOActionResults destroyAction() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WOActionResults showAction() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WOActionResults createAction() throws Throwable {
		BlogEntry entry = create(filter());
		editingContext().saveChanges();
		return response(entry, filter());
	}

	@Override
	public WOActionResults indexAction() throws Throwable {
		NSArray<BlogEntry> entries = BlogEntry.fetchAllBlogEntries(editingContext());
		return response(entries, filter());
	}
	
	protected ERXKeyFilter filter() {
		ERXKeyFilter personFilter = ERXKeyFilter.filterWithAttributes();
		personFilter.setAnonymousUpdateEnabled(true);
		
		ERXKeyFilter filter = ERXKeyFilter.filterWithAttributes();
		filter.include(BlogEntry.AUTHOR, personFilter);
		filter.setUnknownKeyIgnored(true);
		
		return filter;
	}
	
	@Override
	protected boolean isAutomaticHtmlRoutingEnabled() {
		return true;
	}
}
