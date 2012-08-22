package org.todoapp.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;

public class ServletConfig extends GuiceServletContextListener {
	/**
	 * @see com.google.inject.servlet.GuiceServletContextListener#getInjector()
	 */
	@Override
	protected Injector getInjector() {

//		Injector injector = Guice.createInjector(new JpaPersistModule("myFirstJpaUnit"));
		return Guice.createInjector(new GuiceServletModule(), new JpaPersistModule("myFirstJpaUnit"));
	}
}