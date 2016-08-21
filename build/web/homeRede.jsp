<%--
    Created on : 23/10/2014, 10:50:27
    Author     : Yuri Serrano
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="hotel.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.HotelDAO" %>  

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Hotel do Picci</title>
    </head>
    <body>
        <div id="container" align="center">
            <h1>Hotel do Picci</h1>
            <img src="http://www.jm1.com.br/wp-content/uploads/2012/09/DSC0138.jpg" alt="Formule Two" height="200" width="400">
            <img src="https://www.sbtur.com/portal/img/hoteis/1635001.jpg" alt="Max Hotel" height="200" width="400">
            <img src="http://t0.gstatic.com/images?q=tbn:ANd9GcSDU72ekjo-_7JR3QZN-flK1RbFSFJzxCpESKOn2i1u7XCc4Ad-" alt="Novo Hotel" height="200" width="400">
            <div>
                <div id="formulario">
                    <form method="POST" action="FrontController">
                        Quarto <select id="quarto" name="tipo">
                            <option>padrao</option>
                            <option>executivo</option>
                            <option>luxo</option>
                        </select><br><br>
                        Hotel <select id="hotel" 
                                      name="hotel">
                            <%
                                HotelDAO hotel = new HotelDAO();
                                List<Hotel> hoteis =  hoteis = hotel.readAll();
                                
                                
                                for(Hotel hot:hoteis)
                                {   
                                    out.println("<option value='"+hot.getHotelId()+"'>"+hot.getNome()+"</option>");
                                    
                                }
                            
                          
                                    %>
                        </select><br><br>
                        <fieldset class="date"> 
                            <legend>Data Inicial </legend> 
                            <input type="date" name="inicio">         
                        </fieldset> 
                        <fieldset class="date"> 
                            <legend>Data Final </legend> 
                            <input type="date" name="fim"> 
                        </fieldset>
                        
                        <input type="hidden" name="control" value="FazReserva"/>
                        <input class="botao right" type="submit" value ="Pesquisar">
                        
                        </form>
                    
                </div>
                <div id="texto" align="justify">
                    <h3>Conheça Nossa Rede</h3>
                    <p>&nbsp;Por todo o mundo, nosso padrão garante a seus hóspedes uma oferta única: quartos modernos, com wi-fi grátis e a prova de som, uma cama inovadora e superconfortável, café da manhã das 4h às 12h, e uma grande variedade de conceitos de restaurantes.
                        Aconchegante e eficiente, é a única rede econômica europeia que oferece os principais serviços 24 horas por dia, nos 7 dias da semana, por exemplo: recepção e refeições lights servidas nos bares. 
                        Devido a sua grande exigência de qualidade, a nossa rede tem a certificação ISO 9001, que é reflexo do contrato 15 minutos. Pioneiro no compromisso com o meio ambiente, nossa rede também obteve a certificação ISO 14001.</p>
                </div>
                <div id="botoes">
                    <form method="POST" action="checarReserva.jsp"> 
                        <input class="botao left" type="submit" value="Ocupar Reserva" name="Ocupar"/>
                    </form>
                   
                    <form method="POST" action="cadastrarse.jsp">
                      <input class="botao left" type="submit" value="Cadastre-se Aqui"/>
                    </form>
                    
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarReservas">
                        <input class="botao left" type="submit" value="Listar Reservas"/>
                    </form>
                    
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarClientes">
                        <input class="botao left" type="submit" value="Listar Clientes"/>
                    </form>

                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarEstadias">
                        <input class="botao left" type="submit" value="Listar Estadias"/>
                    </form>
                    
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarHospedes">
                        <input class="botao left" type="submit" value="Listar Hospedes"/>
                    </form>
                    
                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarHoteis">
                        <input class="botao left" type="submit" value="Listar Hoteis"/>
                    </form>

                    <form method="POST" action="FrontController">
                        <input type="hidden" name="control" value="ListarQuartos">
                        <input class="botao left" type="submit" value="Listar Quartos"/>
                    </form>



                    

                    
                </div>
            </div>
        </div>
    </body>
</html>
