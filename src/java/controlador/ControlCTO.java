package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.LibroDAO;
import modelo.dto.LibroDTO;

/**
 *
 * @author USER
 */
@WebServlet(name = "ControlCTO", urlPatterns = {"/ControlCTO"})
public class ControlCTO extends HttpServlet {

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
        LibroDTO librodto = new LibroDTO();
        LibroDAO librodao = new LibroDAO();
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Libros")) {
            switch (accion) {

                case "Crear":
                    long isbn = Long.parseLong(request.getParameter("txtISBN"));
                    String nombre = request.getParameter("txtNombre");
                    String autor = request.getParameter("txtAutor");
                    String editorial = request.getParameter("txtEditorial");
                    int anio = Integer.parseInt(request.getParameter("txtAnio"));
                    librodto.setIsbn(isbn);
                    librodto.setNombre(nombre);
                    librodto.setAutor(autor);
                    librodto.setEditorial(editorial);
                    librodto.setAnio(anio);        
                    if (librodao.create(librodto)) {
                        System.out.println("Libro creado: " + librodto);
                    }
                    break;

                case "Actualizar":
                    isbn = Long.parseLong(request.getParameter("txtISBN"));
                    nombre = request.getParameter("txtNombre");
                    autor = request.getParameter("txtAutor");
                    editorial = request.getParameter("txtEditorial");
                    anio = Integer.parseInt(request.getParameter("txtAnio"));
                    librodto.setIsbn(isbn);
                    librodto.setNombre(nombre);
                    librodto.setAutor(autor);
                    librodto.setEditorial(editorial);
                    librodto.setAnio(anio);   
                    if (librodao.update(librodto)) {
                        System.out.println("Libro actualizado: " + librodto);
                    }
                    break;

                case "Eliminar":
                    isbn = Long.parseLong(request.getParameter("txtISBN"));
                    if (librodao.delete(isbn)) {
                        System.out.println("Libro eliminado: " + isbn);
                    }
                    break;
                    
                case "Buscar":
                    isbn = Long.parseLong(request.getParameter("txtISBN"));
                    librodto = librodao.read(isbn);
                    if (librodto != null) {
                        List<LibroDTO> lista = new ArrayList<LibroDTO>();
                        lista.add(librodto);
                        request.setAttribute("lista", lista);
                        request.getRequestDispatcher("libro_vta.jsp").forward(request, response);

                    }
                    break;
    
                case "Listar":
                    List<LibroDTO> lista = librodao.readALL();
                    System.out.println("Libros listados: " + lista.size());
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("libro_vta.jsp").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("error.html").forward(request, response);
                    break;
            }
           request.getRequestDispatcher("ControlCTO?menu=Libros&accion=Listar").forward(request, response);
        } else {
            request.getRequestDispatcher("error.html").forward(request, response);
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
