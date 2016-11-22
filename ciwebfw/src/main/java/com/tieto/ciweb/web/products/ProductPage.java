package com.tieto.ciweb.web.products;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tieto.ciweb.api.web.WebWickerPage;
import com.tieto.ciweb.api.web.WebWickerPageFactory;

public class ProductPage extends WebWickerPage {
	private static final long serialVersionUID = 2813026533242517627L;

	public ProductPage(String id, PageParameters parameters) {
		super(id);
	}
	
	public static class ProductPageFactory extends WebWickerPageFactory {
		private static final long serialVersionUID = -4475762206198663467L;

		@Override
		public WebWickerPage create(String id, PageParameters pageParameters) {
			return new ProductPage(id, pageParameters);
		}

		@Override
		public boolean isTopLevelPage() {
			return false;
		}

		@Override
		public String getName() {
			return "Product";
		}

		@Override
		public int getOrder() {
			return 0;
		}
		
	}
}
