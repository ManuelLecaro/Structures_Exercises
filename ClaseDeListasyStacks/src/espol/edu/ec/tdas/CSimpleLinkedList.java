
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.List;

/**La lista simplemente enlazada circular tiene el ultimo nodo conectado al 
 * primero. Sirve para carruseles publicitarios giratorios, por ejemplo.
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E> un tipo de dato parametrizado que sera el mismo tipo para todos 
 * los elementos de la lista.
 */
public class CSimpleLinkedList<E> implements List<E>{
    private Nodo<E> first, last;
    private int ctrl;

    public CSimpleLinkedList() {
        this.first=this.last=null;
        this.ctrl=0;
    }

    @Override
    public boolean isEmpty() {
        return this.ctrl==0;
    }

    @Override
    public int size() {
        return this.ctrl;
    }

    @Override
    public boolean addFirst(E element) {
        Nodo<E> nodo= new Nodo(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            nodo.setNext(this.first);
            this.first=nodo;
        }
        this.last.setNext(this.first);
        ctrl++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo= new Nodo(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            this.last.setNext(nodo);
            this.last=nodo;
        }
        this.last.setNext(this.first);
        ctrl++;
        return true;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty())
            return null;
        return this.first.getData();
        }

    @Override
    public E getLast() {
        if (this.isEmpty())
            return null;
        return this.last.getData();  
    }

    @Override
    public boolean contains(E element) {
        Nodo<E> viajero=this.first;
        do {
            if (viajero.getData().equals(element))
                return true;
            viajero=viajero.getNext();
        }while(viajero!=this.last);
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty())
            return false;
        else if (ctrl==1)   //tambien puede ser: else if (this.first==this.last)
            this.first=this.last=null;
        else{
            this.last.setNext(this.first.getNext());
            this.first.setNext(null);
            this.first=this.last.getNext();
        }
        ctrl--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (this.isEmpty())
            return false;
        else if (ctrl==1)   //tambien puede ser: else if(this.first==this.last)
            this.first=this.last=null;
        else{
            Nodo <E> temp= this.getPrevious(this.last);
            this.last.setNext(null);
            this.last=temp;
            this.last.setNext(this.first);
        }
        ctrl--;
        return true;
    }

    @Override
    public E get(int index) {
        Nodo<E> viajero=this.first;
        int acum=0;
        do {
            if(index==acum)
                return viajero.getData();
            acum++;
            viajero=viajero.getNext();
        } while (viajero!=this.last);
        return null;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        if (inicio<0 || fin>=ctrl || this.isEmpty())
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
        Nodo<E> viajero=this.first;
        CSimpleLinkedList<E> listaSlicing= new CSimpleLinkedList<>();
        int acum=0;
        do {
            if (acum>=inicio && acum<fin)
                listaSlicing.addLast(viajero.getData());
            acum+=1;
            viajero=viajero.getNext();
        } while(viajero!=this.last);
        return listaSlicing;
    }

    @Override
    public boolean remove(int index) {
        if (this.isEmpty()||index<0||index>=ctrl)
            return false;
        else if (index==0)
            this.removeFirst();
        else if (index==ctrl-1)
            this.removeLast();
        Nodo<E> viajero=this.first;
        int i=0;
        do {
            if (i==index-1){
                Nodo<E> temp= viajero.getNext();
                viajero.setNext(temp.getNext());
                temp.setNext(null);
                ctrl--;
                return true;
            }
            viajero=viajero.getNext();
            i++;
        } while(viajero!=this.last);
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (index<0||index>=ctrl||element==null)
            throw new IllegalArgumentException("Argumentos no validos");
        Nodo<E> viajero=this.first,nodo=new Nodo(element);
        int i=0;
        do {
            if (i==index-1){
                Nodo<E> temp= viajero.getNext();
                nodo.setNext(temp.getNext());
                viajero.setNext(nodo);
                temp.setNext(null);
                return temp.getData();
            }
            viajero=viajero.getNext();
            i++;
        } while(viajero!=this.last);
        return null;
    }

    @Override
    public boolean add(int index, E element) {
        if (index<0||index>=ctrl||element==null)
            throw new IllegalArgumentException("Argumentos no validos");
        else if (index==0)
            this.addFirst(element);
        else if (index==ctrl-1)
            this.addLast(element);
        Nodo<E> viajero=this.first,nodo=new Nodo(element);
        int i=0;
        do {
            if (i==index-1) {
                Nodo<E> temp= viajero.getNext();
                nodo.setNext(temp);
                viajero.setNext(nodo);
                ctrl++;
                return true;
            }
            viajero=viajero.getNext();
            i++;
        } while(viajero!=this.last);
        return false;
    }

    @Override
    public int indexOf(E element) {
        if (this.isEmpty()||element==null)
            return -1;
        Nodo<E> viajero=this.first;
        int i=0;
        do{
            if (viajero.getData().equals(element))
                return i;
            viajero=viajero.getNext();
            i++;
        } while(viajero!=this.last);
        return -1;
    }
    
    private Nodo<E> getPrevious(Nodo<E> nodo){
        Nodo<E> viajero = this.first;
        do {
            if (viajero.getNext() == nodo)
                return viajero;
            viajero = viajero.getNext();
        } while (viajero != this.last);
        return null;
    }
}
