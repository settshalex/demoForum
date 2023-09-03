package com.example.demoforum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet  extends HttpServlet {
    private String message;
    private static final String QUERY = "select id,email,password from Users where email =?";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");
        // Initialize the databaseCreonCreon
        try {
            Connection connection = DatabaseConnection.initializeDatabase();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String hashedPsw = rs.getString("password");
                if(PasswordEncryptionUtil.checkPassword(plainPassword, hashedPsw)){
                    String email2 = rs.getString("email");
                    System.out.println(id + "," + email2 + "," + hashedPsw);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", "Pankaj");
                    //setting session to expiry in 30 mins
                    session.setMaxInactiveInterval(30*60);
                    Cookie userName = new Cookie("user", email2);
                    userName.setMaxAge(30*60);
                    response.addCookie(userName);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                }

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("error", "Email and password not found");
        request.getRequestDispatcher("/login.jsp").forward(request, response);



    }
    public void destroy() {

    }

}