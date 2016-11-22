package com.tieto.webwicker;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import ro.fortsoft.pf4j.PluginManager;
import ro.fortsoft.wicket.plugin.PluginManagerInitializer;

import com.tieto.webwicker.api.conf.Configuration;
import com.tieto.webwicker.api.web.WebWickerPageFactory;
import com.tieto.webwicker.persistance.InMemoryStorage;
import com.tieto.webwicker.web.ErrorPage.ErrorPageFactory;
import com.tieto.webwicker.web.HomePage;
import com.tieto.webwicker.web.StartPage.StartPageFactory;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.tieto.webwicker.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		
		Configuration.getInstance().setPersistanceLayer(new InMemoryStorage());
		Configuration.getInstance().setMainPageClass(getHomePage());
		Configuration.getInstance().setHomePageFactory(new StartPageFactory());
		Configuration.getInstance().setErrorPageFactory(new ErrorPageFactory());

		PluginManager manager = getPluginManager();
		
		System.err.println("Trying to load all WebWickerPageFactory classes");
		List<WebWickerPageFactory> list = manager.getExtensions(WebWickerPageFactory.class);
		System.err.println("Found "+list.size()+" WebWickerPageFactory extensions");
		for(WebWickerPageFactory factory : list) {
			Configuration.getInstance().setPageFactory(factory.getPageClassName(), factory);
		}
		
		// Force initiation of configuration
		//Source source = new RabbitMQSource();
		//source.init(Configuration.getInstance().getPersistanceLayer());
		//Thread sourceThread = new Thread(source);
		//sourceThread.start();
	}
	
	public PluginManager getPluginManager() {
		return getMetaData(PluginManagerInitializer.PLUGIN_MANAGER_KEY);
	}
}
