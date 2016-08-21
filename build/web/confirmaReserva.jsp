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
        <link rel="stylesheet" href="style.css" />
        <title>Confirmação da Reserva</title>
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
        <div  align="center" style="border:1px;border-style:dotted;padding:10px;position:relative;margin-right:20%;margin-left:30%;">
            <h1>Reserva</h1>
            <% if(cliente != null) { %>
            <h4>Cliente: <%= cliente.getNome()%></h4>
            <h4>Endereço: <%= cliente.getEndereco()%></h4>
            <h4>Email: <%= cliente.getEmail()%></h4>
            <% } %>
            <br>
            <% if (reserva != null) { %>
            <h4>Quarto: <%= reserva.getQuartoId()%></h4>
            <h4>Inicio: <%= reserva.getInicio()%></h4>
            <h4>Fim: <%= reserva.getFim()%></h4>
            <% } %>
        </div>
        <div id="voltar">
            <h3>Confirme os dados da reserva e clique no botão para iniciar Estadia</h3>
            <form method="POST" action="FrontController">
                
                <input type="hidden" name="clienteid" value="<%= cliente.getClienteId()%>"/>
                <input type="hidden" name="clientenome" value="<%= cliente.getNome()%>"/>
                <input type="hidden" name="clienteendereco" value="<%= cliente.getEndereco()%>"/>
                <input type="hidden" name="clienteemail" value="<%= cliente.getEmail()%>"/>
                <input type="hidden" name="reservaquarto" value="<%= reserva.getQuartoId()%>"/>
                <input type="hidden" name="reservainicio" value="<%= reserva.getInicio()%>"/>
                <input type="hidden" name="reservafim" value="<%= reserva.getFim()%>"/>
                
                <input type="hidden" name="control" value="IniciaEstadia"/>
                <input class="botao" align="center" type="submit" value="Iniciar Estadia"/>
            </form>
        </div>
    </body>
</html>
