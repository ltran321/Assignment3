package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Employee;
import dao.DBUtil;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registrationservlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String hireDateString = request.getParameter("hireDate");
		
		//Convert hireDate String to Date
		Date hireDate = null;
		try {
			hireDate = new SimpleDateFormat("yyyy-MM-dd").parse(hireDateString);
			
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee e1 = new Employee();
		e1.setFirstname(firstName);
		e1.setLastname(lastName);
		e1.setUsername(username);
		e1.setPassword(password);
		e1.setEmail(email);
		e1.setHireDate(hireDate);
		
		try {
			int record =  DBUtil.registerEmployee(e1);
			if (record > 0) {
				response.sendRedirect("Login.jsp?message=Registration successful");
			} else {
				response.sendRedirect("signup.jsp?error=Registration failed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
