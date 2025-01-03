package com.example.servlets;

import com.example.db.DBConnectionManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registerBook")
public class TaskRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String dueDate = request.getParameter("due_date");

        try {
            DBConnectionManager dbManager = new DBConnectionManager();
            dbManager.openConnection();
            Connection connection = dbManager.getConnection();

            String sql = "INSERT INTO Tasks (description, status, due_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, description);
            stmt.setString(2, status);
            stmt.setDate(3, java.sql.Date.valueOf(dueDate));
            stmt.executeUpdate();

            dbManager.closeConnection();
            response.getWriter().println("Task added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
