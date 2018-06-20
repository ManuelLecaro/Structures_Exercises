/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package espol.edu.ec.tdas;

import java.util.LinkedList;

/**
 *
 * @author Daniel Alejandro Arroyo Yanez
 */
public class LinkedStack<E> {
    private LinkedList<E> lista;
    
    public LinkedStack(){
        lista = new LinkedList<>();
    }
    
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    
    public boolean push(E element){
        return lista.add(element);
    }
    
    public E pop(){
        E element = lista.getLast();
        lista.removeLast();
        return element;
    }
    
    public E peek(){
        return this.lista.getLast();
    }
    
    public static int pilaPrimero(LinkedList<Integer> pila){
        if(pila.isEmpty())
            return -1;
        LinkedStack<Integer> retorno = new LinkedStack();
        while(!pila.isEmpty()){
           
            retorno.push(pila.pop());
            
        }
        int retorno1 = retorno.pop();
        while(!retorno.isEmpty()){
            pila.push(retorno.pop());
            
        }       
        return retorno1; 
    }
    
    public static void pilaInvertida(LinkedStack<Integer> pila){
        LinkedStack<Integer> cambio = new LinkedStack();
        
        int numeritoTope = pila.pop();
        while(!pila.isEmpty()){
            cambio.push(pila.pop());
        }
        int numeritoBase = cambio.pop();
        
        pila.push(numeritoTope);
        while(!cambio.isEmpty()){
            pila.push(cambio.pop());
        }
        pila.push(numeritoBase);
    }
}
