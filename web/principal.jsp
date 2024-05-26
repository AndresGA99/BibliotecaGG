<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession obj = request.getSession();
    if (obj != null && obj.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles.css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <title>Mi Biblioteca</title>
    </head>
    <body>
        <div class="container">
            <h1>Mi Biblioteca</h1>
            <div class="d-flex">
                <div class="col-sm-5">
                    <div class="card">
                        <form action="ControlCTO?menu=Libros" method="post">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>ISBN</label>
                                    <input type="text" name="txtISBN" class="form-control" value="${libro.getIsbn()}">
                                </div>
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNombre" class="form-control" value="${libro.getNombre()}">
                                </div>
                                <div class="form-group">
                                    <label>Autor</label>
                                    <input type="text" name="txtAutor" class="form-control" value="${libro.getAutor()}">
                                </div>
                                <div class="form-group">
                                    <label>Editorial</label>
                                    <input type="text" name="txtEditorial" class="form-control" value="${libro.getEditorial()}">
                                </div>
                                <div class="form-group">
                                    <label>Año</label>
                                    <input type="number" name="txtAnio" class="form-control" value="${libro.getAnio()}">
                                </div>
                            </div>
                            <input type="hidden" name="menu" value="Libros">     
                            <input type="submit" name="accion" value="Listar" class="btn btn-secondary">
                            <input type="submit" name="accion" value="Crear" class="btn btn-info">
                            <input type="submit" name="accion" value="Buscar" class="btn btn-warning">
                            <input type="submit" name="accion" value="Actualizar" class="btn btn-warning">
                            <input type="submit" name="accion" value="Eliminar" class="btn btn-danger">

                        </form>
                    </div>
                </div>
            </div>
        </div>
     </body>
</html>
<% } else {
    request.getRequestDispatcher("error.html").forward(request, response);
} %>
