package com.tieto.webwicker;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.tieto.webwicker.api.source.Source;
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
	@Override
	public void init()
	{
		super.init();
		
		// Force initiation of configuration
		Configuration.getInstance();
		
		//Source source = new RabbitMQSource();
		//source.init(Configuration.getInstance().getPersistanceLayer());
		//Thread sourceThread = new Thread(source);
		//sourceThread.start();
	}
}
