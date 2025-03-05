package com.aryan;

import com.aryan.DatabaseConnection;
import com.aryan.LoginServlet;
import org.mockito.*;
import org.testng.annotations.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class LoginServletTest {

    @Test
    public void testLoginSuccess() throws Exception {
        // Mock dependencies
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        ResultSet mockResultSet = mock(ResultSet.class);

        // Mock static DatabaseConnection.getConnection
        mockStatic(DatabaseConnection.class);
        when(DatabaseConnection.getConnection()).thenReturn(mockConnection);

        // Mock request parameters
        when(request.getParameter("username")).thenReturn("testuser");
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getContextPath()).thenReturn(""); // Simulate context path as empty string

        // Mock SQL behavior
        when(mockConnection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?"))
                .thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true); // Simulate a valid login

        // Mock session behavior
        when(request.getSession()).thenReturn(session);

        // Create servlet instance and call doPost
        LoginServlet loginServlet = new LoginServlet();
        loginServlet.doPost(request, response);

        // Verify session and redirection
        verify(session).setAttribute("username", "testuser");
        verify(response).sendRedirect("/welcome.jsp");
    }
}
