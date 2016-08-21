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
        <title>Lista os quartos disponiveis</title>
    </head>
    <body>
        <h1>Lista de Quartos Disponiveis</h1>
        <% Data pedido = (Data) request.getAttribute("pedido");%>
        <h3>Data Inicial: <%= pedido.getInicio()%></h3>
        <h3>Data Final: <%= pedido.getFim()%></h3>
        <br/>
        <table border="1">
            <tr>
                <th>Id Hotel</th><th>Id Quarto</th><th>Tipo</th><th>Diaria</th><th></th>
            </tr>
            <% List<Quarto> quartos = (List<Quarto>) request.getAttribute("quartos");
                if (quartos != null) {
                    for (Quarto quarto : quartos) {%>
            <tr>
                <td><%= quarto.getHotelId()%></td>
                <td><%= quarto.getQuartoId()%></td>
                <td><%= quarto.getTipo()%></td>
                <td>R$ <%= quarto.getDiaria()%></td>
                <td>
                    <form action="dadosCliente.jsp" method="POST">
                        <input type="hidden" name="quarto" value="<%= quarto.getQuartoId()%>">
                        <input type="hidden" name="inicio" value="<%= pedido.getInicio()%>">
                        <input type="hidden" name="fim" value="<%= pedido.getFim()%>">
                        <input type="submit" value="Reservar">
                    </form>
                </td>
            </tr>
            <%      }
                } %>
        </table>
        <br>
        <h3>Quartos de outras categorias disponíveis neste Hotel neste período:</h3>
        <form method="POST" action="FrontController">
            <input type="hidden" name="hotel" value="<%= pedido.getHotelId() %>"/>
            <input type="hidden" name="tipo" value="<%= pedido.getTipo() %>"/>
            <input type="hidden" name="inicio" value="<%= pedido.getInicio() %>"/>
            <input type="hidden" name="fim" value="<%= pedido.getFim() %>"/>
            <input type="hidden" name="control" value="AlternativasHotel"/>
            <input class="botao" style="font-size: 16px" type="submit" value="Alternativas no Hotel"/>
        </form>
        <br>
        <h3>Quartos da mesma categoria disponíveis em todos os hoteis da rede neste período:</h3>
        <form method="POST" action="FrontController">
            <input type="hidden" name="hotel" value="<%= pedido.getHotelId() %>"/>
            <input type="hidden" name="tipo" value="<%= pedido.getTipo() %>"/>
            <input type="hidden" name="inicio" value="<%= pedido.getInicio() %>"/>
            <input type="hidden" name="fim" value="<%= pedido.getFim() %>"/>
            <input type="hidden" name="control" value="AlternativasRede"/>
            <input class="botao" style="font-size: 16px" type="submit" value="Alternativas na Rede"/>
        </form>    
    </body>
</html>
