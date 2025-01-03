@WebServlet("/delete-task")
public class TaskRegistrationServlet extends HttpServlet {
    private DBConnectionManager dbManager;

    @Override
    public void init() {
        dbManager = new DBConnectionManager();
        dbManager.openConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        String id = request.deleteParameter("id");


        try (PreparedStatement stmt =
                     dbManager.getConnection().prepareStatement(
                             "DELETE FROM Tasks (id)
                             VALUES (?, ?, ?)")) {
        stmt.setString(1, id);

    } catch (SQLException e) {
        response.getWriter().println("Error: " + e.getMessage());
    }
 response.getWriter().println("Task Deleted successfully!");
}
 }