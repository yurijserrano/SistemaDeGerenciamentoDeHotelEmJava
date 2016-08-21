<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page import="hotel.Cliente"%>
<%@page import="hotel.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Reservado!</title>
    </head>
    <body>
        <%
            Reserva reserva = (Reserva) request.getAttribute("reserva");
            Cliente cliente = (Cliente) request.getAttribute("cliente");
        %>
        <div id="voltar">
            <form method="POST" action="homeRede.jsp"> 
                <input class="botao" type="submit" value="Home"/>
            </form>
        </div>
        <div  align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:30%;">
            <h1>RESERVA REALIZADA COM SUCESSO</h1>
            <h4>Cliente: <%= cliente.getNome()%></h4>
            <h4>Endereço: <%= cliente.getEndereco()%></h4>
            <h4>Email: <%= cliente.getEmail()%></h4>
            <br>
            <h4>Quarto: <%= reserva.getQuartoId()%></h4>
            <h4>Inicio: <%= reserva.getInicio()%></h4>
            <h4>Fim: <%= reserva.getFim()%></h4>
            <h4>Codigo da Reserva: <%= reserva.getReservaId()%> </h4>
            <br>
            <h4>FOI ENVIADO UM E-MAIL CONFIRMANDO A RESERVA</h4>
        </div>
    </body>
</html>
