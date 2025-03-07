<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
    <!-- Footer -->
    <footer>
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> - My JSP Application</p>
    </footer>
    <script src="<%= request.getContextPath() %>/assets/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/bootstrap.js"></script>
</body>
</html>
