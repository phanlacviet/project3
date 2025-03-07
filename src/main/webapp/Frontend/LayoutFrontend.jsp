<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("pageTitle") %> - Phan Lạc Việt</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Frontend.css">
    <script src="<%= request.getContextPath() %>/assets/js/modernizr.js"></script>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="<%= request.getContextPath() %>/home" class="navbar-brand">Phan Lạc Việt</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
                    <li><a href="<%= request.getContextPath() %>/about">About</a></li>
                    <li><a href="<%= request.getContextPath() %>/contact">Contact</a></li>
                    
                    <%
                        // Check if the user is logged in (using session attribute)
                        Object user = session.getAttribute("PLvMember");
                        if (user != null) {
                            out.print("<li><a href=\"#\" class=\"nav-link\">Xin chào, " + user.getClass().getMethod("getFullName").invoke(user) + "</a>");
                            out.print("<a href=\"" + request.getContextPath() + "/logout\" class=\"nav-link\">Đăng xuất</a></li>");
                        } else {
                            out.print("<li><a href=\"" + request.getContextPath() + "/login\" class=\"nav-link\">Đăng nhập</a></li>");
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>

    <div class="container body-content">
        <!-- Đây là nơi nội dung của các trang sẽ được bao gồm -->
        <jsp:include page="${contentPage}" />
        <hr />
        <footer>
            <p>&copy; <%= new java.util.Date().getYear() + 1900 %> - My JSP Application</p>
        </footer>
    </div>

    <script src="<%= request.getContextPath() %>/assets/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/assets/js/bootstrap.js"></script>
</body>
</html>
