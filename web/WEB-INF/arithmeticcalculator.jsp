<%-- 
    Document   : arithmeticcalculator
    Created on : 29-Jan-2021, 8:27:56 PM
    Author     : alexz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" name="first" value="${first}"><br>
            Second: <input type="text" name="second" value="${second}"><br>
            <input type="submit" value="+" name="+" >
            <input type="submit" value="-" name="-" >
            <input type="submit" value="*" name="*" >
            <input type="submit" value="%" name="%" ><br>
            <p>Result: ${result}</p>
            <a href="age">Age calculator</a>
        </form>
    </body>
</html>
