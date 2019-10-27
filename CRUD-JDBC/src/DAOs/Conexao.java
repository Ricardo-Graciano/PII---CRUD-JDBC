package DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danilo
 */
public class Conexao {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    //COM DOCKER 192.168.99.100 SEM DOCKER 127.0.0.1
    public static String URL = "jdbc:mysql://127.0.0.1:3306/ueg?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    public static String USER = "";
    public static String PASS = "";
    
    public static Connection getConnection(){
        try{            
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }
        catch(ClassNotFoundException | SQLException e ){
            System.err.println("Erro" + e.getMessage());
            return null;
        }
    }
    public static void closeConnection(Connection conn){
     try{
        if(conn!=null){
            conn.close();
         }    
        }
     catch(SQLException e){
            System.out.println("Erro ao desconectar" +e.getMessage());
        }
    }
    
            
    
}
