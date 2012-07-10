package edu.gae;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class EduGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, Cloud! I'm coming!");
	}
}
