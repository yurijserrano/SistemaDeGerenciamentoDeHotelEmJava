<%-- 
    Document   : cadastrarQuarto
    Created on : Nov 5, 2014, 2:34:57 PM
    Author     : Serrano
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Quartos</title>
    </head>
    <body>
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;">
            <h1>Cadastro de Quartos</h1>
            <h3>Insira os dados</h3>
            <form method="POST" action="FrontController" >
                <table>
                    <tr>
                        <th>Id do Hotel:</th>
                        <td><input type="number"  name="id"/></td>
                    </tr>
                    <tr>
                        <th>Tipo do Quarto:</th>
                        <td><input type="text"  name="quarto"/></td>
                    </tr>
                    
                    <tr>
                        <th></th>
                        <td><input type="hidden" name="control" value="AddQuarto"/></td>
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
