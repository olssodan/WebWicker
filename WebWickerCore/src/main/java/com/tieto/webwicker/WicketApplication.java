package com.tieto.webwicker;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;
import ro.fortsoft.wicket.plugin.PluginManagerInitializer;

import com.tieto.webwicker.api.conf.Configuration;
import com.tieto.webwicker.api.source.Source;
import com.tieto.webwicker.api.web.BasePage;
import com.tieto.webwicker.api.web.TopLevelPage;
import com.tieto.webwicker.persistance.InMemoryStorage;
import com.tieto.webwicker.plugin.WebWickerPluginManager;
import com.tieto.webwicker.web.HomePage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.tieto.ciweb.Start#main(String[])
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
	@SuppressWarnings("unchecked")
	@Override
	public void init()
	{
		super.init();
		
		Configuration.getInstance().setPersistanceLayer(new InMemoryStorage());
		Configuration.getInstance().setStartPageClass((Class<? extends TopLevelPage>) getHomePage());

		PluginManager manager = getPluginManager();
		manager.loadPlugins();
		
		System.err.println("Trying to load all Source classes");
		//List<Class<? extends BasePage>> list = manager.getExtensionClasses(BasePage.class);
		List<Source> list = manager.getExtensions(Source.class);
		System.err.println("Found "+list.size()+" Source extensions");
		
		// Force initiation of configuration
		//for(Class<? extends BasePage> cls : list) {
		//	if(TopLevelPage.class.isAssignableFrom(cls)) {
		//		Configuration.getInstance().addInjectedPage((Class<? extends TopLevelPage>) cls);
		//	}
		//}
		//Source source = new RabbitMQSource();
		//source.init(Configuration.getInstance().getPersistanceLayer());
		//Thread sourceThread = new Thread(source);
		//sourceThread.start();
	}
	
	public PluginManager getPluginManager() {
		return getMetaData(PluginManagerInitializer.PLUGIN_MANAGER_KEY);
	}
}
