package com.aryan;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        Connection connection = null;
        try {
            // Attempt to establish a connection
            connection = DatabaseConnection.getConnection();

            // Verify the connection is not null
            Assert.assertNotNull(connection, "Database connection should not be null.");

            // Verify the connection is valid
            Assert.assertTrue(connection.isValid(2), "Database connection should be valid.");
        } catch (ClassNotFoundException | SQLException e) {
            // Fail the test if any exception is thrown
            Assert.fail("Exception occurred while testing database connection: " + e.getMessage());
        } finally {
            // Ensure the connection is closed to release resources
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the database connection: " + e.getMessage());
                }
            }
        }
    }
}