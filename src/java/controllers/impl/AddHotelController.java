package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.HotelDAO;
import hotel.Cliente;
import hotel.Hotel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public class AddHotelController
                extends AbstractController {

    @Override
    public void execute() {
        HttpServletRequest request = getRequest();
        Hotel hotel = new Hotel();
        hotel.setNome(request.getParameter("nome"));
        hotel.setEndereço(request.getParameter("endereco"));
        
        HotelDAO dao = new HotelDAO();
        
        try {
            dao.create(hotel);

            List<Hotel> hoteis = dao.readAll();
            this.getRequest().setAttribute("hoteis", hoteis);
            this.setReturnPage("/listarHoteis.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
