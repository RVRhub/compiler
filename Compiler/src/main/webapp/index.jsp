<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<LINK REL=STYLESHEET TYPE="text/css" HREF="style.css">

<html>
<head>    <title>Login</title>
</head>
<body>
<br><br><br>
<decor:box color ='yellow' margin ='25' borderWidth = '3' title = 'Login'>
    <div align = center>
        <form action="/Compiler/login" method="post">

            <!--Header-->
            <div class="header">
                <h1>Форма входа</h1>
            </div>

            <!--Input fields-->
            <div class="content">
                <!--USERNAME-->
                <div>
                    <input name="username" type="text" class="input username" placeholder="Логин" />
                    <div class="user-icon"></div>
                </div>

                <!--PASSWORD-->
                <div>
                    <input name="password" type="password" class="input password" placeholder="Пароль" />
                    <div class="pass-icon"></div>
                </div>

            </div>

            <!--Buttons-->
            <div class="footer">
                <input type="submit" name="submit" value="Войти" class="button" />
                <input type="submit" name="submit" value="Зарегистрироваться" class="register" />
            </div>

        </form>
    </div>
</decor:box>

</body>
</html>