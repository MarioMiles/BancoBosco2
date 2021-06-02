<%@page import="modelo.Cuota"%>
<%@page import="modelo.Prestamo"%>
<%@page import="modelo.Utilidades"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Banco Bosco</title>
         </head>
    <body>
       

            
        <a href="/ServletPrestamos">Abrir servlet</a>
        </nav>
        <br>
        <br>
        <div style="text-align: center">
            <h2>Solicitud de Prestamos</h2>
            <%
            ArrayList<String> listaMeses = ( ArrayList<String> ) request.getAttribute("listaMeses");

            String nombre=( String ) request.getAttribute("nombre");
               if (nombre==null) {
                   nombre="";
               }
            Prestamo miPrestamo = ( Prestamo ) request.getAttribute("miPrestamo");
            double capital=0;
            double interes=0;
            int mesPres=12;
            if ( miPrestamo!=null) {
                    capital=miPrestamo.getCapital(); 
                    interes=miPrestamo.getInteres();
                    mesPres= miPrestamo.getMesActual();
                }
            %>
            <form action="ServletPrestamos" method="post">
                <p><label>Nombre:</label><input type="text" name="nombre" value="<%=nombre%>"></p>
                <p><label>Capital que solicita:</label><input type="text" name="capital" value="${miPrestamo.capital}"></p>
                <p><label>Interes:</label><input type="text" name="interes" value="${miPrestamo.interes}"></p>
                <p><label>Tiempo(en meses):</label>
                    <select name="mesPres">
                         <%

                            for ( String a: listaMeses ){
                              String cadenaSelected="";
                              if ( Integer.parseInt(a)==mesPres){
                                  cadenaSelected = " selected ";
                              }

                              out.println("<option value=" + a + cadenaSelected +">" + a + "</option>" );
                          }
                           %>

                    </select>
                </p>
                <input type="submit" value="Calcular">
                <h1>ImporteTotalPrestamo: ${miPrestamo.importePrestamo}</h1> 
            </form>
            <%
                ArrayList<Cuota> genereListaCuotas = ( ArrayList<Cuota> ) request.getAttribute("genereListaCuotas");
                    
                if(genereListaCuotas!=null){
                    out.println("<table border='1'>"
                            + "<tr>"
                            +   "<td>NºCuota</td>"
                            +   "<td>Importe</td>"
                            +   "<td>Capital</td>"
                            +   "<td>Interes</td>"
                            + "</tr>");
                  for(int i=1;i<=genereListaCuotas.size();i++){
                    out.println("<tr>"
                            +   "<td>"+i+"</td>"
                            +   "<td>"+genereListaCuotas.get(1)+"</td>"
                            +   "<td></td>"
                            +   "<td></td>"
                            + "</tr>" );
                            
                    }
                   out.println("</table>");
                    
                }
                
            
            %>
        </div>
    </body>
</html>
