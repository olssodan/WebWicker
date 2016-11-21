package com.tieto.ciweb.web;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.wicket.StyleAttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.reflections.Reflections;

import com.tieto.ciweb.Configuration;
import com.tieto.ciweb.api.web.WebWickerPageFactory;

public class HomePage extends WebPage {
	private static final long serialVersionUID = -7626368252793216083L;
	private final transient Reflections reflections = new Reflections("com.tieto.ciweb");
	private List<WebWickerPageFactory> subPages;
	
	public static final int ORDER = 0;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HomePage(final PageParameters parameters) {
		super(parameters);
		RepeatingView listItems = new RepeatingView("listItems");
		subPages = initiateSubPages();

		for(final WebWickerPageFactory subPage : subPages) {
			PageParameters params = new PageParameters();
			params.add("page", subPage.getName());
			WebMarkupContainer list = new WebMarkupContainer(listItems.newChildId());
			BookmarkablePageLink link = new BookmarkablePageLink("Link", getClass(), params);
			link.add(new Label("Text", subPage.getName()));
			if(pageMatchesLink(parameters.get("page").toString(), subPage.getName())) {
				link.add(StyleAttributeModifier.append("class", "active"));
			}
			list.add(link);
	        listItems.add(list);
		}
		
		add(listItems);
		add(Configuration.getInstance().getPageFactory(parameters.get("page").toString("Home")).create("webwickerpanel", parameters));
	}
	
	private boolean pageMatchesLink(final String page, final String name) {
		if(page == null) {
			return "Home".equals(name);
		}
		return page.equals(name);
	}

	private final List<WebWickerPageFactory> initiateSubPages() {
		List<WebWickerPageFactory> subPages = new LinkedList<>();
		
		Set<Class<? extends WebWickerPageFactory>> factories = reflections.getSubTypesOf(WebWickerPageFactory.class);
		for(Class<? extends WebWickerPageFactory> factoryClass : factories) {
			try {
				WebWickerPageFactory factory = factoryClass.getDeclaredConstructor().newInstance();
				if(factory.isTopLevelPage()) {
					subPages.add(factory);
				}
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				System.out.println("Could not instantiate the factory class "+factoryClass.getName());
			}
		}
		
		subPages.sort(new Comparator<WebWickerPageFactory>() {
			@Override
			public int compare(WebWickerPageFactory o1, WebWickerPageFactory o2) {
				int o1value = o1.getOrder();
				int o2value = o2.getOrder();
				if(o1value == o2value) {
					return o1.getName().compareTo(o2.getName());
				} else {
					return o1value - o2value;
				}
			}
		});
		return subPages;
    }
	
}
