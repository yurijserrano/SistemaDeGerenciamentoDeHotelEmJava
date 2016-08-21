/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.QuartoDAO;
import hotel.Data;
import hotel.Quarto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class RemoveQuartoController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Quarto quarto = new Quarto();
        quarto.setQuartoId(Integer.parseInt(request.getParameter("id")));
        QuartoDAO dao = new QuartoDAO();
        
        try {
            dao.delete(quarto.getQuartoId());

            List<Data> dados = dao.getData();
            this.getRequest().setAttribute("dados", dados);
            this.setReturnPage("/listarQuartos.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(RemoveQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
