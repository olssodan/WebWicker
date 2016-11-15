package com.tieto.webwicker.plugin;

import java.util.ArrayList;
import java.util.List;

import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.ExtensionWrapper;

public class WebWickerPluginManager extends DefaultPluginManager {
	@SuppressWarnings("unchecked")
	public <T> List<Class<? extends T>> getExtensionClasses(Class<T> cls) {
		List<Class<? extends T>> result = new ArrayList<Class<? extends T>>();
		for(ExtensionWrapper<T> ew : extensionFinder.find(cls)) {
			result.add((Class<? extends T>) ew.getDescriptor().getExtensionClass());
		}
		return result;
	}
}
