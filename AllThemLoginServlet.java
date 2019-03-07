import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/AllThemLoginServlet")
public class AllThemLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			ctx = new InitialContext();
			DataSource ds = (DataSource) 
			ctx.lookup("java:/comp/env/jdbc/Quatrarian");
			
			con = ds.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select user_name from Owners;");
			
			PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print("<link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons/mobirise-icons.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/tether/tether.min.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-grid.min.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap-reboot.min.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/dropdown/css/style.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/theme/css/style.css\">" +
             "<link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">");
            out.print("<html><body><h2>Login Details</h2>");
            out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
            out.print("<th>user</th>");
            
            while(rs.next())
            {
                out.print("<tr>");
                out.print("<td>" + rs.getString("user_name") + "</td>");
                out.print("</tr>");
            }
            out.print("</table></body><br/>");
            
            //lets print some DB information
            out.print("<h3>Database Details</h3>");
            out.print("Database Product: "+con.getMetaData().getDatabaseProductName()+"<br/>");
            out.print("Database Driver: "+con.getMetaData().getDriverName());
            out.print("</html>");
            
		}catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				con.close();
				ctx.close();
			} catch (SQLException e) {
				System.out.println("Exception in closing DB resources");
			} catch (NamingException e) {
				System.out.println("Exception in closing Context");
			}
			
		}
	}

}