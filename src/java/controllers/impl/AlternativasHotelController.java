/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.QuartoDAO;
import hotel.Data;
import hotel.Quarto;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public class AlternativasHotelController
                extends AbstractController
{

    @Override
    public void execute() {
        HttpServletRequest request = getRequest();
        Data pedido = new Data();
        pedido.setHotelId(Long.parseLong(request.getParameter("hotel")));
        pedido.setTipo(request.getParameter("tipo"));
        pedido.setInicio(LocalDate.parse(request.getParameter("inicio")));
        pedido.setFim(LocalDate.parse(request.getParameter("fim")));

        QuartoDAO dao = new QuartoDAO();
        List<Quarto> quartos = null;

        try {
            quartos = dao.getQuartosAlternativosHotel(pedido);
        } catch (DAOException ex) {
            Logger.getLogger(FazReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getRequest().setAttribute("pedido", pedido);
        this.getRequest().setAttribute("quartos", quartos);
        this.setReturnPage("/quartosDisponiveis.jsp");
    }
    
}
