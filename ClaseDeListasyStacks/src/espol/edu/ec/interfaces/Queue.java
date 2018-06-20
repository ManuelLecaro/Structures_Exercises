/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.interfaces;

/**
 *
 * @author Danie
 */
public interface Queue<E> {
    boolean isEmpty();
    boolean offer(E data);
    E poll();
}
