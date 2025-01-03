@WebServlet("/search-task")
public class TaskRegistrationServlet extends HttpServlet {
    private DBConnectionManager dbManager;


    public void init() {
        dbManager = new DBConnectionManager();
        dbManager.openConnection();
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        String description = request.getParameter("description");

        try (PreparedStatement stmt =
                     dbManager.getConnection().prepareStatement(
                             "GET Tasks (description)
                             VALUES (?)")) {
        stmt.setString(1, description);

    } catch (SQLException e) {
        response.getWriter().println("Error: " + e.getMessage());
    }
 response.getWriter().println("Done!");
}
 }