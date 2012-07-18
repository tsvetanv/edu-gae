package edu.gae;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class EduGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		UserService uSrvc = UserServiceFactory.getUserService();
		User user = uSrvc.getCurrentUser();

		if (user != null) {
			resp.setContentType("text/plain");
			resp.getWriter().println("Hello, " + user.getNickname() + "!");
		} else {
			resp.sendRedirect(uSrvc.createLoginURL(req.getRequestURI()));
		}
	}
}
