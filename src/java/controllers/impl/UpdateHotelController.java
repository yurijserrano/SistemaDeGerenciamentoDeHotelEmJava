/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.impl;

import controllers.AbstractController;
import dao.HotelDAO;
import dao.DAOException;
import hotel.Hotel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class UpdateHotelController extends AbstractController {

    @Override
    public void execute() {
        try {
            HttpServletRequest request = getRequest();
            Hotel hotel = new Hotel();
            HotelDAO dao = new HotelDAO();
            hotel.setHotelId(Integer.parseInt(request.getParameter("id")));
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
           
            hotel = dao.read(hotel.getHotelId());
            
            if (!((nome == null || "".equals(nome) || nome.trim().equals("  ") || nome.equals("")))) {
                hotel.setNome(nome);
            }
            if (!((endereco == null || "".equals(endereco) || endereco.trim().equals("  ") || endereco.equals("")))) {
                
                hotel.setEndereço(endereco);
            }
            
            try {
                dao.update(hotel);
                
                List<Hotel> hoteis = dao.readAll();
                this.getRequest().setAttribute("hoteis", hoteis);
                this.setReturnPage("/listarHoteis.jsp");
            } catch (DAOException ex) {
                Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(UpdateHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
