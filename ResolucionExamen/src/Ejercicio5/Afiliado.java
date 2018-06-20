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
public class Afiliado {
    private String cedula;
    private String nombre;
    private LinkedList<Dolencias> dolor;
    
    public Afiliado(String cedula, String nombre, LinkedList<Dolencias> dolor){
        this.cedula=cedula;
        this.nombre=nombre;
        this.dolor=dolor;
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

    public LinkedList<Dolencias> getDolor() {
        return dolor;
    }

    public void setDolor(LinkedList<Dolencias> dolor) {
        this.dolor = dolor;
    }
    
}
