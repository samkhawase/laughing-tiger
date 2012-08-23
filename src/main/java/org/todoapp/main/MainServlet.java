package org.todoapp.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.models.Tag;
import org.java.models.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.Transactional;

@Singleton
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 8816935511643883967L;
	private final Resource resource;
	private static final Logger logger = LoggerFactory
			.getLogger(MainServlet.class);

	/**
	 * Constructor called by Guice.
	 */
	@Inject
	MainServlet(Resource resource, PersistService persistService) {
		this.resource = resource;
		persistService.start();
	}

	@Inject
	EntityManagerFactory emf;

	@Inject
	EntityManager em;

	@Transactional
	public void createNewTask() {
		try {
			em.getTransaction().begin();

			logger.info("inside createTask()");
			Tag personal = new Tag("personal");
			Tag work = new Tag("work");
			List<Tag> tags = new ArrayList<Tag>();
			tags.add(personal);
			tags.add(work);

			Task t = new Task("buy fruits", Calendar.getInstance().getTime(),
					1, false, tags);

			em.persist(personal);
			em.persist(work);
			em.persist(t);

			em.flush();

			logger.info("leaving createTask()");

			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Task> findTask() {

		logger.info("inside findTask()");

		return em.createQuery("select t from Task t").getResultList();
		// .getSingleResult();
		// logger.info("Task t: " + t.getTaskName());

		// Query qry = em.createNamedQuery("Task.Query1");
		// List<Task> list = qry.getResultList();
		// return list;
	}

	/**
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// logger.info("writing message to screen");
		// response.getWriter().print("Guice Demo Application\n");
		// response.getWriter().print(resource.getResource());

		logger.info("attempting to create new Task");
		createNewTask();
		
		/*
		List<Task> results = findTask();
		response.getWriter().println("results size " + results.size());
		for (Task task : results) {
			response.getWriter().println(
					"get the Task created: " + "" + task.getTaskId() + " "
							+ task.getTaskName() + " " + task.getCreatedDate()
							+ " " + task.getPriority());
		}
		*/
//		request.setAttribute("$$Guice$RDR", Boolean.TRUE);
//		logger.info("redirecting...");
		System.err.println(request.getContextPath()+" - redirecting to jsp...");
		request.getRequestDispatcher("/WEB-INF/todo/index.jsp").forward(request, response);
//		response.sendRedirect("/WEB-INF/todo/index.jsp");
		
	}
}
