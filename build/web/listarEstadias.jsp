<%-- 
    Document   : listarEstadias
    Created on : Nov 6, 2014, 8:35:47 PM
    Author     : Serrano
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="hotel.Data"%>
<%@page import="hotel.Estadia"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Estadias</title>
    </head>
    <body>
        <div id="voltar">
             <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear: both">
            <h1>Lista de Estadias</h1>
        </div>
        <div style="clear: both">
            <table border="1">
                <tr>
                    <th>Id Estadia</th><th>Nome Hospede</th><th>Id do Quarto </th><th>Inicio </th><th>Fim </th>
                    
                </tr>
                <% 
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    List<Data> dados = (List<Data>) request.getAttribute("dados");
                    if (dados != null) {
                        for (Data dado : dados) {%>
                <tr>
                    <td><%= dado.getEstadiaId()%></td>
                    <td><%= dado.getHospede() %></td>
                    <td><%= dado.getQuartoId()%></td>
                    <td><%= formatter.format(dado.getInicio())%></td>
                    <td><%= formatter.format(dado.getFim())%></td>
                </tr>
                <%      }
                    } %>
            </table>
        </div>
    </body>
</html>
