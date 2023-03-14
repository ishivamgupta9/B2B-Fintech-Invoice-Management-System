package highradius_project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class EditData
 */
@WebServlet("/editData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
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
		
		//updating value of Invoice Currency = invoice_currency and Customer Payment Terms=cust_payment_terms as invoice_id where tablename is grey_goose.winter_internship
		 
		String invoice_id = request.getParameter("invoice_id");
		String invoice_currency = request.getParameter("invoice_currency");
		String cust_payment_terms = request.getParameter("cust_payment_terms");

		Connection con = DbConnection.createConnect();
		String query = "UPDATE grey_goose.winter_internship SET invoice_currency = '" + invoice_currency
				+ "', cust_payment_terms = '" + cust_payment_terms + "' WHERE invoice_id = '" + invoice_id + "'";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			int rs = ps.executeUpdate();
			response.setHeader("Access-Control-Allow-Origin", "*");
			if (rs > 0) {
				response.getWriter().write("Invoice edited Successfully");
				
			} else {
				response.getWriter().write("Incorrect vlaue");
				
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
//		doGet(request, response);
	}

}
