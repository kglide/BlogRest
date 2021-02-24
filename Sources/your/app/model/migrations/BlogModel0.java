package your.app.model.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class BlogModel0 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable authorTable = database.newTableNamed("Author");
		authorTable.newStringColumn("email", 100, NOT_NULL);
		authorTable.newStringColumn("firstName", 50, NOT_NULL);
		authorTable.newIntegerColumn("id", NOT_NULL);
		authorTable.newStringColumn("lastName", 50, NOT_NULL);
		authorTable.create();
	 	authorTable.setPrimaryKey("id");

		ERXMigrationTable blogEntryTable = database.newTableNamed("BlogEntry");
		blogEntryTable.newIntegerColumn("authorID", NOT_NULL);
		blogEntryTable.newLargeStringColumn("content", NOT_NULL);
		blogEntryTable.newTimestampColumn("creationDate", NOT_NULL);
		blogEntryTable.newIntegerColumn("id", NOT_NULL);
		blogEntryTable.newTimestampColumn("lastModified", NOT_NULL);
		blogEntryTable.newStringColumn("title", 255, NOT_NULL);
		blogEntryTable.create();
	 	blogEntryTable.setPrimaryKey("id");

		blogEntryTable.addForeignKey("authorID", "Author", "id");
	}
}