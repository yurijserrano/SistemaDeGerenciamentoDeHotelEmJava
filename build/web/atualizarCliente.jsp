<%-- 
    Document   : atualizarCliente
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Clientes</title>
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
                        <th>E-mail:</th>
                        <td><input type="text"  name="email"/></td>
                    </tr>
                    
                    <tr>
                        <th></th>
                        <td><input type="hidden" name="control" value="UpdateCliente"/></td>
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
