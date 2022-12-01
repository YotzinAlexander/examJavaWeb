<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Ventas"%>
<%@page import="modelo.VentasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Tabla Ventas</title>
    </head>
    <body>
        <div  class="container">
            <br/>
            <h1 class="text-center text-secondary">CONSULTA DE VENTAS</h1>
            
            <div>
                    <a></a>
                    <form>
                        <input type="search" name="txtBuscar" class="form-control" placeholder="Ingresar Folio de Venta;   501  Y 502"/>
                        <br/>
                        <input type="submit" name="accion" value="Buscar" class="btn btn-danger btn-block"/>
                    </form>
            </div>
            <br/>
            
            <table class="table table-dordered">
                <thead class="text-success">
                <th class="text-center">No.</th>
                <th class="text-center">Producto</th>
                <th class="text-center">Cantidad</th>
                <th class="text-center">Precio Unitario</th>
                <th class="text-center">Total</th>

                </thead>
                <tbody id="">
                    <% 
                            int cont = 0; 
                    %>
                    <c:forEach var="listaa" items="${lista}">
                        <%
                            
                            cont = cont+1; 

                        %>
                        <tr>
                            <td class="text-center"><%=cont%></td>
                            <td class="text-center">${listaa.getProducto()}</td>
                            <td class="text-center">${listaa.getCantidad()}</td>
                            <td class="text-center">${listaa.getPrecioU()}</td>
                            <td class="text-center">${listaa.getCantidad()*listaa.getPrecioU()}</td>
                        </tr>
                        
                    </c:forEach>
                <th>Total de Productos</th>
                <tbody>
                <td><%=cont%></td>
                </tbody>
                
                <th>Total de Ventas</th>
                <tbody>
                    <c:set var="sumTotal" value="${0}"/>
                    <c:forEach var="listaa" items="${lista}">
                        <c:set var="sumTotal" value="${sumTotal + listaa.getTotal()}"/>
                    </c:forEach>
                    <td>${sumTotal}</td>
                </tbody>
            </thead>
                    
                    
                </tbody>
            </table>
                    
                
                
            
        </div>
    </body>
</html>
