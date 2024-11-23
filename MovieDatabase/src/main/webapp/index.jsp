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
                display: flex; /* Use flexbox to arrange items side by side */
                justify-content: center; /* Center the items horizontally */
                align-items: center; /* Center the items vertically */
                gap: 10px; /* Add spacing between items */
                margin-top: 20px; /* Add some space from the image above */
            }

            /* Style the dropdowns and button */
            select, button {
                font-size: 16px; /* Make the text more readable */
                padding: 5px 10px; /* Add some padding */
                border: 1px solid #ccc; /* Add a border */
                border-radius: 5px; /* Rounded corners */
            }

            button {
                cursor: pointer; /* Show a pointer cursor on hover */
                background-color: #007BFF; /* Blue background */
                color: white; /* White text */
                border: none; /* Remove border */
            }

            button:hover {
                background-color: #0056b3; /* Darker blue on hover */
            }

            /* Style for the team names */
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
        <form action="submit" method="post">
            <select id="type" name="type">
                <option value="movie">Movie</option>
                <option value="producer">Producer</option>
                <option value="director">Director</option>
                <option value="actor">Actor</option>
                <option value="actress">Actress</option>
                <option value="writer">Writer</option>
            </select>

            <button type="submit" name="action" value="view">View</button>
            <button type="submit" name="action" value="add">Add</button>
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
