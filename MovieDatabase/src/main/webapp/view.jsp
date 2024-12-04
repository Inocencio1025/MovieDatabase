<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Data - Movie Database</title>
    <style>
        .table-container {
            margin: auto;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table {
            width: 100%;
            table-layout: fixed;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-align: left;
        }
        th, td {
            width: 150px;
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
        }

        th:nth-child(1), td:nth-child(1) {
                width: 50px;
            }

            <% String table = request.getParameter("table"); %>
            <% if ("MOVIE".equals(table)) { %>
                th:nth-child(5), td:nth-child(5) {
                    width: 50px;
                }
                th:nth-child(6), td:nth-child(6) {
                    width: 50px;
                }
                th:nth-child(7), td:nth-child(7) {
                    width: 100px;
                }

            <% } else { %>
                th:nth-child(5), td:nth-child(5) {
                    width: 50px;
                }
            <% } %>
        select {
            font-size: 16px;
            margin: 10px 0;
            padding: 5px;
        }
        form a.button, form button {
            margin: 30px; /* Add space between buttons */
            display: inline-block; /* Ensure alignment */
            text-align: center; /* Center text */
        }
    </style>
</head>
<body>
    <h1>View Data - ${table}</h1>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <c:choose>
                        <c:when test="${table == 'MOVIE'}">
                            <th><a href="view?table=${table}&sortBy=movieID">Movie ID</a></th>
                            <th><a href="view?table=${table}&sortBy=title">Title</a></th>
                            <th><a href="view?table=${table}&sortBy=releaseDate">Release Date</a></th>
                            <th>Synopsis</th>
                            <th><a href="view?table=${table}&sortBy=rating">Rating</a></th>
                            <th><a href="view?table=${table}&sortBy=length">Length</a></th>
                            <th><a href="view?table=${table}&sortBy=category">Category</a></th>

                            <!-- Headers for the lists of names, roles, and pay -->
                            <th>Actors</th>
                            <th>Actor Roles</th>
                            <th>Actor Pay</th>

                            <th>Actresses</th>
                            <th>Actress Roles</th>
                            <th>Actress Pay</th>

                            <th>Directors</th>
                            <th>Director Roles</th>
                            <th>Director Pay</th>

                            <th>Producers</th>
                            <th>Producer Roles</th>
                            <th>Producer Pay</th>

                            <th>Writers</th>
                            <th>Writer Roles</th>
                            <th>Writer Pay</th>
                        </c:when>


                        <c:when test="${table == 'MOVIE_ACTOR'}">
                            <th><a href="view?table=${table}&sortBy=ID">Actor ID</a></th>
                            <th>First Name</th>
                            <th><a href="view?table=${table}&sortBy=lastName">Last Name</a></th>
                            <th><a href="view?table=${table}&sortBy=movie">Movie</a></th>
                            <th>Movie ID</th>
                            <th><a href="view?table=${table}&sortBy=role">Role</a></th>
                            <th><a href="view?table=${table}&sortBy=pay">Pay</a></th>
                        </c:when>

                        <c:when test="${table == 'MOVIE_ACTRESS'}">
                            <th><a href="view?table=${table}&sortBy=ID">Actress ID</a></th>
                            <th>First Name</th>
                            <th><a href="view?table=${table}&sortBy=lastName">Last Name</a></th>
                            <th><a href="view?table=${table}&sortBy=movie">Movie</a></th>
                            <th>Movie ID</th>
                            <th><a href="view?table=${table}&sortBy=role">Role</a></th>
                            <th><a href="view?table=${table}&sortBy=pay">Pay</a></th>
                        </c:when>

                        <c:when test="${table == 'MOVIE_PRODUCER'}">
                            <th><a href="view?table=${table}&sortBy=ID">Producer ID</a></th>
                            <th>First Name</th>
                            <th><a href="view?table=${table}&sortBy=lastName">Last Name</a></th>
                            <th><a href="view?table=${table}&sortBy=movie">Movie</a></th>
                            <th>Movie ID</th>
                            <th><a href="view?table=${table}&sortBy=role">Role</a></th>
                            <th><a href="view?table=${table}&sortBy=pay">Pay</a></th>
                        </c:when>

                        <c:when test="${table == 'MOVIE_DIRECTOR'}">
                            <th><a href="view?table=${table}&sortBy=ID">Director ID</a></th>
                            <th>First Name</th>
                            <th><a href="view?table=${table}&sortBy=lastName">Last Name</a></th>
                            <th><a href="view?table=${table}&sortBy=movie">Movie</a></th>
                            <th>Movie ID</th>
                            <th><a href="view?table=${table}&sortBy=role">Role</a></th>
                            <th><a href="view?table=${table}&sortBy=pay">Pay</a></th>
                        </c:when>

                        <c:when test="${table == 'MOVIE_WRITER'}">
                            <th><a href="view?table=${table}&sortBy=ID">Writer ID</a></th>
                            <th>First Name</th>
                            <th><a href="view?table=${table}&sortBy=lastName">Last Name</a></th>
                            <th><a href="view?table=${table}&sortBy=movie">Movie</a></th>
                            <th>Movie ID</th>
                            <th><a href="view?table=${table}&sortBy=role">Role</a></th>
                            <th><a href="view?table=${table}&sortBy=pay">Pay</a></th>
                        </c:when>
                    </c:choose>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${data}">
                    <tr>
                        <c:choose>
                            <c:when test="${table == 'MOVIE'}">
                                <td>${item.movieID}</td>
                                <td>${item.title}</td>
                                <td>${item.releaseDate}</td>
                                <td>${item.synopsis}</td>
                                <td>${item.rating}</td>
                                <td>${item.length}</td>
                                <td>${item.category}</td>

                                <!-- Actors, Roles, and Pay -->
                                <td>${item.actors}</td>
                                <td>${item.actorRoles}</td>
                                <td>${item.actorPay}</td>

                                <!-- Actresses, Roles, and Pay -->
                                <td>${item.actresses}</td>
                                <td>${item.actressRoles}</td>
                                <td>${item.actressPay}</td>

                                <!-- Directors, Roles, and Pay -->
                                <td>${item.directors}</td>
                                <td>${item.directorRoles}</td>
                                <td>${item.directorPay}</td>

                                <!-- Producers, Roles, and Pay -->
                                <td>${item.producers}</td>
                                <td>${item.producerRoles}</td>
                                <td>${item.producerPay}</td>

                                <!-- Writers, Roles, and Pay -->
                                <td>${item.writers}</td>
                                <td>${item.writerRoles}</td>
                                <td>${item.writerPay}</td>
                            </c:when>

                            <c:when test="${table == 'MOVIE_ACTOR'}">
                                <td>${item.actorID}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.title}</td>
                                <td>${item.movieID}</td>
                                <td>${item.role}</td>
                                <td>${item.pay}</td>
                            </c:when>
                            <c:when test="${table == 'MOVIE_ACTRESS'}">
                                <td>${item.actressID}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.title}</td>
                                <td>${item.movieID}</td>
                                <td>${item.role}</td>
                                <td>${item.pay}</td>
                            </c:when>
                            <c:when test="${table == 'MOVIE_PRODUCER'}">
                                <td>${item.producerID}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.title}</td>
                                <td>${item.movieID}</td>
                                <td>${item.role}</td>
                                <td>${item.pay}</td>
                            </c:when>
                            <c:when test="${table == 'MOVIE_DIRECTOR'}">
                                <td>${item.directorID}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.title}</td>
                                <td>${item.movieID}</td>
                                <td>${item.role}</td>
                                <td>${item.pay}</td>
                            </c:when>
                            <c:when test="${table == 'MOVIE_WRITER'}">
                                <td>${item.writerID}</td>
                                <td>${item.firstName}</td>
                                <td>${item.lastName}</td>
                                <td>${item.title}</td>
                                <td>${item.movieID}</td>
                                <td>${item.role}</td>
                                <td>${item.pay}</td>
                            </c:when>
                        </c:choose>
                        <td>
                            <form action="delete" method="post" style="display:inline;">
                                <input type="hidden" name="ID" value="${movie.movieID}">
                                <button type="submit" formaction="delete" name="action" value="delete">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="index.jsp" class="button">Back</a>

    </div>
</body>
</html>
