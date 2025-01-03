@WebServlet("/register-task")
 public class TaskRegistrationServlet extends HttpServlet {
 private DBConnectionManager dbManager;


public void init() {
dbManager = new DBConnectionManager();
  dbManager.openConnection();
  }


 protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
         String description = request.getParameter("description");
         String status = request.getParameter("status");
         String dueDate = request.getParameter("due_date");

         try (PreparedStatement stmt =
                         dbManager.getConnection().prepareStatement(
                                  "INSERT INTO Tasks (description, status, due_date)
                                 VALUES (?, ?, ?)")) {
         stmt.setString(1, description);
         stmt.setString(2, status);
         stmt.setDate(3, Date.valueOf(dueDate));
         stmt.executeUpdate();
         } catch (SQLException e) {
         response.getWriter().println("Error: " + e.getMessage());
         }
 response.getWriter().println("Task registered successfully!");
 }
 }