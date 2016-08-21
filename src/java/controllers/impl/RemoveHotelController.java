/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.HotelDAO;
import hotel.Hotel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class RemoveHotelController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Hotel hotel = new Hotel();
        hotel.setHotelId(Integer.parseInt(request.getParameter("id")));
        HotelDAO dao = new HotelDAO();
        
        try {
            dao.delete(hotel.getHotelId());

            List<Hotel> hoteis = dao.readAll();
            this.getRequest().setAttribute("hoteis",hoteis);
            this.setReturnPage("/listarHoteis.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
