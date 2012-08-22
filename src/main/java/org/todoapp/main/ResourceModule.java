package org.todoapp.main;

import com.google.inject.AbstractModule;
public class ResourceModule extends AbstractModule {
  /**
   * @see com.google.inject.AbstractModule#configure()
   */
  @Override
  protected void configure() {
    // Bind Resources
    bind(Resource.class).to(ResourceImpl.class);
  }
}

