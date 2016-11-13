package com.tieto.webwicker.api.source;

import com.tieto.webwicker.api.persistence.PersistenceLayer;

public interface Source extends Runnable {
	void init(PersistenceLayer persistenceLayer);
}
