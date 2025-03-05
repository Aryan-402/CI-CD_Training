<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Home</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }

    .form-container {
      text-align: center;
      padding: 40px; /* Increased padding */
      border-radius: 12px; /* Increased border-radius */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15); /* More pronounced shadow */
      background-color: white;
      width: 400px; /* Increased width */
      max-width: 90%; /* Added max-width for responsiveness */
    }

    h2 {
      color: #333;
      margin-bottom: 20px; /* Added margin */
    }

    p {
      color: #555;
      font-size: 16px; /* Slightly reduced font size */
      line-height: 1.6; /* Added line height for better readability */
      margin-bottom: 30px; /* Increased margin */
    }

    a.button {
      display: inline-block;
      padding: 12px 24px; /* Adjusted padding */
      margin: 0 10px;
      text-decoration: none;
      color: white;
      background-color: #007bff;
      border-radius: 6px; /* Adjusted border-radius */
      font-size: 16px;
      transition: background-color 0.3s ease; /* Added transition for hover effect */
    }

    a.button:hover {
      background-color: #0056b3; /* Darker shade on hover */
    }

    /* Responsive adjustments for smaller screens */
    @media (max-width: 480px) {
      .form-container {
        padding: 20px;
        width: 95%;
      }
      a.button{
        display: block; /* Stack buttons vertically */
        margin: 10px auto; /* Center the buttons */
        width: fit-content;
      }
    }
    /* Styles moved to styles.css for maintainability*/
  </style>
</head>
<body>
<div class="form-container">
  <h2>Welcome to Our Website!</h2>
  <p>This is the home page of our application. Learn more about our products and services.</p>

  <a href="<%= request.getContextPath() %>/login.jsp" class="button">Login</a>
  <a href="<%= request.getContextPath() %>/signup.jsp" class="button">Register</a>

</div>
</body>
</html>