/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.tdas;

/**El nodo doble contiene una data, una referencia al nodo siguiente y una al 
 * nodo anterior.
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E> el tipo de dato que almacena el nodo.
 */
public class DobleNodo<E> {
    private E data;
    private DobleNodo<E> previous, next;
    
    public DobleNodo(E data){
        this.data=data;
        this.previous=this.next=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DobleNodo<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DobleNodo<E> previous) {
        this.previous = previous;
    }

    public DobleNodo<E> getNext() {
        return next;
    }

    public void setNext(DobleNodo<E> next) {
        this.next = next;
    }
    
    
}
