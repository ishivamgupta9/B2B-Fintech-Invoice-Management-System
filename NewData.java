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
 * Servlet implementation class NewData
 */
@WebServlet("/newData")
public class NewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String business_code = request.getParameter("business_code");
		int cust_number = Integer.parseInt(request.getParameter("cust_number"));
		String clear_date = request.getParameter("clear_date");
		String doc_id = request.getParameter("doc_id");
		
		String buisness_year = request.getParameter("buisness_year");
		String posting_date = request.getParameter("posting_date");
		String document_create_date = request.getParameter("document_create_date");
		String due_in_date = request.getParameter("due_in_date");
		String invoice_currency = request.getParameter("invoice_currency");
		String document_type = request.getParameter("document_type");
		int posting_id = Integer.parseInt(request.getParameter("posting_id"));
		double total_open_amount = Double.parseDouble(request.getParameter("total_open_amount"));
		String baseline_create_date = request.getParameter("baseline_create_date");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		int invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
		
		
		
		//table name is winter_internship , customer foregin key is cust_number
		// foreign key constraint  (`grey_goose`.`winter_internship`, CONSTRAINT `cust_numberFK` FOREIGN KEY (`cust_number`) REFERENCES `customer` (`cust_number`))

		// "CONSTRAINT `business_codeFK` FOREIGN KEY (`business_code`) REFERENCES `business` (`business_code`),CONSTRAINT `cust_numberFK` FOREIGN KEY (`cust_number`) REFERENCES `customer` (`cust_number`)"

		//inserting business_code inside business table, and cust_number inside customer table and then inserting into winter_internship table 




		
		
		
	
		try {
			
			Connection con = DbConnection.createConnect();
			 
			 String query= "INSERT INTO `grey_goose`.`winter_internship` (`sl_no`,`business_code`, `cust_number`, `clear_date`, `buisness_year`, `doc_id`, `posting_date`, `document_create_date`, `due_in_date`, `invoice_currency`, `document_type`,  `posting_id`,  `total_open_amount`, `baseline_create_date`,  `cust_payment_terms`,  `invoice_id` ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 
		
			
			//selecting last element of sl_no

			 
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, SlNo.sl_no());
			ps.setString(2, business_code);
			ps.setInt(3, cust_number);
			ps.setString(4, clear_date);
			ps.setString(5, buisness_year);
			ps.setString(6, doc_id);
			ps.setString(7, posting_date);
			ps.setString(8, document_create_date);
			ps.setString(9, due_in_date);
			ps.setString(10, invoice_currency);
			ps.setString(11, document_type);
			ps.setInt(12, posting_id);
			ps.setDouble(13, total_open_amount);
			ps.setString(14, baseline_create_date);
			ps.setString(15, cust_payment_terms);
			ps.setInt(16, invoice_id);
	
			int rows = ps.executeUpdate();
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			

			if (rows > 0) {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Credentials", "true");	response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.getWriter().append("<h1>Data inserted Successfully</h1>");
			
			}
			else {
				response.getWriter().append("<h1>Error in inserting data</h1>");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				con.rollback();
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		doGet(request, response);
	}
	
		
	
}	
	

