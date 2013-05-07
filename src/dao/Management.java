package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;


public class Management {

    //add
    private static Management management = null;
    private Connection conn =null;


    private Management()  {
        Locale.setDefault(Locale.ENGLISH);
        // загрузка драйвера
        try
        {
            // загрузка Native-драйвера
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("JDBC-Driver is OK!\n");
        }
        catch(java.lang.ClassNotFoundException er) // обработка ошибок при загрузке драйвера
        {
            System.out.print("JDBC-Driver is wrong!\n");
            System.out.println(er.getMessage());
            er.printStackTrace();
            System.exit(0);
        }
        // установление соединения
        String url = new String(""); // инициализации URL-строки
        try
        {
            // URL-строка для native-драйвера
            // Субпротокол = oracle
            // Тип драйвера = thin
            // Адрес расположения СУБД = localhost
            // Порт прослушивания запросов = 1521
            // Имя БД ( имя сервиса) = XE
            url="jdbc:oracle:thin:@localhost:1521:xe";

            // установка имени пользователя
            String userid="system";
            // установка пароля
            String userp="informator";
            // открытие соединения
            conn=DriverManager.getConnection(
                    url,userid,userp);
            System.out.println("Connection with URL=" + url + " is OK!");


        }
        catch(SQLException er) // обработка ошибок при установлении соединения
        {
            System.out.println("Connection  " + url + " is wrong!");
            System.out.println(er.getMessage());
        }
    }  //Установка соеденения с БД

    //pattern Singelton  - read
    public static Management getInstance()
    {
        if(management == null)
        {
            management = new Management();
        }

        return management;
    }

    //add get Connection
    public Connection getConnection()
    {
        return conn;
    }
}
