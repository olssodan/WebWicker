package com.tieto.ciweb;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.tieto.ciweb.api.source.Source;
import com.tieto.ciweb.source.rabbitmq.RabbitMQSource;
import com.tieto.ciweb.web.HomePage;
import com.tieto.ciweb.web.StartPage;
import com.tieto.ciweb.web.commits.CommitPage;
import com.tieto.ciweb.web.commits.CommitsPage;

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
		
		Source source = new RabbitMQSource();
		source.init(Configuration.getInstance().getPersistanceLayer());
		Thread sourceThread = new Thread(source);
		sourceThread.start();
		
		Configuration.getInstance().setMainPageClass(HomePage.class);
		Configuration.getInstance().setPageFactory("Home", new StartPage.StartPageFactory());
		Configuration.getInstance().setPageFactory("Commits", new CommitsPage.CommitsPageFactory());
		Configuration.getInstance().setPageFactory("Commit", new CommitPage.CommitPageFactory());
	}
}
