<%-- 
    Document   : removerHospede
    Created on : Nov 6, 2014, 9:15:03 PM
    Author     : Serrano
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Hospede</title>
    </head>
    <body>
        <div align="center" style="border:1px;border-style:dotted;padding:10px;position:absolute;margin-right:20%;margin-left:40%;">
            <h1>Insira os dados para Remoção</h1>
            <form action="FrontController" method="POST">
                <table>
                    <tr>
                        <th>Id:</th>
                        <td><input type="number"  name="id"/></td>
                    </tr>
                                       
                    <tr>
                        <th></th>
                        <td><input type="hidden" name="control" value="RemoveHospede"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><p><input type="submit" value="Remover"/></p></td>
                    </tr>              
                </table>
            </form>
        </div>
    </body>
</html>
