<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 13/07/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        function  chooseFile(fileInput){
            if (fileInput.files && fileInput.files[0]){
            var reader=new FileReader();
            reader.onload=function (e){
                $('#image').attr('src',e.target.result)
            }
            reader.readAsDataURL(fileInput.files[0]);
        }
        }
    </script>
</head>
<body>
<button><a href="/create">Create</a></button>
<table>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td><img src="${p.img}" width="300" height="250"></td>
            <td><button><a href="/edit?id=${p.id}">Edit</a></button></td>
            <td><button><a href="/delete?id=${p.id}">Delete</a></button></td>        </tr>
    </c:forEach>
</table>
<button><a href="/validate">Validate</a></button>
<button><a href="/TimeZone">TimeZone</a></button>
<button><a href="/sandwich">SandWich</a></button>
<button><a href="/caculator">Caculator</a></button>

<form action="">
    <img src="" alt="" id="image" width="200" height="200">
    <input type="file" name="" id="imageFile" onchange="chooseFile(this)"
     accept="image/gif,image/jpeg, image/png">
</form>
</body>
</html>
