/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers.impl;

import controllers.AbstractController;
import dao.DAOException;
import dao.FuncionarioDAO;
import hotel.Funcionario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Serrano
 */
public class RemoveFuncionarioController extends AbstractController
{

    @Override
    public void execute() 
    {
        HttpServletRequest request = getRequest();
        Funcionario funcionario = new Funcionario();
        funcionario.setFuncionarioId(Integer.parseInt(request.getParameter("id")));
        FuncionarioDAO dao = new FuncionarioDAO();
        
        try {
            dao.delete(funcionario.getFuncionarioId());

            List<Funcionario> funcionarios = dao.readAll();
            this.getRequest().setAttribute("funcionarios",funcionarios);
            this.setReturnPage("/listarFuncionarios.jsp");
        } catch (DAOException ex) {
            Logger.getLogger(RemoveFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
