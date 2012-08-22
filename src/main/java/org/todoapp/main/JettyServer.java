package org.todoapp.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

public class JettyServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler root = new ServletContextHandler(server, "/",
				ServletContextHandler.SESSIONS);

		root.addEventListener(new ServletConfig());
		root.addFilter(GuiceFilter.class, "/*", 0);
		root.addServlet(MainServlet.class, "/*");

		server.start();
		server.join();
	}
}
