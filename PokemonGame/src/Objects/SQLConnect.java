/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import org.mariadb.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jin9669
 */
public class SQLConnect {
    private static SQLConnect instance;
    static final String DRIVER = "org.mariadb.jdbc.Driver";
    static final String PROTOCOL = "jdbc:mariadb:";
    static final String HOST = "127.0.0.1"; //localhost
    static final String BD_NAME = "pokemondb";
    static final String USER = BD_NAME;
    static final String PASSWORD = "Jeremy2006";
    
    public SQLConnect() throws ClassNotFoundException{
        //Carga el driver en la memoria
        loadDriver();
    }
    
    public static void loadDriver() throws ClassNotFoundException{
        Class.forName(DRIVER);
    }
    
    public static SQLConnect getInstance() throws ClassNotFoundException{
            if (instance == null) {
            instance = new SQLConnect();
        }
        return instance;
    }
    
    /*Conexion a la base de datos*/
    public static Connection getConnection() throws SQLException{
        final String BD_URL = String.format("%s//%s/%s", PROTOCOL, HOST, BD_NAME);
        Connection conn = null;
        conn = (Connection) DriverManager.getConnection(BD_URL, USER, PASSWORD);
        return conn;
    }
}
