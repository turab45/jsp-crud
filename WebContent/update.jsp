<%@page import="com.model.Student"%>
<%@page import="com.daoimpl.StudentDAOImpl"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
    <%
    	Integer id = Integer.parseInt(request.getParameter("id"));
    
    String action = request.getParameter("action");
    
    System.out.println("id is "+ id);
    
    StudentDAO studentDaoImpl = new StudentDAOImpl();
    
    Student student = studentDaoImpl.getStudentById(id);
    
    %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Add</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md" style="background-color: rgba(224,222,222,0.79);">
        <div class="container-fluid"><a class="navbar-brand" href="#"></a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse"
                id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="./AddServlet" style="background-color: #055ada;color: white;border: 2px;border-radius: 30px;width: 100px;text-align: center;">ADD</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="./ViewAllServlet" style="background-color: #055ada;color: white;border: 2px;border-radius: 30px;width: 150px;text-align: center;margin-left: 10px;">View All</a></li>
                    <li class="nav-item" role="presentation"></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="contact-clean">
        <form  action="Handle?id=<%=id %>&action=<%=action %>" method="post">
            <h2 class="text-center">Update</h2>
            <div class="form-group"><input class="form-control" type="text" name="rollNo" placeholder="Roll No" value="<%=student.getRollNo()%>"></div>
            <div class="form-group"><input class="form-control" type="text" name="name" placeholder="Name" value="<%=student.getName()%>"></div>
            <div class="form-group"><input class="form-control" type="number" name="contact" placeholder="Contact" value="<%=student.getContact()%>"></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" value="<%=student.getEmail()%>"></div>
            <div class="form-group"><button class="btn btn-primary btn btn-light" type="submit">Update</button></div>
        </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>