/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questao1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "Questao1", urlPatterns = {"/Questao1"})
public class Questao1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String matriculo = request.getParameter("matricula");
            String nome = request.getParameter("nome");
            String sexo = request.getParameter("sexo");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String data = request.getParameter("data");
            String mae = request.getParameter("nomeMae");
            String pai = request.getParameter("nomePai");
            String endereco = request.getParameter("endereco");
            String tele = request.getParameter("tele");
            String civil = request.getParameter("estado");
            String[] cursos = request.getParameterValues("curso");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Questao1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabela de Cadastro</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Matricula:</td>");
            out.println("<td>"+matriculo+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nome:</td>");
            out.println("<td>"+nome+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Sexo:</td>");
            out.println("<td>"+sexo+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Estado Civil</td>");
            out.println("<td>"+civil+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Email</td>");
            out.println("<td>"+email+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>CPF</td>");
            out.println("<td>"+cpf+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>RG</td>");
            out.println("<td>"+rg+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Data de Nascimento:</td>");
            out.println("<td>"+data+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nome da Mãe</td>");
            out.println("<td>"+mae+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nome do Pai</td>");
            out.println("<td>"+pai+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Endereço</td>");
            out.println("<td>"+endereco+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Telefone</td>");
            out.println("<td>"+tele+"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Cursos</td>");
            out.println("<td>");
            out.println("<ul>");
            for(int i = 0; i < cursos.length; i++){
                out.println("<li>"+cursos[i]+"</li>");
            }            
            out.println("</ul>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
