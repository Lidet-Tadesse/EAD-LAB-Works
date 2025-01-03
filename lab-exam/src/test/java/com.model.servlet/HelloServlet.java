@WebServlet("/registerTask")
public class TaskRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String dueDate = request.getParameter("due_date");

        try (Connection connection = new DBConnectionManager().getConnection()) {
            String sql = "INSERT INTO Tasks (description, status, due_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, description);
            stmt.setString(2, status);
            stmt.setDate(3, Date.valueOf(dueDate));
            stmt.executeUpdate();
            response.getWriter().println("Task added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
