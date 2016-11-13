package com.tieto.webwicker.api.conf;

import com.tieto.webwicker.api.persistence.PersistenceLayer;

public class Configuration {
	private static Configuration INSTANCE = null;
	
	private PersistenceLayer persistenceLayer = null;
	
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
	
}
