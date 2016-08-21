package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import hotel.Hotel;
import dao.HotelDAO;

public final class homeRede_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt-BR\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <title>Hotel do Picci</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"container\" align=\"center\">\n");
      out.write("            <h1>Hotel do Picci</h1>\n");
      out.write("            <img src=\"http://www.jm1.com.br/wp-content/uploads/2012/09/DSC0138.jpg\" alt=\"Formule Two\" height=\"200\" width=\"400\">\n");
      out.write("            <img src=\"https://www.sbtur.com/portal/img/hoteis/1635001.jpg\" alt=\"Max Hotel\" height=\"200\" width=\"400\">\n");
      out.write("            <img src=\"http://t0.gstatic.com/images?q=tbn:ANd9GcSDU72ekjo-_7JR3QZN-flK1RbFSFJzxCpESKOn2i1u7XCc4Ad-\" alt=\"Novo Hotel\" height=\"200\" width=\"400\">\n");
      out.write("            <div>\n");
      out.write("                <div id=\"formulario\">\n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        Quarto <select id=\"quarto\" name=\"tipo\">\n");
      out.write("                            <option>padrao</option>\n");
      out.write("                            <option>executivo</option>\n");
      out.write("                            <option>luxo</option>\n");
      out.write("                        </select><br><br>\n");
      out.write("                        Hotel <select id=\"hotel\" \n");
      out.write("                                      name=\"hotel\">\n");
      out.write("                            ");

                                HotelDAO hotel = new HotelDAO();
                                List<Hotel> hoteis =  hoteis = hotel.readAll();
                                
                                
                                for(Hotel hot:hoteis)
                                {   
                                    out.println("<option value='"+hot.getHotelId()+"'>"+hot.getNome()+"</option>");
                                    
                                }
                            
                          
                                    
      out.write("\n");
      out.write("                        </select><br><br>\n");
      out.write("                        <fieldset class=\"date\"> \n");
      out.write("                            <legend>Data Inicial </legend> \n");
      out.write("                            <input type=\"date\" name=\"inicio\">         \n");
      out.write("                        </fieldset> \n");
      out.write("                        <fieldset class=\"date\"> \n");
      out.write("                            <legend>Data Final </legend> \n");
      out.write("                            <input type=\"date\" name=\"fim\"> \n");
      out.write("                        </fieldset>\n");
      out.write("                        \n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"FazReserva\"/>\n");
      out.write("                        <input class=\"botao right\" type=\"submit\" value =\"Pesquisar\">\n");
      out.write("                        \n");
      out.write("                        </form>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div id=\"texto\" align=\"justify\">\n");
      out.write("                    <h3>Conheça Nossa Rede</h3>\n");
      out.write("                    <p>&nbsp;Por todo o mundo, nosso padrão garante a seus hóspedes uma oferta única: quartos modernos, com wi-fi grátis e a prova de som, uma cama inovadora e superconfortável, café da manhã das 4h às 12h, e uma grande variedade de conceitos de restaurantes.\n");
      out.write("                        Aconchegante e eficiente, é a única rede econômica europeia que oferece os principais serviços 24 horas por dia, nos 7 dias da semana, por exemplo: recepção e refeições lights servidas nos bares. \n");
      out.write("                        Devido a sua grande exigência de qualidade, a nossa rede tem a certificação ISO 9001, que é reflexo do contrato 15 minutos. Pioneiro no compromisso com o meio ambiente, nossa rede também obteve a certificação ISO 14001.</p>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"botoes\">\n");
      out.write("                    <form method=\"POST\" action=\"checarReserva.jsp\"> \n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Ocupar Reserva\" name=\"Ocupar\"/>\n");
      out.write("                    </form>\n");
      out.write("                   \n");
      out.write("                    <form method=\"POST\" action=\"cadastrarse.jsp\">\n");
      out.write("                      <input class=\"botao left\" type=\"submit\" value=\"Cadastre-se Aqui\"/>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarReservas\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Reservas\"/>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarClientes\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Clientes\"/>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarEstadias\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Estadias\"/>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarHospedes\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Hospedes\"/>\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarHoteis\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Hoteis\"/>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <form method=\"POST\" action=\"FrontController\">\n");
      out.write("                        <input type=\"hidden\" name=\"control\" value=\"ListarQuartos\">\n");
      out.write("                        <input class=\"botao left\" type=\"submit\" value=\"Listar Quartos\"/>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
