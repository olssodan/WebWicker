package com.tieto.ciweb.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tieto.ciweb.api.web.WebWickerPage;
import com.tieto.ciweb.api.web.WebWickerPageFactory;

public class StartPage extends WebWickerPage {
	private static final long serialVersionUID = -9107302898812653839L;

	public static final int ORDER = 0;

	public StartPage(final String id, final PageParameters parameters) {
		super(id);
    }
	
	public static class StartPageFactory extends WebWickerPageFactory {

		@Override
		public WebWickerPage create(String id, PageParameters pageParameters) {
			return new StartPage(id, pageParameters);
		}

		@Override
		public boolean isTopLevelPage() {
			return true;
		}

		@Override
		public String getName() {
			return "Home";
		}

		@Override
		public int getOrder() {
			return ORDER;
		}
		
	}
}
