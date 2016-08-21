<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
    </head>
    <body>
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;">
            <h1>Cadastro de Clientes</h1>
            <h3>Insira os dados</h3>
            <form method="POST" action="FrontController" >
                <table>
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
                        <th>Senha:</th>
                        <td><input type="password"  name="senha"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><input type="hidden" name="control" value="AddCliente"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><p><input type="submit" value="Cadastrar"/></p></td>
                    </tr>              
                </table>
            </form>
        </div>
    </body>
</html>
