/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import modelo.dto.EmpleadoDTO;

/**
 *
 * @author Estudiante
 */
public class EmpleadoDAO {

public EmpleadoDTO validasesion(EmpleadoDTO item) {
    
        EmpleadoDTO empleadoEjemplo = new EmpleadoDTO("15", "sandra", "sandra@gmail.com", "1234");
        if (item.getCorreo().equals(empleadoEjemplo.getCorreo()) && item.getClave().equals(empleadoEjemplo.getClave())) { 
            return empleadoEjemplo;
            
        } else { 
            return null;
            
        }
    }

}
