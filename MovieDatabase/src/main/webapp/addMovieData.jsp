<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Data - Movie Database</title>
    <style>
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
        form a.button, form button {
            margin-right: 10px;
            display: inline-block;
            text-align: center;
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
    <h2>Add Data to Movie</h2>
    <div class="form-container">
        <form method="post" action="addMovieData">
            <label for="table">Person Type</label>
            <select id="table" name="table">
                <option value="MOVIE_PRODUCER">Producer</option>
                <option value="MOVIE_DIRECTOR">Director</option>
                <option value="MOVIE_ACTOR">Actor</option>
                <option value="MOVIE_ACTRESS">Actress</option>
                <option value="MOVIE_WRITER">Writer</option>
            </select>

            <!-- Input for movieID -->
            <label for="movieID">Enter Movie ID:</label>
            <input type="number" id="movieID" name="movieID" required>

            <!-- Input for personID -->
            <label for="personID">Enter Person ID:</label>
            <input type="number" id="personID" name="personID" required>

            <!-- Input for person's role -->
            <label for="role">Role:</label>
            <input type="text" id="role" name="role" required>

            <!-- Input for pay -->
            <label for="pay">Pay:</label>
            <input type="number" id="pay" name="pay" required>

            <!-- Submit button -->
            <button type="submit" formaction="addMovieData" name="action" value="addMovieData">Add to Movie</button>
            <a href="index.jsp" class="button">Back</a>
        </form>
    </div>
</body>
</html>
