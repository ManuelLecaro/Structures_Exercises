/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.Objects;

/**
 *
 * @author user
 */
public class Ciudadano {
    private String nombre,identificacion,apellido;
    private Ciudadano padre,madre;
    
    public Ciudadano(String nombre, String id, String ape){
        this.nombre = nombre;
        this.identificacion=id;
        this.apellido=ape;
    }
    public Ciudadano(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Ciudadano getPadre() {
        return padre;
    }

    public void setPadre(Ciudadano padre) {
        this.padre = padre;
    }

    public Ciudadano getMadre() {
        return madre;
    }

    public void setMadre(Ciudadano madre) {
        this.madre = madre;
    }

    @Override
    public String toString() {
        return "Ciudadano{" + "nombre=" + nombre + ", identificacion=" + identificacion + ", apellido=" + apellido + ", padre=" + padre + ", madre=" + madre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Ciudadano other = (Ciudadano) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.identificacion, other.identificacion)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        return true;
    }
    
    
    
}
