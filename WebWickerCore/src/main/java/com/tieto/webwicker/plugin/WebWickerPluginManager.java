package com.tieto.webwicker.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.ExtensionWrapper;

public class WebWickerPluginManager {

	public void loadExternalJars(){
		final String jarPaths = "plugin.jars";

		if (jarPaths != null) {
			final ClassLoader currentThreadClassLoader = Thread.currentThread().getContextClassLoader();

			// Add the jars to the classpath
			// Chain the current thread classloader
			final ArrayList<URL> urlsList = new ArrayList<URL>();
			for (final String jar : jarPaths.split(",")) {
				try {
					urlsList.add(new File(jar).toURI().toURL());
				} catch (final MalformedURLException e) {
					System.err.println("Error loading external JARs. Could not convert '"+jar+"' to an URL so it is skipped. Cause: " + e.getMessage());
				}
			}
			final URL[] urls = new URL[urlsList.size()];
			urlsList.toArray(urls);
			try {
				final URLClassLoader urlClassLoader = new URLClassLoader(urls, currentThreadClassLoader);

				// Replace the thread classloader - assumes
				// you have permissions to do so
				Thread.currentThread().setContextClassLoader(urlClassLoader);

			} catch (final SecurityException e){
				System.err.println("Error loading external JAR due to: " + e.getMessage());
			}
		}
	}
}
