<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Login/Registration</title>
</head>

<body bgcolor=" #ff33c7">
<div class="container">
    <h2>Login</h2>
    <form method="GET" action="consult">
        <label for="username">Username:</label> <input type="text" name="username" required> <br>
        <label for="password">Password:</label> <input type="text" name="password" required> <br>
        <button type="submit">Login</button>
    </form>
    <h2>Register</h2>
    <form method="GET" href="/clinic-web/login">
        <label for="username">Username:</label> <input type="text" name="username" required> <br>
        <label for="password">Password:</label> <input type="text" name="password" required> <br>
        <label for="passwordRetype">Password Retype:</label> <input type="text" name="passwordRetype" required> <br>
        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>
