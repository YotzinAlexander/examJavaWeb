/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adm_usr
 */
public class VentasDAO implements Metodos{
    Connection comnection;
    Conexion cn= new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    

    @Override
    public int validar(Login per) {
        int r=0;
        String sql="SELECT * from usuario where user=? and password=?"; 
        //* SELECT * from usuario where user="admin" and password="admin"       
        try {
            comnection = cn.getConnection();
            ps=(PreparedStatement) comnection.prepareStatement(sql);
            ps.setString(1,per.getUser());
            ps.setString(2,per.getPassword());
            rs = ps.executeQuery();   
            while (rs.next()) {
                r=r+1;
                per.setUser(rs.getString("user"));
                per.setPassword(rs.getString("password"));
                
            }
            
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        
    }

    @Override
    public List Ventas() {
    ArrayList<Ventas>list=new ArrayList<>();
        String sql="SELECT * from ventas"; 
        try {
            comnection = cn.getConnection();
            ps=(PreparedStatement) comnection.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Ventas vent = new Ventas();
                vent.setId(rs.getInt("id"));
                vent.setFolio(rs.getInt("folio"));
                vent.setProducto(rs.getString("producto"));
                vent.setCantidad(rs.getInt("cantidad"));
                vent.setPrecioU(rs.getDouble("precioUnitario"));
                list.add(vent);
                
            }
            
        } catch (Exception e) {
            
        }
        return list;
        
    }
    @Override
    public List Buscar(String texto) {
        List<Ventas> list=new ArrayList<>();
        //SELECT * FROM `ventas` WHERE `folio` LIKE '502'
        //SELECT * FROM `ventas` WHERE `folio` LIKE '501'
        String sql = "SELECT * FROM `ventas` WHERE `folio` LIKE '%"+texto+"%'";
        try {
            comnection=cn.getConnection();
            ps=(PreparedStatement) comnection.prepareStatement(sql);
            rs=ps.executeQuery();
           
            while (rs.next()) {                
                Ventas ventaL = new Ventas();
                ventaL.setFolio(rs.getInt("folio"));
                ventaL.setProducto(rs.getString("producto"));
                ventaL.setCantidad(rs.getInt("cantidad"));
                ventaL.setPrecioU(rs.getDouble("precioUnitario"));
                
                double b = Double.valueOf(rs.getInt("cantidad"));
                double total = b * rs.getDouble("precioUnitario"); 
                
                ventaL.setTotal(total);
                list.add(ventaL);
                 
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return list;
    }
    
   
    
}
