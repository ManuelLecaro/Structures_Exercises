/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.Queue;

/**Esta es una implementacion de una cola diamica con una DoubleLinkedList
 *
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E>{
    private DoubleLinkedList<E> lista;
    
    public LinkedQueue(){
        this.lista= new DoubleLinkedList();
    }
    
    public int size(){
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public boolean offer(E data) {
        if (data==null)
            return false;
        lista.addLast(data);
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty())
            return null;
        E temp=lista.getFirst();
        lista.removeFirst();
        return temp;
    }
    
    @Override
    public String toString(){
        return this.lista.toString();
    }

}
