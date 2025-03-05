package com.aryan;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.mockito.Mockito.*;

public class SignupServletTest {

    @Test
    public void testSignup() throws Exception {
        // Mock the HttpServletRequest and HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock the parameters to simulate the signup data
        when(request.getParameter("username")).thenReturn("testuser");
        when(request.getParameter("email")).thenReturn("testuser@example.com");
        when(request.getParameter("password")).thenReturn("password123");

        // Mock the context path
        when(request.getContextPath()).thenReturn(""); // Replace "" with your context path if needed

        // Mock the database connection and PreparedStatement
        Connection mockConnection = mock(Connection.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);

        // Mock the static DatabaseConnection class
        try (MockedStatic<DatabaseConnection> mockedStatic = Mockito.mockStatic(DatabaseConnection.class)) {
            mockedStatic.when(DatabaseConnection::getConnection).thenReturn(mockConnection);
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulate successful insertion

            // Create the SignupServlet instance and call doPost
            SignupServlet signupServlet = new SignupServlet();
            signupServlet.doPost(request, response);

            // Verify that the response redirects to the login page after successful signup
            verify(response).sendRedirect("/login.jsp");
        }
    }
}