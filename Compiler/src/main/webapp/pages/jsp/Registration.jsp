
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align = center>
<h1>Регистрация пользователей</h1>
<form action="/Registration" method="post">
         <input type="text" name="fname" size="10" placeholder="Имя"><br>
         <input type="text" name="lname" size="10" placeholder="Фамилия"><br>
         <input type="password" name="password" size="10" placeholder="Пароль"><br>
         <input type="text" name="email" size="10" placeholder="Email"><br>
    <p>
    <table>
        <tr>
        <th><small>
            <input type="submit" name="save" value="Сохранить">
        </small>
        <th><small>
            <input type="submit" name="cancel" value="Выйти">
        </small>
    </table>
</form>
</div>
</body>
</html>