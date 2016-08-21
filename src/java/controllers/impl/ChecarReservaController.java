package controllers.impl;

import controllers.AbstractController;
import dao.ClienteDAO;
import dao.DAOException;
import dao.ReservaDAO;
import hotel.Cliente;
import hotel.Reserva;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Yuri Serrano
 */
public class ChecarReservaController
        extends AbstractController {

    @Override
    public void execute() {
        HttpServletRequest request = getRequest();
        long reservaId = Long.parseLong(request.getParameter("id"));

        ReservaDAO reservaDao = new ReservaDAO();
        ClienteDAO clienteDao = new ClienteDAO();

        Reserva reserva = null;
        Cliente cliente = null;

        try {
            reserva = reservaDao.read(reservaId);
            cliente = clienteDao.read(reserva.getClienteId());
        } catch (DAOException ex) {
            Logger.getLogger(ChecarReservaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.getRequest().setAttribute("reserva", reserva);
        this.getRequest().setAttribute("cliente", cliente);
        this.setReturnPage("/confirmaReserva.jsp");

    }

}
