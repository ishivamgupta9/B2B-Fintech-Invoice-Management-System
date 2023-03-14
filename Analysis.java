package highradius_project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import highradius_project.bean.Response;

/**
 * Servlet implementation class Analysis
 */
@WebServlet("/analysis")
public class Analysis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Analysis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cleardatefrom = request.getParameter("cleardatefrom");
		String cleardateto = request.getParameter("cleardateto");

		String duedatefrom = request.getParameter("duedatefrom");
		String duedateto = request.getParameter("duedateto");

		String baselinefrom = request.getParameter("baselinefrom");
		String baselineto = request.getParameter("baselineto");

		String invoicecurrency = request.getParameter("invoicecurrency");

try {


			Connection con = DbConnection.createConnect();
			//per row 10 data
			String query = "SELECT * FROM grey_goose.winter_internship where invoice_currency = '"+invoicecurrency+"' and due_in_date between '"+duedatefrom+"' and '"+duedateto+"' and clear_date between '"+cleardatefrom+"' and '"+cleardateto+"' and baseline_create_date between '"+baselinefrom+"' and '"+baselineto+"'";	
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			
			ArrayList<Response> data = new ArrayList<>();
			while (rs.next()) {

				Response inv = new Response();

			
				inv.setCust_number(rs.getInt("cust_number"));
				inv.setTotal_open_amount(rs.getDouble("total_open_amount"));
				
			
				data.add(inv);

			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(data);
			
		
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}

			st.close();
			rs.close();
			con.close();
			
		} 
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
