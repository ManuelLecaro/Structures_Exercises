/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Medico {
    private String cedula;
    private String nombre;
    private LinkedList<Afiliado> hist_fili;
    
    public Medico(String cedula, String nombre){
        this.cedula = cedula;
        this.nombre = nombre;
                
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Afiliado> getHist_fili() {
        return hist_fili;
    }

    public void setHist_fili(LinkedList<Afiliado> hist_fili) {
        this.hist_fili = hist_fili;
    }
    
    
}
