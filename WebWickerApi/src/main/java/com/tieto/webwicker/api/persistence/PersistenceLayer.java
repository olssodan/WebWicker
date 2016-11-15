package com.tieto.webwicker.api.persistence;

import java.util.List;

import ro.fortsoft.pf4j.ExtensionPoint;

import com.google.gson.JsonObject;

public abstract class PersistenceLayer implements ExtensionPoint {
	public abstract void store(String collection, JsonObject object, String id);
	
	public abstract JsonObject fetchOneWithId(String collection, String id);
	public abstract JsonObject fetchOne(String collection, String query);
	public abstract List<JsonObject> fetchMany(String collection, String sortBy, boolean sortAscending, String query);
	
	public abstract long count(String collection, String query);
}
