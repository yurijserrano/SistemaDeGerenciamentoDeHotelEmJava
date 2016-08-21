
package controllers.impl;

import controllers.AbstractController;
import dao.ClienteDAO;
import dao.DAOException;
import dao.ReservaDAO;
import hotel.Cliente;
import hotel.Reserva;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public class CriarReservaController
                extends AbstractController {

    @Override
    public void execute() {
        HttpServletRequest request = getRequest();
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int quartoId = Integer.parseInt(request.getParameter("quarto"));
        LocalDate inicio = LocalDate.parse(request.getParameter("inicio"));
        LocalDate fim = LocalDate.parse(request.getParameter("fim"));
        
        ClienteDAO clienteDao = new ClienteDAO();
        Cliente cliente = null;
        
        try {
            cliente = clienteDao.read(nome);
        } catch (DAOException ex) {
            Logger.getLogger(CriarReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setEndereço(endereco);
            cliente.setEmail(email);
            cliente.setSenha(senha);
            try {
                clienteDao.create(cliente);
                cliente = clienteDao.read(nome);
            } catch (DAOException ex) {
                Logger.getLogger(CriarReservaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Reserva reserva = new Reserva();
        reserva.setClienteId(cliente.getClienteId());
        reserva.setQuartoId(quartoId);
        reserva.setInicio(inicio);
        reserva.setFim(fim);
        
        ReservaDAO dao = new ReservaDAO();
        
        try {
            int id = dao.create(reserva);
            reserva.setReservaId(id);
        } catch (DAOException ex) {
            Logger.getLogger(CriarReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getRequest().setAttribute("reserva", reserva);
        this.getRequest().setAttribute("cliente", cliente);
        this.setReturnPage("/reservaRealizada.jsp");
    }

}
