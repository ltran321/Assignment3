package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username != null & !username.isEmpty() & password != null & !password.isEmpty()) {
			try {
				Connection conn = DBUtil.getConnection();
				String selectQuery = "SELECT * FROM employee where username= ? AND password = ?";

				PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);

				ResultSet result = preparedStatement.executeQuery();

				if (result.next()) {
					// get the users firstname
					String firstname = result.getString("firstName");
					response.sendRedirect("success.jsp?firstName=" + firstname);
				} else {
					// if no user found send error message
					response.sendRedirect("Login.jsp?error=Invalid username or password");
				}
				conn.close();

			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		}
		else {
			// if fields empty send error message
			response.sendRedirect("Login.jsp?error=Username or Password cannot be empty");
		}
	}

}
