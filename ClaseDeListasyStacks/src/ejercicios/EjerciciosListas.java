/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import espol.edu.ec.interfaces.List;
import espol.edu.ec.tdas.ArrayList;
import espol.edu.ec.tdas.DobleNodo;
import espol.edu.ec.tdas.DoubleLinkedList;
import espol.edu.ec.tdas.LinkedStack;
import espol.edu.ec.tdas.Nodo;
import espol.edu.ec.tdas.SimpleLinkedList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author user
 */
public class EjerciciosListas<E> {
    
    //EJERCICIO 1
    
    public static List<Ciudadano> obtenerHijos(ArrayList<Ciudadano> registro, Ciudadano padre, Ciudadano madre){
        SimpleLinkedList<Ciudadano> retorno = new SimpleLinkedList();
        for(int i = 0; i < registro.size();i++){
            if(registro.get(i).getMadre().equals(madre)&&registro.get(i).getPadre().equals(padre))
                retorno.addLast(registro.get(i));
        }
        return retorno;
    }
    
    //EJERCICIO 2
    public static List removeLastOcurrence(SimpleLinkedList<Ciudadano> repetidos, Ciudadano c){
        List retorno = new SimpleLinkedList();
        Nodo<Ciudadano> eliminar = repetidos.getFirstNodo();
        Nodo<Ciudadano> padre_eliminar = eliminar;
        LinkedList<Ciudadano> retorno1 = new LinkedList();
        ListIterator it = retorno1.listIterator();
        Nodo<Ciudadano> nodin = repetidos.getFirstNodo();
        while(nodin.getNext()!=null){
            if(nodin.getData().equals(c))
                eliminar = nodin;
            padre_eliminar = nodin;
            nodin=nodin.getNext();
        }
        padre_eliminar.setNext(nodin.getNext());
        nodin.setNext(null);
        
        return retorno;
    }
    
    //EJERCICIO3
    public static int maxStack(LinkedStack<Integer> linked){
        int mayor = linked.pop();
        LinkedStack<Integer> temp = new LinkedStack();
        temp.push(mayor);
        while(!linked.isEmpty()){
            int primero = linked.pop();
            mayor = (mayor>primero)? mayor:primero;
            temp.push(primero);            
        }
        while(!temp.isEmpty()){
            linked.push(temp.pop());
        }
        return mayor;
        
    }
    
    //EJERCICIO 4
    
    public static List sumaTotal(List<Integer> a, List<Integer> b){
        List retorno = new SimpleLinkedList();
        int sumador =0;
        for(int i=0; i<a.size();i++){
            for(int j=0;j<b.size();j++){
                sumador+=(a.get(i)*b.get(i));
            }
            retorno.addLast(sumador);
        }
        return retorno;
    }
    
    public static List sumaTotalAlternative(List<Integer> a, List<Integer> b){
        List retorno = new SimpleLinkedList();
        int sumador =0;
        for(int j=0;j<b.size();j++){
            sumador+=b.get(j);
        }
        for(int i=0; i<a.size();i++){
            
            retorno.addLast(sumador*a.get(i));
        }
        return retorno;
    }
    
    //EJERCICIO 6
    
    public static List mergeLinked(SimpleLinkedList<Integer> primera, SimpleLinkedList<Integer> segunda){
        List retorno = new SimpleLinkedList();
        if(primera.isEmpty()||segunda.isEmpty())
            return retorno = (segunda.size()<=primera.size())? primera:segunda;
        if(primera.isEmpty()&&segunda.isEmpty())
            return retorno;
        Nodo<Integer> primeroB = primera.getFirstNodo();
        Nodo<Integer> primeroQ = segunda.getFirstNodo();
        
        while(primeroB.getNext()!=null||primeroQ.getNext()!=null){
            if(primeroB.getData()>primeroQ.getData()){
                retorno.addLast(primeroB.getData());
                primeroB = primeroB.getNext();
            }
            if(primeroB.getData()<primeroQ.getData()){
                retorno.addLast(primeroQ.getData());
                primeroQ = primeroQ.getNext();
            }
            else if(Objects.equals(primeroB.getData(), primeroQ.getData())){
                retorno.addLast(primeroQ.getData());
                primeroQ = primeroQ.getNext();
                primeroB = primeroB.getNext();
            }                
        }
        if(primeroQ instanceof Nodo){
            while(primeroQ.getNext()!=null)
                retorno.addLast(primeroQ.getData());
        } else if(primeroB instanceof Nodo) {
           while(primeroB.getNext()!=null)
                retorno.addLast(primeroB.getData());
        }
              
        return retorno;
    }
    
    
    /*
    Collections.sort(lista, new Comparator<TuObjeto>() {
   public int compare(TuObjeto obj1, TuObjeto obj2) {
      return obj1.getNombre().compareTo(obj2.getNombre());
   }
    */
    
    //EJERCICIO 7
    
    public static void invertirDoubleLinked(DoubleLinkedList<Integer> link){
        DoubleLinkedList<Integer> retorno = new DoubleLinkedList();
        DobleNodo<Integer> p = link.getFirstNodo();
        DobleNodo<Integer> q = link.getLastNodo();
        DobleNodo<Integer> tmp;
        retorno.addLast(p.getData());
        do{
           tmp = p.getPrevious();
           p.setPrevious(p.getNext());
           p.setNext(tmp);
           tmp = q.getPrevious();
           q.setPrevious(p.getNext());
           q.setNext(tmp);
           p = p.getPrevious();
           q = q.getNext();
        }while(p.getNext()!=q && p!=q);
               
    }
    
    //EJERCICIO 8
    
    public static Stack<Integer> combinar(Stack<Integer> Pila1, Stack<Integer> Pila2){
        
        Stack<Integer> retorno = new Stack();
        while(!Pila1.isEmpty()&&!Pila2.isEmpty()){
            if(Integer.compare(Pila1.peek(), Pila2.peek())>0){
                retorno.push(Pila2.pop());
                
            }else if(Integer.compare(Pila1.peek(), Pila2.peek())>0){
                retorno.push(Pila1.pop());
            }
            else{
                retorno.push(Pila1.pop());
                Pila2.pop();
            }
        }
        if(!Pila1.isEmpty()){
            while(!Pila1.isEmpty()){
                retorno.push(Pila1.pop());
            }
        }else if(!Pila2.isEmpty()){
            while(!Pila2.isEmpty()){
                retorno.push(Pila2.pop());
            }
        }
        return retorno;
    }
    
    
    
}
