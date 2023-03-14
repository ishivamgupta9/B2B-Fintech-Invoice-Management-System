package highradius_project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class Delete_data
 */
@WebServlet("/delete")
public class Delete_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = DbConnection.createConnect();
		String field = request.getParameter("item");
		int sl_no = Integer.parseInt(field);
		
	
		String query = "DELETE FROM grey_goose.winter_internship WHERE sl_no in (?)";
		

			PreparedStatement st;
			try {
				st = con.prepareStatement(query);
				st.setInt(1, sl_no);
				int rs = st.executeUpdate();
				if (rs > 0) {
					response.getWriter().write("Data deletde Successfully");
					response.setHeader("Access-Control-Allow-Origin", "*");
				} else {
					response.getWriter().write("Something went Wrong");
					response.setHeader("Access-Control-Allow-Origin", "*");
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
//		doGet(request, response);
	}

}
