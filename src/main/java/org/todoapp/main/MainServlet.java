package org.todoapp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 8816935511643883967L;
	private final Resource resource;

	/**
	 * Constructor called by Guice.
	 */
	@Inject
	MainServlet(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print("Guice Demo Application\n");
		response.getWriter().print(resource.getResource());
	}
}
