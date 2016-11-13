package com.tieto.webwicker.eiffel.web.products;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.fortsoft.pf4j.Extension;

import com.tieto.webwicker.api.web.BasePage;

@Extension
public class ProductPage extends BasePage {
	private static final long serialVersionUID = 2813026533242517627L;

	public ProductPage(PageParameters parameters) {
		super(parameters);
	}
}
