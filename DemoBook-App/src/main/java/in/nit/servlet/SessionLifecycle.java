package in.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session")
public class SessionLifecycle extends HttpServlet{

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    
     
		// getting current HttpSession associated with this request or, if there
		// is no current session and create is true, returns a new session.
		HttpSession session = request.getSession();
     System.out.println("session "+session);
		// Calculating Hit Count
		Integer count = (Integer) session
		.getAttribute("SessionExample.HitCount");
		System.out.println("count :"+session.getAttribute("SessionExample.HitCount"));
		if (count == null)
		count = new Integer(1);
		else
		count = new Integer(count.intValue() + 1);
		session.setAttribute("SessionExample.HitCount", count);

		out.println("<HTML><HEAD><TITLE>SessionExample</TITLE></HEAD>");
		out.println("<BODY><H1>Example session servlet to "
		+ "demostrate session tracking and life cycle</H1>");

		// Displaying the hit count
		out.println("Hit count for your current session is " + count);

		out.println("<H2>Some basic session information:</H2>");
		out.println("Session ID: " + session.getId() + "</BR>");
		out.println("Is it a new session: " + session.isNew() + "</BR>");
		out.println("Session Creation time: " + session.getCreationTime());
		out.println("(" + new Date(session.getCreationTime()) + ")</BR>");
		out.println("Last accessed time: " + session.getLastAccessedTime());
		out.println("(" + new Date(session.getLastAccessedTime()) + ")</BR>");
	
		  session.setMaxInactiveInterval(10);
		out.println("Max in active time interval: "
				+ session.getMaxInactiveInterval() + "</BR>");
		// Checks whether the requested session ID came in as a cookie
		out.println("Session ID came in as a cookie: "
		+ request.isRequestedSessionIdFromCookie() + "</BR>");

		out.println("<H2>Iteratively printing all the values "
		+ "associated with the session:</H2>");
		Enumeration names = session.getAttributeNames();
		while (names.hasMoreElements()) {
		String name = (String) names.nextElement();
		String value = session.getAttribute(name).toString();
		out.println(name + " = " + value + "</BR>");
		}

		out.println("</BODY></HTML>");
		}
		
}
