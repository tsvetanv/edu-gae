package edu.gae.secret.communicator.controller;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import edu.gae.secret.communicator.dao.MessageDAO;
import edu.gae.secret.communicator.model.Message;

@SuppressWarnings("serial")
public class EduGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		// UserService uSrvc = UserServiceFactory.getUserService();
		// User user = uSrvc.getCurrentUser();
		//
		// if (user != null) {
		// resp.setContentType("text/plain");
		// resp.getWriter().println("Hello, " + user.getNickname() + "!");
		// } else {
		// resp.sendRedirect(uSrvc.createLoginURL(req.getRequestURI()));
		// }
		Message msg = new Message();
		msg.setContent("Proba-2");

		MessageDAO msgDAO = new MessageDAO();
		Key key = msgDAO.storeMessage(msg);

		Message message = msgDAO.getMessage(key);

		resp.setContentType("text/plain");
		resp.getWriter().println("Extracted: " + message.getContent());
		// write msg.getContent() to the response

	}
}
