package org.todoapp.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ServletConfig extends GuiceServletContextListener {  
  /**
   * @see com.google.inject.servlet.GuiceServletContextListener#getInjector()
   */
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new GuiceServletModule());
  }
}