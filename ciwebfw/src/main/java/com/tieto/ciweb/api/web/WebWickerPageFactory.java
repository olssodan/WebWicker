package com.tieto.ciweb.api.web;

import java.io.Serializable;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public abstract class WebWickerPageFactory implements Serializable {
	private static final long serialVersionUID = -3035912325568545954L;

	public abstract WebWickerPage create(String id, PageParameters pageParameters);
	
	public abstract boolean isTopLevelPage();
	public abstract int getOrder();
	
	public abstract String getName();
}
