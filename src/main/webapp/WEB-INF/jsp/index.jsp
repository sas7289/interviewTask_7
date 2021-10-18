<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>View Books</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row align-top">
        <table class="table">
            <form>
                <c:if test="${student == null}">
                <tr>
                    <th class="col-sm-7">Name</th>
                    <th class="col-sm-7">Age</th>
                </tr>
                <tbody>
                <c:forEach items="${students}" var="st">
                    <tr>
                        <td class="col-sm-7 ">${st.name}</td>
                        <td class="col-sm-7">${st.age}</td>
                        <td>
                            <button class="btn btn-danger" name="name"
                                    formaction="students/delete"
                                    formmethod="post" value="${st.name}">Удалить
                            </button>
                        </td>
                        <td>
                            <button type="submit" class="btn btn-check"
                                    name="name"
                                    formmethod="get"
                                    formaction="/students/getUpdateView"
                                    value="${st.name}">Обновить
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </c:if>
                <c:if test="${students == null}">
                    <tr>
                        <td class="col-sm-7 ">${student.name}</td>
                        <td class="col-sm-7">${student.age}</td>
                    </tr>
                </c:if>
                </tbody>
            </form>
        </table>
    </div>
    <div class="row align-bottom">
        <form method="post" action="students/add">
            <h3>Введите данные нового студента</h3>
            <input type="text" name="name">
            <input type="number" name="age">

            <button class="btn btn-primary" type="submit">Button</button>
        </form>
    </div>
</div>
</body>
</html>