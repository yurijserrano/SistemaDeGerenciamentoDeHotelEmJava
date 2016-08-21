package controllers.impl;

import controllers.AbstractController;
import dao.ClienteDAO;
import dao.DAOException;
import hotel.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public class AddClienteController
                extends AbstractController {

    @Override
    public void execute() {
        HttpServletRequest request = getRequest();
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setEndereço(request.getParameter("endereco"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setSenha(request.getParameter("senha"));
        ClienteDAO dao = new ClienteDAO();
        
        try {
            dao.create(cliente);

            List<Cliente> clientes = dao.readAll();
            this.getRequest().setAttribute("clientes", clientes);
            this.setReturnPage("/listarClientes.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
