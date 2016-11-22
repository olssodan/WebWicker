package com.tieto.ciweb.web.projects;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tieto.ciweb.api.web.WebWickerPage;
import com.tieto.ciweb.api.web.WebWickerPageFactory;

public class ProjectsPage extends WebWickerPage {
	private static final long serialVersionUID = -9107302898812653839L;

	public static final int ORDER = 200;

	public ProjectsPage(final String id, final PageParameters parameters) {
		super(id);

		// TODO Add your page's components here
    }
	
	public static class ProjectsPageFactory extends WebWickerPageFactory {
		private static final long serialVersionUID = -6367835868232059889L;

		@Override
		public WebWickerPage create(String id, PageParameters pageParameters) {
			return new ProjectsPage(id, pageParameters);
		}

		@Override
		public boolean isTopLevelPage() {
			return true;
		}

		@Override
		public String getName() {
			return "Projects";
		}

		@Override
		public int getOrder() {
			return ORDER;
		}
		
	}
}
