<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checar a Reserva</title>
    </head>
    <body>
        <h1>Checar Reserva</h1>
        <h2>Entre com o código da reserva</h2>
        <div align="center" style="border:1px;border-style:dotted;padding:30px;position:relative;margin-right:40%;margin-left:10%; margin-top: 10%">
        <form action="FrontController" method="POST">
                <table>
                    <tr>
                        <th>Codigo da Reserva:</th>
                        <td><input type="text" name="id"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="hidden" name="control" value="ChecarReserva"></td>
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
