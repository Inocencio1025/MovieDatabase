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


            <%
                // Get the 'type' parameter from the request
                String type = request.getParameter("type");

                // Show form based on the 'type' selected
                if ("movie".equals(type)) {
            %>
                <h2>Add Movie</h2>
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required>

                <label for="date">Release Date</label>
                <input type="date" id="date" name="date" required>

                <label for="producer">Producer</label>
                <input type="text" id="producer" name="producer" required>

                <label for="director">Director</label>
                <input type="text" id="director" name="director" required>

                <label for="actors">Actors</label>
                <input type="text" id="actors" name="actors" required>

                <label for="actresses">Actresses</label>
                <input type="text" id="actresses" name="actresses" required>

                <label for="writers">Writers</label>
                <input type="text" id="writers" name="writers" required>

                <label for="synopsis">Synopsis</label>
                <input type="text" id="synopsis" name="synopsis" required>

                <label for="rating">Rating (0-5)</label>
                <input type="number" id="rating" name="rating" min="0" max="5" required>

                <label for="length">Length (in minutes)</label>
                <input type="number" id="length" name="length" min="0" required>

                <label for="category">Category</label>
                <input type="text" id="category" name="category">
            <%
                } else if ("producer".equals(type)) {
            %>
                <h2>Add Producer</h2>

                <label for="firstName">First Name</label>
                <input type="text" id="producerFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="producerLastNames" name="lastNames" required>

                <label for="position">Position</label>
                <input type="text" id="producerPosition" name="position" required>

                <label for="pay">Pay</label>
                <input type="number" id="producerPay" name="pay" min="0" required>

            <%
                } else if ("director".equals(type)) {
            %>
                <h2>Add Director</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="directorFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="directorLastNames" name="lastNames" required>

                <label for="position">Position</label>
                <input type="text" id="directorPosition" name="position" required>

                <label for="pay">Pay</label>
                <input type="number" id="directorPay" name="pay" min="0" required>

            <%
                } else if ("actor".equals(type)) {
            %>
                <h2>Add Actor</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="actorFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="actorLastNames" name="lastNames" required>

                <label for="role">Role</label>
                <input type="text" id="actorRole" name="role" required>

                <label for="pay">Pay</label>
                <input type="number" id="actorPay" name="pay" min="0" required>

            <%
                } else if ("actress".equals(type)) {
            %>
                <h2>Add Actress</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="actressFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="actressLastNames" name="lastNames" required>

                <label for="role">Role</label>
                <input type="text" id="actressRole" name="role" required>

                <label for="pay">Pay</label>
                <input type="number" id="actressPay" name="pay" min="0" required>

            <%
                } else if ("writer".equals(type)) {
            %>
                <h2>Add Writer</h2>
                <label for="firstName">First Name</label>
                <input type="text" id="writerFirstName" name="firstName" required>

                <label for="lastNames">Last Name</label>
                <input type="text" id="writerLastNames" name="lastNames" required>

                <label for="contribution">Contribution</label>
                <input type="text" id="writerContribution" name="contribution" required>

                <label for="pay">Pay</label>
                <input type="number" id="writerPay" name="pay" min="0" required>
            <%
                } else {
                    out.println("<h2>Invalid Type</h2>");
                }
            %>

            <button type="submit" >Add</button>
        </form>
    </div>

</body>

</html>
