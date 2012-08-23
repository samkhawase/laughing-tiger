package org.todoapp.main;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;

public class GuiceServletModule extends ServletModule {
  /**
   * Configure servlets and filters. This function is called in the super class
   * in the configure() module method. Add here all the bindings for the module.
   * @see com.google.inject.servlet.ServletModule#configureServlets()
   */
  protected void configureServlets() {
    // Resources can be binded here or in a separate module.
    install(new ResourceModule());
    
    // Create the parameter map for the Main servlet.
    Map<String, String> params = new HashMap<String, String>();
    
    serve("/post/*").with(ResourceServlet.class, params);
    
    // generic catchall route at last
    serve("/item").with(MainServlet.class, params);
    
  }
}