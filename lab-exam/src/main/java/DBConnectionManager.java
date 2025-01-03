 @Getter
 @Setter
 @NoArgsConstructor
 public class DBConnectionManager {
 private Connection connection;

 public void openConnection() throws SQLException {
         String url = "jdbc:mysql://localhost:3306/OnlineBookstore";
         String user = "root";
         String password = "password";
         connection = DriverManager.getConnection(url, user, password);
         }

   public void closeConnection() throws SQLException {
         if (connection != null && !connection.isClosed()) {
             connection.close();
             }
        }
 }
