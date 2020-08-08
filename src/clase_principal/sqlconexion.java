/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase_principal;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class sqlconexion {
    Connection con = null;
    public Connection sqlconexion(String server,String user,String pass,String db)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");//Con el metodo de la clase forName, le pasamos el driver de MySQL para que lo cargue    
            String resul = "jdbc:mysql://"+server+"/"+db;
            con = DriverManager.getConnection(resul,user,pass);    //Apuntamos nuestro objeto con a el intento de conectarse con los parametros o las credenciales que tenemos en MYSQL
            // Si arroja Excepcion SQL relacionada con la zona horaria, en la consola SQL escribir: SET GLOBAL time_zone = "-3:00";
            //Aqui mandamos la url donde viene la direccion de la BD, nuestro nombre de usuario y la contraseña, que por defecto al instalar viene vacia
            if (con != null)//Si logramos conectarnos, con deja de apuntar a null y obtenemos conexion
            {
                System.out.println("Conexión a base de datos funcionando");
            }
            else
                System.out.println("Error al conectarse; Si en la consola aparece error relacionado a serverTimezone considere SET GLOBAL time_zone = \"-3:00\"; en la consola de MySQL");
        }
        catch(Exception e)//Agarramos excepciones de tipo SQL
        {
            System.out.println(e);
        }
        return con;
    }
}
