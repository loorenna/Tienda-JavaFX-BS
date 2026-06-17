package org.example.tareafxconbs;
import  java.sql.*;
public class Conexion {
        public static Connection getConexion() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/tienda";
            String user = "postgres";
            String pass = "123456";
            return DriverManager.getConnection(url, user, pass);
        }
}
