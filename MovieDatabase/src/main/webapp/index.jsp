<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Database</title>

    <style>
        h1 {
           text-align: center;
        }
        img {
           display: block;
           margin: 0 auto;
           width: 50%;
           height: auto;
        }
        /* Container for the dropdowns and button */
            .center-container {
                display: flex;
                justify-content: center;
                align-items: center;
                gap: 10px;
                margin-top: 20px;
            }
            select, button {
                font-size: 16px;
                padding: 5px 10px;
                border: 1px solid #ccc; /
                border-radius: 5px;
            }
            button {
                cursor: pointer;
                background-color: #007BFF;
                color: white;
                border: none;
            }
            button:hover {
                background-color: #0056b3;
            }
            .team-names {
                text-align: center;
                margin-top: 20px;
                font-size: 16px;
            }
            .team-names ul {
                list-style-type: none; /* Removes bullet points */
                padding: 0;
            }
    </style>
</head>
<body>
    <!-- Title Text -->
    <h1>Movie Database</h1>

    <!-- Image -->
    <img src="https://variety.com/wp-content/uploads/2022/12/100-Greatest-Movies-Variety.jpg?w=1024" alt="Movie Database" />

    <!-- Menu -->
    <div class="center-container">
        <form method="post">
            <select id="table" name="table">
                <option value="MOVIE">Movie</option>
                <option value="MOVIE_PRODUCER">Producer</option>
                <option value="MOVIE_DIRECTOR">Director</option>
                <option value="MOVIE_ACTOR">Actor</option>
                <option value="MOVIE_ACTRESS">Actress</option>
                <option value="MOVIE_WRITER">Writer</option>
            </select>

            <!-- "View" button directs to the ViewServlet -->
            <button type="submit" formaction="view" name="action" value="view">View</button>

            <!-- "Add" button directs to the AddServlet -->
            <button type="submit" formaction="add" name="action" value="add">Add</button>

            <!-- "Add To Movie" button directs to the AddServlet -->
            <button type="submit" formaction="addToMovie" name="action" value="addToMovie">Add To Movie</button>
        </form>
    </div>

    <!-- Team Names -->
        <div class="team-names">
            <p>Team Members:</p>
            <ul>
                <li>Rolando Inocencio</li>
                <li>Michael VanCoppenolle</li>
                <li>Sahven Patel</li>
                <li>Nadia Uddin</li>
                <li>Fulton Zinser</li>
            </ul>
        </div>
</body>
</html>
