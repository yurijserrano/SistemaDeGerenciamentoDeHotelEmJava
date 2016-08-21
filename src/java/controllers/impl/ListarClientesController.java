package controllers.impl;

import controllers.AbstractController;
import dao.ClienteDAO;
import dao.DAOException;
import hotel.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Serrano
 */
public class ListarClientesController
                extends AbstractController
{

    @Override
    public void execute() {
        ClienteDAO dao = new ClienteDAO();
        
        try {
            List<Cliente> clientes = dao.readAll();
            this.getRequest().setAttribute("clientes", clientes);
            this.setReturnPage("/listarClientes.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
