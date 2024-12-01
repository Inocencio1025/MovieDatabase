<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Data - Movie Database</title>
    <style>
        .table-container {
            width: 80%;
            margin: auto;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table {
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-align: left;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
        }
        select {
            font-size: 16px;
            margin: 10px 0;
            padding: 5px;
        }
    </style>
</head>
<body>
    <h1>View Data - ${tableName}</h1>

    <table border="1">
        <thead>
            <tr>
                <c:choose>
                    <c:when test="${tableName == 'MOVIE'}">
                        <th>Movie ID</th>
                        <th>Title</th>
                        <th>Release Date</th>
                        <th>Synopsis</th>
                        <th>Rating</th>
                        <th>Length</th>
                        <th>Category</th>
                    </c:when>
                    <c:when test="${tableName == 'ACTOR'}">
                        <th>Actor ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Pay</th>
                    </c:when>
                    <c:when test="${tableName == 'ACTRESS'}">
                        <th>Actress ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Pay</th>
                    </c:when>
                    <c:when test="${tableName == 'PRODUCER'}">
                        <th>Producer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Pay</th>
                    </c:when>
                    <c:when test="${tableName == 'DIRECTOR'}">
                        <th>Director ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Pay</th>
                    </c:when>
                    <c:when test="${tableName == 'WRITER'}">
                        <th>Writer ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Role</th>
                        <th>Pay</th>
                    </c:when>
                </c:choose>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${data}">
                <tr>
                    <c:choose>
                        <c:when test="${tableName == 'MOVIE'}">
                            <td>${item.movieID}</td>
                            <td>${item.title}</td>
                            <td>${item.releaseDate}</td>
                            <td>${item.synopsis}</td>
                            <td>${item.rating}</td>
                            <td>${item.length}</td>
                            <td>${item.category}</td>
                        </c:when>
                        <c:when test="${tableName == 'ACTOR'}">
                            <td>${item.actorID}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.role}</td>
                            <td>${item.pay}</td>
                        </c:when>
                        <c:when test="${tableName == 'ACTRESS'}">
                            <td>${item.actressID}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.role}</td>
                            <td>${item.pay}</td>
                        </c:when>
                        <c:when test="${tableName == 'PRODUCER'}">
                            <td>${item.producerID}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.role}</td>
                            <td>${item.pay}</td>
                        </c:when>
                        <c:when test="${tableName == 'DIRECTOR'}">
                            <td>${item.directorID}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.role}</td>
                            <td>${item.pay}</td>
                        </c:when>
                        <c:when test="${tableName == 'WRITER'}">
                            <td>${item.writerID}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.role}</td>
                            <td>${item.pay}</td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>