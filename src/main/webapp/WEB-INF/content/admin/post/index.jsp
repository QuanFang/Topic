<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container main-bar">
    <h1>帖子管理</h1>
    <table class="table table-bordered">
        <tr>
            <th>post id</th>
            <th>title</th>
            <th>user</th>
            <th>status</th>
            <th>comment</th>
            <th>opt</th>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.id}</td>
                <td><a href="<c:url value="/p/${post.id}"/>">${post.title}</a></td>
                <th><a href="<c:url value="/u/${post.userUsername}"/>">${post.userUsername}</a></th>
                <td>${post.discard}</td>
                <td><a href="comments?postId=${post.id}">${post.commentsNumber}</a></td>
                <td>
                    <a href="">折叠</a>
                    <a href="">显示</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <jsp:include page="../../page.jsp"/>
</div>
</body>
</html>
