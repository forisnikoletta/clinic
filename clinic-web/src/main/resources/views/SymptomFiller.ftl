<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Consultations Page --- Symptom Filler</title>

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.css">
    <style>
        .navbar-brand {
            font-size: 30px;
            background-color: #ff33c7;
        }

        .consultation-head {
            font-size: 24px;
            padding-top: 30px;
            background-color: #ff33c7;
        }

        .consultation-body {
            font-size: 24px;
            padding-top: 30px;
            background-color: #ff33c7;
        }

        .consultation-arms {
            font-size: 24px;
            padding-top: 30px;
            background-color: #ff33c7;
        }

        .consultation-legs {
            font-size: 24px;
            padding-top: 30px;
            background-color: #ff33c7;
        }

        .consultation-meta {
            color: #888888;
            background-color: #ff33c7;
        }

        .consultation {
            margin-bottom: 30px;
            border-bottom: 1px solid grey;
            background-color: #ff33c7;
        }
    </style>
</head>

<body bgcolor=" #ff33c7">
    <div class="container">

        <nav class="navbar navbar-dark bg-dark">
            <div class="navbar-brand">Consultation</a>
        </nav>

        <#list consultations as consultation>
        <div class="consultation">
            <h2 class="consultation-head">${consultation.head}</h2>
            <h2 class="consultation-body">${consultation.body}</h2>
            <h2 class="consultation-arms">${consultation.arms}</h2>
            <h2 class="consultation-legs">${consultation.legs}</h2>
            <p class="consultation-meta">${consultation.registerDate?datetime} by <a href="#">${consultation.writer}</a></p>

        </div>
        </#list>
    
        <h2>Add new consultation</h2>

        <form method="POST" style="background-color:#ff33c7">
            <label for="head">Head:</label> <input type="text" name="head" required> <br>
            <label for="body">Body:</label> <input type="text" name="body" required> <br>
            <label for="arms">Arms:</label> <input type="text" name="arms" required> <br>
            <label for="legs">Legs:</label> <input type="text" name="legs" required> <br>
            <label for="userId">UserId:</label> <input type="text" name="userId" required> <br>
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
