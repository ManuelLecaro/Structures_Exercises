/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5Examen2;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class ProfesoresCompleto extends Profesores{
    private LinkedList<Estudiantes> ac;
    
    public ProfesoresCompleto(String nombre){
        super(nombre);
    }

    public LinkedList<Estudiantes> getAc() {
        return ac;
    }

    public void setAc(LinkedList<Estudiantes> ac) {
        this.ac = ac;
    }
    
    
    
}
