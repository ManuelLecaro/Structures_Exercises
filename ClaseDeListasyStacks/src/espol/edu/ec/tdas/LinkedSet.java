/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.Set;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Daniel Alejandro Arroyo Yanez
 */
public class LinkedSet implements Set{
    private LinkedList<Integer> lista;
    
    public LinkedSet(){
        this.lista = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(int elemento) {
        if (elemento < this.lista.getFirst()){
            lista.addFirst(elemento);
            return true;
        }
        else if (elemento>this.lista.getLast()){
            lista.addLast(elemento);
            return true;
        }
        else{
            ListIterator<Integer> i = lista.listIterator();
            while(i.hasNext()){
                Integer num= i.next();
                if (elemento < num){
                    lista.add(elemento);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(int elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(int elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set union(Set conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set interseccion(Set conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set diferencia(Set conjunto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return lista.toString();
    }
    
}
