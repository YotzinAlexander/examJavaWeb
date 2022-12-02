/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author adm_usr
 */

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
  
    Connection con;
    
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="GBK4VWwOs4";
    private static final String url="jdbc:mysql://node121657-env-6609444.jelastic.saveincloud.net:3306/examen";
    
    
     public Connection getConnection() {
        con=null;
        try {
            Class.forName(driver);
            
            con= (Connection) DriverManager.getConnection(url, user, pass);          
            
            if (con!=null){
               System.out.println("Conexión a BD exitosa.");
            }
 
        } catch (Exception e) {
            System.out.println(e);
        }
         return con;
    }
    
    
    
     
}
