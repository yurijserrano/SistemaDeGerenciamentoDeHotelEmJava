/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.ReservaDAO;
import hotel.Data;
import hotel.Reserva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class RemoveReservaController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Reserva reserva = new Reserva();
        reserva.setReservaId(Integer.parseInt(request.getParameter("id")));
        ReservaDAO dao = new ReservaDAO();
        
        try {
            dao.delete(reserva.getReservaId());

            List<Data> dados = dao.getData();
            this.getRequest().setAttribute("dados", dados);
            this.setReturnPage("/listarReservas.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(RemoveReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
