<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 25/08/2021
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>second</title>
</head>
<body>
<% String MATNO = request.getParameter("mat"); %>
    <center>
        <a><h2>Hi <% out.println(MATNO); %> welcome back. </h2></a>
        <h3>FILL THE FOLLOWING FORM</h3>
        <form method="post" action="/second">
            FIRSTNAME: <input type="text" name="first"><br>
            LASTNAME: <input type="text" name="last"><br>
            EMAIL: <input type="email" name="email"><br>
            AGE: <input type="number" name="age"><br>
            STATE_OF_BIRTH: <input type="text" name="state"><br>
            COURSE_OF_STUDY:<input type="text" name="course"><br>
            <input type="submit" name="REGISTER">
        </form>
</center>
</body>
</html>
