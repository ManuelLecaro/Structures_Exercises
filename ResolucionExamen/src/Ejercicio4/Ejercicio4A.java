/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author user
 */
    public class Ejercicio4A {
    /*Se le solicita implementar dentro de la ListaSimplementeEnlazada el método splitReverse ​que
recibe un NodoLista p​ como parámetro y modifica la lista de tal forma que los nodos después de p
​ esten ubicados ahora al comienzo de la lista. Este método debe tomar como tiempo O(1).
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    /**
     * Agrego como parametro a la lista, porque se supone que este metodo esta en la clase
     * SimpleLinkedList y agregandolo en la firma del metodo puedo acceder al primer
     * y ultimo nodo de la linkedList, hice las variables de instancia publicas para
     * poder acceder a ellas como si estuviera en su misma clase
     * @param p
     * @param lis 
     */
    private void splitReverse(Nodo p, SimpleLinkedList lis) {
    
        if(null!=p&&p.getNext()!=null) {
            Nodo q = p.getNext();
            lis.last.setNext(lis.first);
            lis.first=q;
        }
        
    }
}