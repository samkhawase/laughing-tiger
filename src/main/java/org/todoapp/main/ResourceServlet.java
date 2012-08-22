package org.todoapp.main;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;

@Singleton
public class ResourceServlet extends HttpServlet {

	private static final long serialVersionUID = 5539084588355488784L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// PrintWriter out = resp.getWriter();
		// out.print("response from Mars");
		Map<String, String[]> params = req.getParameterMap();

		for (Map.Entry<String, String[]> item : params.entrySet()) {
			resp.getWriter().println("Key: " + item.getKey());
			for(String val: item.getValue())
				resp.getWriter().println("value: "+val);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> params = req.getParameterMap();

		for (Map.Entry<String, String> item : params.entrySet())
			resp.getWriter().println(
					"Key:" + item.getKey() + " Value: " + item.getValue());
	}

}
