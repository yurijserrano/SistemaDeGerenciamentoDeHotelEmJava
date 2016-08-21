<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page import="hotel.Hotel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Hotéis</title>
    </head>
    <body>
        <div id="voltar">
            <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear:both">
            <h1>Lista de Hotéis da Rede</h1>
        </div>
        <div style="clear:both">
            <table border="1">
                <tr>
                    <th>Id</th><th>Nome</th><th>Endereço</th>
                </tr>
                <% List<Hotel> hoteis = (List<Hotel>) request.getAttribute("hoteis");
                    if (hoteis != null) {
                        for (Hotel hotel : hoteis) {%>
                <tr>
                    <td><%= hotel.getHotelId()%></td>
                    <td><%= hotel.getNome()%></td>
                    <td><%= hotel.getEndereço()%></td>
                </tr>
                <%  }
                    }%>
            </table>
        </div>
    </body>
</html>
