/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author adm_usr
 */
public interface Metodos {
   public int validar(Login per);
   public List Ventas();
   public List Buscar(String texto);
}
