package com.tieto.webwicker.api.source;

import ro.fortsoft.pf4j.ExtensionPoint;

import com.tieto.webwicker.api.persistence.PersistenceLayer;

public abstract class Source implements Runnable {
	public abstract void init(PersistenceLayer persistenceLayer);
}
