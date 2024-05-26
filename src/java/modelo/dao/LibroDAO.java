package modelo.dao;

import conexion.Mysql_BD;
import modelo.dto.LibroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO implements Contrato<LibroDTO> {

    private static final String SQL_INSERT = "INSERT INTO tb_libro (isbn, nombre, autor, editorial, anio) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM tb_libro WHERE isbn = ?";
    private static final String SQL_UPDATE = "UPDATE tb_libro SET nombre = ?, autor = ?, editorial = ?, anio = ? WHERE isbn = ?";
    private static final String SQL_READ = "SELECT * FROM tb_libro WHERE isbn = ?";
    private static final String SQL_READALL = "SELECT * FROM tb_libro";
    private static final Mysql_BD instance = Mysql_BD.getInstance();
    private static final Connection connection = instance.getConnection();

    @Override
    public boolean create(LibroDTO nuevo) {
        try{
            
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setLong(1, nuevo.getIsbn());
            ps.setString(2, nuevo.getNombre());
            ps.setString(3, nuevo.getAutor());
            ps.setString(4, nuevo.getEditorial());
            ps.setInt(5, nuevo.getAnio());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar libro: " + e.getMessage());
            return false;
        } 
        return true;
    }
    

    @Override
    public boolean delete(Object item) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setLong(1, (Long) item);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar libro: " + e.getMessage());
            return false;
        }
        return true;
    }
    

    @Override
    public boolean update(LibroDTO item) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_UPDATE);
            ps.setString(1, item.getNombre());
            ps.setString(2, item.getAutor());
            ps.setString(3, item.getEditorial());
            ps.setInt(4, item.getAnio());
            ps.setLong(5, item.getIsbn());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar libro: " + e.getMessage());
            return false;
        }
        return true;
    }
    

    @Override
    public LibroDTO read(Object filter) {
        LibroDTO libro = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_READ);
            ps.setLong(1, (Long) filter);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    libro = new LibroDTO(rs.getLong("isbn"),
                            rs.getString("nombre"),
                            rs.getString("autor"),
                            rs.getString("editorial"),
                            rs.getInt("anio"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar libro: " + e.getMessage());
        }
        return libro;
    }

    @Override
    public List<LibroDTO> readALL() {
        List<LibroDTO> lista = new ArrayList<>();
        try{
             PreparedStatement ps = connection.prepareStatement(SQL_READALL);
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LibroDTO libro = new LibroDTO(rs.getLong("isbn"),
                        rs.getString("nombre"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getInt("anio"));
                lista.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar toda la tabla de libros: " + e.getMessage());
        }
        return lista;
    }
}
