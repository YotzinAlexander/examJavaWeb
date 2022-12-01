/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Login;
import modelo.VentasDAO;
import modelo.Ventas;

/**
 *
 * @author adm_usr
 */
public class Controlador extends HttpServlet {
    VentasDAO dao= new VentasDAO();
    Login p = new Login();
    int result;
    String ventas="Tabla.jsp";
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8"); 
        String accion=request.getParameter("accion");
        //System.out.print("ACCION "+accion);
        if (accion.equals("Ingresar")) {
            String user= request.getParameter("txtUser");
            String password= request.getParameter("txtPassword"); 
            p.setUser(user);
            p.setPassword(password);   
            result=dao.validar(p); 
            if (result ==1) {
                
                List<Ventas> lista= dao.Ventas(); 
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("Tabla.jsp").forward(request, response);
                
            }else{ 
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
        } else if(accion.equals("Buscar")){ 
            
            String date= request.getParameter("txtBuscar");
            List<Ventas>lista=dao.Buscar(date);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("Tabla.jsp").forward(request, response);
            
        }
                
    }
}
