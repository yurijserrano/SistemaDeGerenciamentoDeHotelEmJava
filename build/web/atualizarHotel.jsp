<%-- 
    Document   : atualizarHotel
    Created on : Nov 4, 2014, 3:46:09 PM
    Author     : Serrano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Hotel</title>
    </head>
    <body>
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;">
            <h1>Insira os dados para Atualização</h1>
            <form action="FrontController" method="POST">
                <table>
                    <tr>
                        <th>Id:</th>
                        <td><input type="number"  name="id"/></td>
                    </tr>
                    <tr>
                        <th>Nome:</th>
                        <td><input type="text"  name="nome"/></td>
                    </tr>
                    <tr>
                        <th>End.:</th>
                        <td><input type="text"  name="endereco"/></td>
                    </tr>
                    
                    <tr>
                        <th></th>
                        <td><input type="hidden" name="control" value="UpdateHotel"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><p><input type="submit" value="Atualizar"/></p></td>
                    </tr>              
                </table>
            </form>
        </div>
    </body>
</html>
