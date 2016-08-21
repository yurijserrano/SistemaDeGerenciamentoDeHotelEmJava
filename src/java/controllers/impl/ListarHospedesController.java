/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.HospedeDAO;
import hotel.Hospede;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serrano
 */
public class ListarHospedesController extends AbstractController
{

    @Override
    public void execute() {
        HospedeDAO dao = new HospedeDAO();
        
        try {
            List<Hospede> hospedes = dao.readAll();
            this.getRequest().setAttribute("hospedes", hospedes);
            this.setReturnPage("/listarHospedes.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(ListarHospedesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
