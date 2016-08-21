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
public class UpdateClienteController
                extends AbstractController
{

    @Override
    public void execute() {
        try {
            HttpServletRequest request = getRequest();
            Cliente cliente = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            String nome = request.getParameter("nome");
            cliente.setClienteId(Integer.parseInt(request.getParameter("id")));
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            cliente = dao.read(cliente.getClienteId());
            
            if(!((nome == null || "".equals(nome) || nome.trim().equals("  ") || nome.equals(""))))
            {
                cliente.setNome(nome);
            }
            if(!((endereco == null || "".equals(endereco) || endereco.trim().equals("  ") || endereco.equals(""))))
            {
                cliente.setEndereço(endereco);
            }
            if(!((email == null || "".equals(email) || email.trim().equals("  ") || email.equals(""))))
            {
                cliente.setEmail(email);
            }
            
            
            
            
            
            cliente.setClienteId(Integer.parseInt(request.getParameter("id")));
            
                       
            try {
                dao.update(cliente);
                
                List<Cliente> clientes = dao.readAll();
                this.getRequest().setAttribute("clientes", clientes);
                this.setReturnPage("/listarClientes.jsp");
            } catch (DAOException ex) {
                Logger.getLogger(AddClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(UpdateClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
