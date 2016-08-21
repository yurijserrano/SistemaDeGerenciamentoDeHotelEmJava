<%-- 
    Document   : cadastrarHotel
    Created on : Nov 4, 2014, 3:01:19 PM
    Author     : Serrano
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Hoteis</title>
    </head>
    <body>
        
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;">
            <h1>Cadastro de Hoteis</h1>
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
                        <th></th>
                        <td><input type="hidden" name="control" value="AddHotel"/></td>
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
