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
public class UpdateFuncionarioController extends AbstractController {

    @Override
    public void execute() {
        try {
            HttpServletRequest request = getRequest();
            Funcionario funcionario = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();
            funcionario.setFuncionarioId(Integer.parseInt(request.getParameter("id")));
            funcionario = dao.read(funcionario.getFuncionarioId());
            String nome = request.getParameter("nome");
            String cargo = request.getParameter("cargo");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            int nivell = 0;

    try{
       nivell = Integer.parseInt(request.getParameter("nivel"));
    }catch(NumberFormatException ex){ // handle your exception
       ex.printStackTrace();
    }


           
            String teste = request.getParameter("nivel");
            
            if (!((nome == null || "".equals(nome) || nome.trim().equals("  ") || nome.equals("")))) {
                funcionario.setNome(nome);
            }
            if (!((cargo == null || "".equals(cargo) || cargo.trim().equals("  ") || cargo.equals("")))) {
                funcionario.setCargo(cargo);
            }
            if (!((endereco == null || "".equals(endereco) || endereco.trim().equals("  ") || endereco.equals("")))) {
                funcionario.setEndereco(endereco);
            }
            if (!((email == null || "".equals(email) || email.trim().equals("  ") || email.equals("")))) {
                funcionario.setEmail(email);
            }
            if (!((senha == null || "".equals(senha) || senha.trim().equals("  ") || senha.equals("")))) {
                funcionario.setSenha(senha);
            }
            
            if (!((teste == null || "".equals(teste) || teste.trim().equals("  ") || teste.equals("")))) {
                funcionario.setNivel_acesso(nivell);
            }
            
            
            
            
            
            
            try {
                dao.update(funcionario);
                
                List<Funcionario> funcionarios = dao.readAll();
                this.getRequest().setAttribute("funcionarios", funcionarios);
                this.setReturnPage("/listarFuncionarios.jsp");
            } catch (DAOException ex) {
                Logger.getLogger(UpdateFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DAOException ex) {
            Logger.getLogger(UpdateFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
