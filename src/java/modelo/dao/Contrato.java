/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo.dao;

    import java.util.List;

public interface Contrato <Cualquiercosa> {
  
    public boolean create(Cualquiercosa nuevo);
    public boolean delete(Object item);
    public boolean update(Cualquiercosa filter);
    public Cualquiercosa read(Object filter);
    public List<Cualquiercosa> readALL();
    
}


