/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author Serrano
 */
public class RemoveClienteController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Cliente cliente = new Cliente();
        cliente.setClienteId(Integer.parseInt(request.getParameter("id")));
        ClienteDAO dao = new ClienteDAO();
        
        try {
            dao.delete(cliente.getClienteId());

            List<Cliente> clientes = dao.readAll();
            this.getRequest().setAttribute("clientes",clientes);
            this.setReturnPage("/listarClientes.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(RemoveClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
