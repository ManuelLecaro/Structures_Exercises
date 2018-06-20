
package espol.edu.ec.tdas;

/**El nodo simple contiene una data y una referencia al nodo que le sigue
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E> dato de cualuqier tipo que se almacena en el nodo
 */
public class Nodo<E> {
    private E data;
    private Nodo<E> next;
    
    public Nodo(E data){
        this.data=data;
        this.next=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
    
}
