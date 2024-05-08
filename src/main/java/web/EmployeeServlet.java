package web;

import java.io.IOException;
import java.util.List;

import bean.Employee;
import dao.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			List<Employee> employees = DBUtil.getEmployeesFromDatabase();
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("employees.jsp").forward(request, response);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
