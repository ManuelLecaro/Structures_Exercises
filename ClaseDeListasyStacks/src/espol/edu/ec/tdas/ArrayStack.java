/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package espol.edu.ec.tdas;

/**
 *
 * @author Daniel Alejandro Arroyo Yanez
 */
public class ArrayStack<E> {
    private E[] arreglo;
    private int ctrl, MAX;
    
    public ArrayStack(){
        this.MAX = 100;
        arreglo = (E[]) new Object[MAX];
        this.ctrl = 0;
    }
    
    public boolean isEmpty(){
        return this.ctrl == 0;
    }
    
    public boolean push(E element){
        if (element == null)
            return false;
        else if (ctrl >= MAX)
            copy();
        this.arreglo[ctrl] = element;
        ctrl++;
        return true;
    }
    
    public E pop(){
        if (this.isEmpty())
            return null;
        E temp = this.arreglo[ctrl-1];
        this.arreglo[ctrl-1] = null;
        ctrl--;
        return temp;
    }
    
    private void copy(){
        MAX*=2;
        E[] arregloNew= (E[]) new Object[MAX];
        for (int i=0; i<ctrl;i++)
            arregloNew[i]=this.arreglo[i];
        this.arreglo=arregloNew;
    }
}
