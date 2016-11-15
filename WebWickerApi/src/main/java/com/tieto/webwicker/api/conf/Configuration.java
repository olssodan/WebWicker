package com.tieto.webwicker.api.conf;

import java.util.LinkedList;
import java.util.List;

import com.tieto.webwicker.api.persistence.PersistenceLayer;
import com.tieto.webwicker.api.web.TopLevelPage;

public class Configuration {
	private static Configuration INSTANCE = null;
	
	private PersistenceLayer persistenceLayer = null;
	private Class<? extends TopLevelPage> startPageClass = null;
    private List<Class<? extends TopLevelPage>> injectedPages = new LinkedList<>();
	
	public static final Configuration getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Configuration();
		}
		return INSTANCE;
	}

	private Configuration() {
	}
	
	public void setPersistanceLayer(final PersistenceLayer persistanceLayer) {
		if(this.persistenceLayer == null) {
			this.persistenceLayer = persistanceLayer;
		}
	}
	
	public PersistenceLayer getPersistenceLayer() {
		return persistenceLayer;
	}
	
	public void setStartPageClass(Class<? extends TopLevelPage> pageClass) {
		if(this.startPageClass == null) {
			this.startPageClass = pageClass;
		}
	}
	
	public Class<? extends TopLevelPage> getStartPageClass() {
		return this.startPageClass;
	}
	
	public List<Class<? extends TopLevelPage>> getInjectedPages() {
		return injectedPages;
	}
	
	public void addInjectedPage(Class<? extends TopLevelPage> pageClass) {
		injectedPages.add(pageClass);
	}
}
