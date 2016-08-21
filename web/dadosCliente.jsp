<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Cliente</title>
    </head>
    <body>
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;"> 
            <h1>Insira os Dados para Confirmar a Reserva </h1>
            <p><strong>Quarto: <%= request.getParameter("quarto") %></strong></p>
            <p><strong>Inicio: <%= request.getParameter("inicio") %></strong></p>
            <p><strong>Fim: <%= request.getParameter("fim") %></strong></p>
            <form action="FrontController" method="POST">
                <table>
                    <tr>
                        <th>Nome:</th>
                        <td><input type="text" name="nome"/></td>
                    </tr>
                    <tr>
                        <th>Endereço:</th>
                        <td><input type="text" name="endereco" /></td>
                    </tr>
                    <tr>
                        <th>E-mail:</th>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <th>Senha:</th>
                        <td><input type="password" name="email" /></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="quarto" value="<%= request.getParameter("quarto") %>"> </td>
                        <td><input type="hidden" name="inicio" value="<%= request.getParameter("inicio") %>"> </td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="fim" value="<%= request.getParameter("fim") %>"></td>
                        <td><input type="hidden" name="control" value="CriarReserva"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
