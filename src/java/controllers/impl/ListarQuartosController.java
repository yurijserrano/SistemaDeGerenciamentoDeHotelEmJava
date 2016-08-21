package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.QuartoDAO;
import hotel.Data;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Serrano
 */
public class ListarQuartosController
                extends AbstractController
{
    @Override
    public void execute() {
        QuartoDAO dao = new QuartoDAO();
        
        try {
            List<Data> dados = dao.getData();
            this.getRequest().setAttribute("dados", dados);
            this.setReturnPage("/listarQuartos.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
