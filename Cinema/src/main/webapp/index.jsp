<%--
  Created by IntelliJ IDEA.
  User: mshad
  Date: 2/16/23
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title FWA project</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body> class="w3-light-grey">

<div class="w3-container w3-center">
    <h3> Hello, %username%! </h3>
</div>

<div class="w3-container w3-center"> <!-- content -->
    <div class="w3-bar w3-padding-large w3-padding-24"> <!-- buttons -->
        <button class="w3-button w3-pale-blue " onclick="location.href='/signUp'">Sign Up</button>
        <button class="w3-button w3-cyan" onclick="location.href='/signIn'">Sign In</button>
    </div>
</div>


</body>
</html>
