/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.dao.EmpleadoDAO;
import modelo.dto.EmpleadoDTO;

/**
 *
 * @author USER
 */
@WebServlet(name = "ValidaCTO", urlPatterns = {"/ValidaCTO"})
public class ValidaCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String accion = request.getParameter("accion");

        if (accion != null && accion.equals("Ingresar")) {
            String correo = request.getParameter("email");
            String clave = request.getParameter("clave");

            if (correo != null && !correo.isEmpty() && clave != null && !clave.isEmpty()) {
                EmpleadoDTO emp = new EmpleadoDTO();
                emp.setCorreo(correo);
                emp.setClave(clave);
                EmpleadoDAO dao = new EmpleadoDAO();
                EmpleadoDTO empleadoValidado = dao.validasesion(emp);

                if (empleadoValidado != null) {
                    HttpSession mySesion = request.getSession(true);
                    mySesion.setAttribute("usuario", empleadoValidado);
                    response.sendRedirect("principal.jsp");
                } else {
                    System.out.println("Usuario o contraseña inválidos");
                    response.sendRedirect("error.html");
                }
            } else {
                System.out.println("Campos de correo y/o contraseña vacíos");
                response.sendRedirect("error.html");
            }
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
