<%-- 
    Document   : listarHospedes
    Created on : Nov 6, 2014, 7:33:22 PM
    Author     : Serrano
--%>

<%@page import="hotel.Hospede"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Lista de Hospedes</title>
    </head>
    <body>
        <div id="voltar">
            <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Voltar"/>
            </form>
        </div>
        <div style="float: left; clear: both">
            <h1>Lista de Hospedes </h1>
        </div>
        <div style="clear: both">
            <table border="1">
                <tr>
                    <th>Id_Hospede</th><th>Id_Cliente</th><th>Nome</th><th>Endereço</th><th>Email</th>
                </tr>
                <% List<Hospede> hospedes = (List<Hospede>) request.getAttribute("hospedes");
                    if (hospedes != null) {
                        for (Hospede hospede : hospedes) {%>
                <tr>
                    <td><%= hospede.getHospedeId()%></td>
                    <td><%= hospede.getClienteId()%></td>
                    <td><%= hospede.getNome()%></td>
                    <td><%= hospede.getEndereco()%></td>
                    <td><%= hospede.getEmail()%></td>
                </tr>
                <%  }
                    }%>
            </table>
        </div>
    </body>
</html>
