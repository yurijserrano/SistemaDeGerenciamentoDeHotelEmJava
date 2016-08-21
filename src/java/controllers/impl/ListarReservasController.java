package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.ReservaDAO;
import hotel.Data;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Serrano
 */
public class ListarReservasController
                extends AbstractController {

    @Override
    public void execute() {
        ReservaDAO dao = new ReservaDAO();
        
        try {
            List<Data> dados = dao.getData();
            this.getRequest().setAttribute("dados", dados);
            this.setReturnPage("/listarReservas.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
