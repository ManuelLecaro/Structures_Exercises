/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.interfaces;

/**
 *
 * @author Administrador
 */
public interface Set {
    boolean isEmpty();
    boolean add(int elemento);
    boolean remove(int elemento);
    boolean contains(int elemento);
    Set union(Set conjunto);
    Set interseccion(Set conjunto);
    Set diferencia(Set conjunto);
    
}
