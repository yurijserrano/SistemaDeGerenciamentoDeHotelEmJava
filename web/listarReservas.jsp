<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hotel.Data"%>
<%@page import="hotel.Reserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Reservas</title>
    </head>
    <body>
        <div id="voltar">
             <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear: both">
            <h1>Lista de Reservas de Quartos</h1>
        </div>
        <div style="clear: both">
            <table border="1">
                <tr>
                    <th>Id Reserva</th><th>Id Quarto</th><th>Cliente</th>
                    <th>Inicio</th><th>Fim</th>
                </tr>
                <% 
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    List<Data> dados = (List<Data>) request.getAttribute("dados");
                    if (dados != null) {
                        for (Data dado : dados) { %>
                <tr>
                    <td><%= dado.getReservaId()%></td>
                    <td><%= dado.getQuartoId() %></td>
                    <td><%= dado.getCliente() %></td>
                    <td><%= formatter.format(dado.getInicio())%></td>
                    <td><%= formatter.format(dado.getFim())%></td>
                </tr>
                <%      }
                    } %>
            </table>
        </div>
    </body>
</html>
