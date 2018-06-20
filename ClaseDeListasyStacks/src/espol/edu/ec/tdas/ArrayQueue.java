/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.Queue;

/**
 *
 * @author Administrador
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E>{

    private E[] array;
    private int inicio, fin, MAX = 100;

    public ArrayQueue() {
        array = (E[]) new Object[MAX];
        this.inicio = 0;
        this.fin = MAX;
    }

    public boolean isEmpty() {
        return (this.inicio == this.fin);
    }

    public boolean offer(E data) {
        if (data == null) {
            return false;
        }
        array[fin] = data;
        fin++;
        return true;
    }

    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        E temp = array[fin];
        array[fin] = null;
        inicio++;
        return temp;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < fin; i++) {
            if (i == fin - 1) {
                s += array[i] + "]";
            } else {
                s += array[i] + ", ";
            }
        }
        return s;
    }

}
