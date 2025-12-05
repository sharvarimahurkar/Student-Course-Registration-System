import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("student"));
        int courseId = Integer.parseInt(request.getParameter("course"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO registrations(student_id, course_id) VALUES (?, ?)");
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate();

            response.sendRedirect("index.jsp?msg=Student Registered");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
