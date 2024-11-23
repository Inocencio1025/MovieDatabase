<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <h1>View Data</h1>



    <!--  commented out for now -->
    <!--
    <form action="view" method="get">
        <label for="type">Select Entity Type:</label>
        <select id="type" name="type">
            <option value="movie">Movie</option>
            <option value="producer">Producer</option>
            <option value="director">Director</option>
            <option value="actor">Actor</option>
            <option value="actress">Actress</option>
            <option value="writer">Writer</option>
        </select>
        <button type="submit">View</button>
    </form>
    -->

    <div class="table-container">
        <%
            String type = request.getParameter("type");
            if ("movie".equals(type)) {
        %>
        <table>
            <tr>
                <th>Title</th>
                <th>Release Date</th>
                <th>Producers</th>
                <th>Directors</th>
                <th>Actors</th>
                <th>Actresses</th>
                <th>Writers</th>
                <th>Rating</th>
                <th>Length</th>
                <th>Category</th>
            </tr>
            <tr>
                <td>Inception</td>
                <td>2010-07-16</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>5</td>
                <td>148</td>
                <td>Sci-Fi</td>
                <td>

                    <!-- Modify Button -->
                    <jsp:include page="/modify-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="movie" />
                    </jsp:include>

                    <!-- Delete Button -->
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="movie" />
                    </jsp:include>
                </td>
            </tr>

        </table>
        <%
            } else if ("producer".equals(type)) {
        %>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Movie</th>
                <th>Position</th>
                <th>Pay</th>
            </tr>
            <tr>
                <td>Emma</td>
                <td>Thomas</td>
                <td></td>
                <td>Executive Producer</td>
                <td>$500,000</td>

                <!-- Delete Button -->
                <td>
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="${type}" />
                    </jsp:include>
                </td>
            </tr>
        </table>
        <%
            } else if ("director".equals(type)) {
        %>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Movie</th>
                <th>Position</th>
                <th>Pay</th>
            </tr>
            <tr>
                <td>Christopher</td>
                <td>Nolan</td>
                <td></td>
                <td>Director</td>
                <td>$1,000,000</td>

                <!-- Delete Button -->
                <td>
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="${type}" />
                    </jsp:include>
                </td>
            </tr>
        </table>
        <%
            } else if ("actor".equals(type)) {
        %>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Movie</th>
                <th>Role</th>
                <th>Pay</th>
            </tr>
            <tr>
                <td>Keanu</td>
                <td>Reeves</td>
                <td></td>
                <td>Neo</td>
                <td>$1,500,000</td>

                <!-- Delete Button -->
                <td>
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="${type}" />
                    </jsp:include>
                </td>
            </tr>
        </table>
        <%
            } else if ("actress".equals(type)) {
        %>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Movie</th>
                <th>Role</th>
                <th>Pay</th>
            </tr>
            <tr>
                <td>Scarlett</td>
                <td>Johansson</td>
                <td></td>
                <td>Natasha Romanoff</td>
                <td>$2,000,000</td>

                <!-- Delete Button -->
                <td>
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="${type}" />
                    </jsp:include>
                </td>
            </tr>
        </table>
        <%
            } else if ("writer".equals(type)) {
        %>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Movie</th>
                <th>Contribution</th>
                <th>Pay</th>
            </tr>
            <tr>
                <td>Jonathan</td>
                <td>Nolan</td>
                <td></td>
                <td>Screenplay</td>
                <td>$800,000</td>

                <!-- Delete Button -->
                <td>
                    <jsp:include page="/delete-button.jspf">
                        <jsp:param name="id" value="0000000000000" />
                        <jsp:param name="table" value="${type}" />
                    </jsp:include>
                </td>
            </tr>
        </table>
        <%
            } else {
                out.println("<h2>Please select a valid entity type.</h2>");
            }
        %>
    </div>
</body>
</html>
