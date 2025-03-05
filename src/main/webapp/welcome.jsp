<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
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

    .welcome-container {
      text-align: center;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      background-color: white;
      width: 300px;
    }

    h1 {
      color: #333;
    }

    p {
      color: #555;
    }
  </style>
</head>
<body>
<div class="welcome-container">
  <%
    try {
      String username = (String) session.getAttribute("username");
      if (username == null) {
        String redirectReason = (String) request.getAttribute("redirectReason");
        if (redirectReason != null) {
          out.println("<p style='color:red;'>" + redirectReason + "</p>");
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return; // Now correctly placed to exit the JSP processing
      } else {
  %>
  <h1>Welcome, <%= username %>!</h1>
  <p>You have successfully logged in.</p>
  <%
      }
    } catch (NullPointerException e) {
      // Log the error properly (important for production)
      System.err.println("NullPointerException in welcome.jsp: " + e.getMessage()); // Or use a proper logger
      // Optionally redirect to an error page
      response.sendRedirect(request.getContextPath() + "/error.jsp");
      return; // Important: prevent further processing
    }
  %>
</div>
</body>
</html>