/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5Examen2;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ProfesoresParcial extends Profesores{
    
    private ArrayList<Estudiantes> ac;
    
    public ProfesoresParcial(String nombre) {
        super(nombre);
    }

    public ArrayList<Estudiantes> getAc() {
        return ac;
    }

    public void setAc(ArrayList<Estudiantes> ac) {
        this.ac = ac;
    }
    
}
