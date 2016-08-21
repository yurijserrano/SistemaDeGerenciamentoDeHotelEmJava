/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.EstadiaDAO;
import hotel.Data;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serrano
 */
public class ListarEstadiasController extends AbstractController {

    @Override
    public void execute() {
        EstadiaDAO dao = new EstadiaDAO();
        
        try {
            List<Data> dados = dao.getData();
            this.getRequest().setAttribute("dados", dados);
            this.setReturnPage("/listarEstadias.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(ListarEstadiasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
