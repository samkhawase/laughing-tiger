package org.todoapp.main;

import com.google.inject.Singleton;

@Singleton
public class ResourceImpl implements Resource {

	public String getResource() {
		return "This resource was injected by Guice.";
	}
}