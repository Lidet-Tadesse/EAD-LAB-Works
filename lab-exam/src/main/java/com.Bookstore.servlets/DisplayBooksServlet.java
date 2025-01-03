@WebServlet("/display-tasks")
public class DisplayTasksServlet extends HttpServlet {
    private DBConnectionManager dbManager;

    @Override
    public void init() {
        dbManager = new DBConnectionManager();
        dbManager.openConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (Statement stmt = dbManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Tasks")) {
            PrintWriter out = response.getWriter();
            out.println("<table><tr><th>ID</th><th>Description</th><th>Status</th><th>Due Date</th></tr>");
            while (rs.next()) {
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                        rs.getInt("id"), rs.getString("description"), rs.getString("status"), rs.getDate("due_date"));
            }
            out.println("</table>");
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}