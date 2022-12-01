/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author adm_usr
 */

import java.io.IOException;
import modelo.Conexion;

public class pruebaConexion {
       public static void main(String[] args) throws IOException {
        Conexion c = new Conexion();
        c.getConnection();

    }

}
