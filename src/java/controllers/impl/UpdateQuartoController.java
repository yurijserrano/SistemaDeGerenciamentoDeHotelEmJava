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
public class UpdateQuartoController extends AbstractController {

    @Override
    public void execute() {
        try {
            HttpServletRequest request = getRequest();
            Quarto quarto = new Quarto();
            QuartoDAO dao = new QuartoDAO();
            quarto.setQuartoId(Integer.parseInt(request.getParameter("id")));
            int idd2 = 0;
            try {
                idd2 = Integer.parseInt(request.getParameter("id2"));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            quarto = dao.read(quarto.getQuartoId());
            String tipo = request.getParameter("quarto");
            String teste = request.getParameter("id2");
            if (!((tipo == null || "".equals(tipo) || tipo.trim().equals("  ") || tipo.equals("")))) {
                quarto.setTipo(tipo);
            }
            if (!((teste == null || "".equals(teste) || teste.trim().equals("  ") || teste.equals("")))) {
                quarto.setHotelId(idd2);
            }
            
            
            try {
                dao.update(quarto);
                
                List<Data> dados = dao.getData();
                this.getRequest().setAttribute("dados", dados);
                this.setReturnPage("/listarQuartos.jsp");
            } catch (DAOException ex) {
                Logger.getLogger(UpdateQuartoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(UpdateQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
