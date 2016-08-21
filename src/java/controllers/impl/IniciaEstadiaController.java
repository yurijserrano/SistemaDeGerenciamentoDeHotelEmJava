/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.EstadiaDAO;
import dao.HospedeDAO;
import hotel.Estadia;
import hotel.Hospede;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class IniciaEstadiaController extends AbstractController {

    @Override
    public void execute() {
        try {
            HttpServletRequest request = getRequest();
            
            Hospede hospede = new Hospede();
            Estadia estadia =new Estadia();
            
            String nome = request.getParameter("clientenome");
            
            hospede.setClienteId(Integer.parseInt(request.getParameter("clienteid")));
            hospede.setNome(request.getParameter("clientenome"));
            hospede.setEndereco(request.getParameter("clienteendereco"));
            hospede.setEmail(request.getParameter("clienteendereco"));
            hospede.setQuartoId(Integer.parseInt(request.getParameter("reservaquarto")));
            
            HospedeDAO hospededao = new HospedeDAO();
            
            hospededao.create(hospede);
            
            hospede = hospededao.read(nome);
            
            
            estadia.setHospedeId(hospede.getHospedeId());
            estadia.setQuartoId(Integer.parseInt(request.getParameter("reservaquarto")));
            estadia.setInicio(LocalDate.parse(request.getParameter("reservainicio")));
            estadia.setFim(LocalDate.parse(request.getParameter("reservafim")));
            
            
            EstadiaDAO estadiadao = new EstadiaDAO();
            
            estadiadao.create(estadia);
            
            this.setReturnPage("/estadiaRealizada.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(IniciaEstadiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
