package mavengrocery;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mavengrocery.DAO;
import mavengrocery.Student;

@WebServlet("/EditItemServlet")
public class EditItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the edited item and quantity from the form
        String newItem = request.getParameter("item");
        String newQuantity = request.getParameter("quantity");

        // Retrieve the current student from the session
        Student stu = (Student) request.getSession().getAttribute("stu");

        if (stu != null) {
            // Update the student object with the new data
            stu.setItem(newItem);
            stu.setQuantity(newQuantity);

            try {
                Connection con = DAO.createConnection();
                String sql = "UPDATE itemlist SET item = ?, quantity = ? WHERE item = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                
                // Set the parameters for the PreparedStatement
                ps.setString(1, newItem);
                ps.setString(2, newQuantity);
                ps.setString(3, stu.getItem());
                
                int updatedRows = ps.executeUpdate();
                
                // Close resources
                ps.close();
                con.close();
                
                if (updatedRows > 0) {
                    // Successfully updated the item, you can redirect to a success page
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                } else {
                    // Handle the case where the update failed, perhaps by showing an error message
                    response.sendRedirect(request.getContextPath() + "/error.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle database errors
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            // Handle the case where the student object is not in the session
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

