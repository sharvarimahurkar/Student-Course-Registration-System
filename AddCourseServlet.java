import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String cname = request.getParameter("cname");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO courses(course_name) VALUES (?)");
            ps.setString(1, cname);
            ps.executeUpdate();

            response.sendRedirect("index.jsp?msg=Course Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
