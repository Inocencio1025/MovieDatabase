<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Data - Movie Database</title>
    <style>
        /* Add some basic styling */
        .form-container {
            width: 50%;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        label, input, select {
            display: block;
            margin: 10px 0;
            font-size: 16px;
            padding: 5px;
            width: 100%;
        }
        button {
            background-color: #007BFF;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Add New Data</h1>

    <div class="form-container">
        <form action="add" method="post">
                <!-- Add hidden table parameter -->
                <input type="hidden" name="table" value="<%= request.getParameter("table") %>">
            <%
                String table = request.getParameter("table");
                if ("MOVIE".equals(table)) {
            %>
                <h2>Add Movie</h2>
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required>

                <label for="date">Release Date</label>
                <input type="date" id="date" name="date" required>

                <label for="synopsis">Synopsis</label>
                <input type="text" id="synopsis" name="synopsis" required>

                <label for="rating">Rating (0-10)</label>
                <input type="number" id="rating" name="rating" min="0" max="10" step="0.1" required>

                <label for="length">Length (in minutes)</label>
                <input type="number" id="length" name="length" min="0" required>

                <label for="category">Category</label>
                <input type="text" id="category" name="category">
            <%
                } else if ("MOVIE_PRODUCER".equals(table)) {
            %>
                <h2>Add Producer</h2>

                <label for="firstName">First Name</label>
                <input type="text" id="producerFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="producerLastNames" name="lastNames" required>

            <%
                } else if ("MOVIE_DIRECTOR".equals(table)) {
            %>
                <h2>Add Director</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="directorFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="directorLastNames" name="lastNames" required>

            <%
                } else if ("MOVIE_ACTOR".equals(table)) {
            %>
                <h2>Add Actor</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="actorFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="actorLastNames" name="lastNames" required>

            <%
                } else if ("MOVIE_ACTRESS".equals(table)) {
            %>
                <h2>Add Actress</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="actressFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="actressLastNames" name="lastNames" required>

            <%
                } else if ("MOVIE_WRITER".equals(table)) {
            %>
                <h2>Add Writer</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="writerFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="writerLastNames" name="lastNames" required>

            <%
                } else {
                    out.println("<h2>Invalid Type</h2>");
                }
            %>

            <button type="submit" formaction="addData" name="action" value="addData">Add</button>
        </form>
    </div>

</body>

</html>
