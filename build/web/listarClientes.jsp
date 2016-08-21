<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page import="hotel.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Clientes</title>
    </head>
    <body>
        <div id="voltar">
             <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear: both">
            <h1>Lista de Clientes Cadastrados</h1>
        </div>
        <div style="clear: both">
            <table border="1">
                <tr>
                    <th>Id</th><th>Nome</th><th>Endereço</th><th>Email</th>
                </tr>
                <% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                    if (clientes != null) {
                        for (Cliente cliente : clientes) {%>
                <tr>
                    <td><%= cliente.getClienteId()%></td>
                    <td><%= cliente.getNome()%></td>
                    <td><%= cliente.getEndereco()%></td>
                    <td><%= cliente.getEmail()%></td>
                </tr>
                <%  }
                    }%>
            </table>
        </div>
    </body>
</html>
