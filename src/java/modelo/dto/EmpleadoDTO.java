package modelo.dto;

import java.util.Objects;

public class EmpleadoDTO {
    
    private String dni;
    private String nombre;
    private String correo;
    private String clave;

    public EmpleadoDTO(String dni, String nombre, String correo, String clave) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    public EmpleadoDTO() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.dni);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.clave);
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
        final EmpleadoDTO other = (EmpleadoDTO) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }

    @Override
    public String toString() {
        return "EmpleadoDTO{" + "dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
    }
       
}
