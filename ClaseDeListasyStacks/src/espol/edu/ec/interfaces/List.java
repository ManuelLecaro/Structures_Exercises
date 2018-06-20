
package espol.edu.ec.interfaces;

/**
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E> cualquier tipo de dato como elemento de la lista.
 */
public interface List<E>{
    boolean isEmpty();
    int size();
    boolean addFirst(E element);
    boolean addLast(E element);
    E getFirst();
    E getLast();
    boolean contains(E element);
    boolean removeFirst();
    boolean removeLast();
    E get(int index);
    List<E> slicing(int inicio, int fin);
    boolean remove (int index);
    E set (int index, E element);
    boolean add(int index, E element);
    int indexOf(E element);
}
