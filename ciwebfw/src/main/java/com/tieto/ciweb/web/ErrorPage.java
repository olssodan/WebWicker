package com.tieto.ciweb.web;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tieto.ciweb.api.web.WebWickerPage;
import com.tieto.ciweb.api.web.WebWickerPageFactory;

public class ErrorPage extends WebWickerPage {
	private static final long serialVersionUID = -9107302898812653839L;

	public static final int ORDER = 0;

	public ErrorPage(final String id, final PageParameters parameters) {
		super(id);
		add(new Label("page", parameters.get("page").toString()));
    }
	
	public static class ErrorPageFactory extends WebWickerPageFactory {
		private static final long serialVersionUID = 7855045582303692430L;

		@Override
		public WebWickerPage create(String id, PageParameters pageParameters) {
			return new ErrorPage(id, pageParameters);
		}

		@Override
		public boolean isTopLevelPage() {
			return false;
		}

		@Override
		public String getName() {
			return "ERROR";
		}

		@Override
		public int getOrder() {
			return ORDER;
		}
	}
}
