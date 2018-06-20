/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4Examen2;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Consulta {
    private String consult;
    private int num_busquedas;
    
    public Consulta(String consult){
        this.consult=consult;
    }

    public String getConsult() {
        return consult;
    }

    public void setConsult(String consult) {
        this.consult = consult;
    }

    public int getNum_busquedas() {
        return num_busquedas;
    }

    public void setNum_busquedas(int num_busquedas) {
        this.num_busquedas = num_busquedas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.consult, other.consult)) {
            return false;
        }
        return true;
    }
    
    
}
