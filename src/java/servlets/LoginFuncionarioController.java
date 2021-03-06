/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.DAOException;
import dao.FuncionarioDAO;
import hotel.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Serrano
 */
public class LoginFuncionarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Funcionario func = new Funcionario();
        try {
            func = new FuncionarioDAO().readEmail(email);
        } catch (DAOException ex) {
            Logger.getLogger(LoginFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("link.jsp").include(request, response); 
        
        if ((func.getEmail().equals(email)) && (func.getSenha().equals(senha)) && (func.getNome() != null) && func.getNivel_acesso() == 1) {
            
             
            HttpSession session = request.getSession();
            String heading;
            Integer accesCount = (Integer) session.getAttribute("accesCount");
            session.setAttribute("nome",func.getNome());
            session.setAttribute("cargo",func.getCargo());
            if (accesCount == null) {
                accesCount = new Integer(0);
                heading = "Seja Bem-vindo " + func.getNome()+"\n <br/>CARGO: "+func.getCargo();
            } else {
                heading = "Bem-vindo Novamente " + func.getNome()+"\n<br/>CARGO: "+func.getCargo();
                accesCount =new Integer(accesCount.intValue() +1);
            }

            session.setAttribute("accesCount", accesCount);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                    + "Transitional//EN\">\n"
                    + "<HTML>\n"
                    + "<HEAD><TITLE>" + "Dados do Usuario" + "</TITLE></HEAD>\n"
                    + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                    + "<CENTER>\n"
                    + "<H1>" + heading + "</H1>\n"
                    + "<H2>Informacoes da Sessao:</H2>\n"
                    + "<TABLE BORDER=1>\n"
                    + "<TR BGCOLOR=\"#FFAD00\">\n"
                    + " <TH>Tipo da Informacao<TH>Dados\n"
                    + "<TR>\n"
                    + " <TD>ID\n"
                    + " <TD>" + session.getId() + "\n"
                    + "<TR>\n"
                    + " <TD>Tempo da Criacao da Sessao\n"
                    + " <TD>"
                    + new Date(session.getCreationTime()) + "\n"
                    + "<TR>\n"
                    + " <TD>Ultimo Acesso\n"
                    + " <TD>"
                    + new Date(session.getLastAccessedTime()) + "\n"
                    + "<TR>\n"
                    + " <TD>Numero de Acessos Anteriores\n"
                    + " <TD>" + accesCount + "\n"
                    + "</TABLE>\n"
                    + "</CENTER></BODY></HTML>");
            
            request.getRequestDispatcher("/logadoAdministrador.jsp").include(request, response);
            
            
        } 
        else if ((func.getEmail().equals(email) && (func.getSenha().equals(senha)) && (func.getNome() != null)) && func.getNivel_acesso() == 2)
        {
            HttpSession session = request.getSession();
            String heading;
            session.setAttribute("nome",func.getNome());
            session.setAttribute("cargo",func.getCargo());
            Integer accesCount = (Integer) session.getAttribute("accesCount");
            if (accesCount == null) {
                accesCount = new Integer(0);
                heading = "Seja Bem-vindo " + func.getNome()+"\n<br/> CARGO: "+func.getCargo();
            } else {
                heading = "Bem-vindo Novamente " + func.getNome()+"\n<br/>CARGO: "+func.getCargo();
                 accesCount =new Integer(accesCount.intValue() +1);
            }

            session.setAttribute("accesCount", accesCount);
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 "
                    + "Transitional//EN\">\n"
                    + "<HTML>\n"
                    + "<HEAD><TITLE>" + "Dados do Usuario" + "</TITLE></HEAD>\n"
                    + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                    + "<CENTER>\n"
                    + "<H1>" + heading + "</H1>\n"
                    + "<H2>Informacoes da Sessao:</H2>\n"
                    + "<TABLE BORDER=1>\n"
                    + "<TR BGCOLOR=\"#FFAD00\">\n"
                    + " <TH>Tipo da Informacao<TH>Dados\n"
                    + "<TR>\n"
                    + " <TD>ID\n"
                    + " <TD>" + session.getId() + "\n"
                    + "<TR>\n"
                    + " <TD>Tempo da Criacao da Sessao\n"
                    + " <TD>"
                    + new Date(session.getCreationTime()) + "\n"
                    + "<TR>\n"
                    + " <TD>Ultimo Acesso\n"
                    + " <TD>"
                    + new Date(session.getLastAccessedTime()) + "\n"
                    + "<TR>\n"
                    + " <TD>Numero de Acessos Anteriores\n"
                    + " <TD>" + accesCount + "\n"
                    + "</TABLE>\n"
                    + "</CENTER></BODY></HTML>");
            
            request.getRequestDispatcher("/logadoGerente.jsp").include(request, response);
        }
        else
        {
            request.getRequestDispatcher("/errofunc.jsp").forward(request, response);
                
        }

    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
