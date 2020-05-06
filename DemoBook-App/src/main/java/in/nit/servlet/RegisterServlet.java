package in.nit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.nit.model.User;
import in.nit.service.UserService;
@WebServlet("/register")
@MultipartConfig(maxFileSize = 1024*1024*10,
 fileSizeThreshold = 1024*1024*20,
 maxRequestSize = 1024*1024*30)
public class RegisterServlet extends HttpServlet {

	
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             HttpSession ses=req.getSession(true);
             System.out.println(ses);
             String path="assets/images";
             
		try {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String mobile = req.getParameter("mobile");
			String photo = req.getParameter("photo");
			System.out.println("photo locatiom "+photo);
			User user=new User();
			user.setUserName(username);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setPassword(password);
			/*
			 * String upload = UploadUtil.upload(path, req); if(upload!=null) {
			 * user.setPhotos(upload);
			 * 
			 * } req.setAttribute("user", user);
			 */
		   Integer id=UserService.saveUser(user,req);
		   req.setAttribute("error", "User "+id+" Registered Successfully");
		
			req.getRequestDispatcher("register.jsp").forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("excepton in register");
			req.setAttribute("error", "User Registration failed");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
            
		
		}
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
