package in.nit.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.Stoppable;

import in.nit.model.User;
import in.nit.service.UserService;
import in.nit.service.ValidateUser;
import in.nit.util.Stopwatch;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession();
		String username=req.getParameter("username");
        String password=req.getParameter("password");
        ses.setMaxInactiveInterval(20);
        try {
        System.out.println("Attribute value :"+ses.getAttribute("success"));
        System.out.println("Session creation time "+new Date(ses.getCreationTime()));
        System.out.println("Session Id :"+ses.getId());
        System.out.println("Last Accessed time :"+new Date(ses.getLastAccessedTime()));
        System.out.println("Max in active time interval: "+ ses.getMaxInactiveInterval());
        System.out.println(ses.getServletContext());
        System.out.println(ses.getSessionContext());
        System.out.println(ses.isNew());
        System.out.println("Session Id come in Cookie :"+req.isRequestedSessionIdFromCookie());
     
        System.out.println("Session Id come from Url :"+req.isRequestedSessionIdFromUrl());
        System.out.println("Session Id come from URL :"+req.isRequestedSessionIdFromURL());
        System.out.println("Session Id valid :"+req.isRequestedSessionIdValid());
        System.out.println("Remote Addrs :"+req.getRemoteAddr());
        System.out.println("Remote Host :"+req.getRemoteHost());
        System.out.println("Remote Port valid :"+req.getRemotePort());
        System.out.println("Remote User  :"+req.getRemoteUser());
         boolean validateUser = ValidateUser.validateUser(username, password);
         User user = UserService.getUser(password);
         if(validateUser) {
        	
        	 ses.setAttribute("valid",true);
        	 ses.setAttribute("user",user);
        	 ses.setAttribute("auth",username+" successfully login");
        	 //Stopwatch.countDown(ses);
        	 
        			 
        	req.getRequestDispatcher("home.jsp").forward(req, resp);
        	 
         }
         else {
        	 ses.setAttribute("error",username+" Authentication Failed");
             resp.sendRedirect("login.jsp");
         }
        }catch (Exception e) {
			// TODO: handle exception
		}
        
	
	}
}
