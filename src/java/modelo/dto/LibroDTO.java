package modelo.dto;

import java.util.Objects;

/**
 *
 * @author Estudiante
 */
public class LibroDTO {

    private long isbn;
    private String nombre;
    private String autor;
    private String editorial;
    private int anio;

    public LibroDTO() {
    }

    public LibroDTO(long isbn) {
        this.isbn = isbn;
    }

    public LibroDTO(long isbn, String nombre, String autor, String editorial, int anio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.isbn ^ (this.isbn >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.autor);
        hash = 53 * hash + Objects.hashCode(this.editorial);
        hash = 53 * hash + this.anio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroDTO other = (LibroDTO) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return Objects.equals(this.editorial, other.editorial);
    }

    @Override
    public String toString() {
        return "LibroDTO{" + "isbn=" + isbn + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", anio=" + anio + '}';
    }

}
