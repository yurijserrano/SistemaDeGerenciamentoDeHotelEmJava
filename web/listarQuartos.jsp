<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page import="hotel.Data"%>
<%@page import="hotel.Quarto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Quartos</title>
    </head>
    <body>
        <div id="voltar">
             <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear: both">
        <h1>Lista de Quartos da Rede</h1>
        </div>
        <div style="clear: both">
        <table border="1">
            <tr>
                <th>Nome Hotel</th><th>Id Quarto</th><th>Tipo</th>
            </tr>
            <% List<Data> dados = (List<Data>) request.getAttribute("dados");
                if (dados != null) {
                    for (Data dado : dados) { %>
                        <tr>
                            <td><%= dado.getHotel() %></td>
                            <td><%= dado.getQuartoId() %></td>
                            <td><%= dado.getTipo() %></td>
                        </tr>
                <%  }
                } %>
        </table>
        </div>
    </body>
</html>
