<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    <!-- Content here -->
    <h2>注册账户成功~ </h2>
    <p>ID : ${user.id}</p>
    <p>Email : ${user.email}</p>
    <p>Password : ${user.password}</p>
    <p>Name : ${user.name}</p>
    <p>PhoneNumber : ${user.phoneNumber}</p>

    <br>
    <br>
    <h2>当前已注册用户</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Email</th>
            <%--            <th scope="col">Password</th>--%>
            <th scope="col">Name</th>
            <th scope="col">Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.id}</td>
                <td>${u.email}</td>
                    <%--                <td>${u.password}</td>--%>
                <td>${u.name}</td>
                <td>${u.phoneNumber}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>