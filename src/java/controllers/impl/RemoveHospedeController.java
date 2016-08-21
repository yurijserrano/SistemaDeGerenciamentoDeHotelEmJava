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
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class RemoveHospedeController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Hospede hospede = new Hospede();
        hospede.setHospedeId(Integer.parseInt(request.getParameter("id")));
        HospedeDAO dao = new HospedeDAO();
        
        try {
            dao.delete(hospede.getHospedeId());

            List<Hospede> hospedes = dao.readAll();
            this.getRequest().setAttribute("hospedes",hospedes);
            this.setReturnPage("/listarHospedes.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(RemoveHospedeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
