import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class ViewRegistrationsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT r.reg_id, s.student_name, c.course_name FROM registrations r " +
                "JOIN students s ON r.student_id=s.student_id " +
                "JOIN courses c ON r.course_id=c.course_id"
            );

            request.setAttribute("data", rs);
            RequestDispatcher rd = request.getRequestDispatcher("view_registrations.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
