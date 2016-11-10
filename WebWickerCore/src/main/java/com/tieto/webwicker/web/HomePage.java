package com.tieto.webwicker.web;

import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.tieto.webwicker.api.web.BasePage;
import com.tieto.webwicker.api.web.TopLevelPage;

public class HomePage extends BasePage implements TopLevelPage {
	private static final long serialVersionUID = -7626368252793216083L;

	public static final int ORDER = 0;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
    }
	
}
