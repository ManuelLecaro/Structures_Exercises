
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.List;

/**La lista doblemente enlazada circular tiene el ultimo nodo conectado al 
 * primero. Sirve para carruseles publicitarios giratorios, por ejemplo.
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E>
 */
public class CDoubleLinkedList<E> implements List<E> {
    private DobleNodo<E> first,last;
    private int ctrl;

    public CDoubleLinkedList() {
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
        DobleNodo<E> nodo= new DobleNodo(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            nodo.setNext(this.first);
            this.first.setPrevious(nodo);
            this.first=nodo;
        }
        ctrl++;
        closeList(this);
        return true;
    }

    @Override
    public boolean addLast(E element) {
        DobleNodo<E> nodo= new DobleNodo(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            this.last.setNext(nodo);
            nodo.setPrevious(this.last);
            this.last=nodo;
        }
        ctrl++;
        closeList(this);
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
        DobleNodo<E> p= this.first,q= this.last;
        do{
            if (q.getData().equals(element) || p.getData().equals(element))
                return true;
            p=p.getNext();
            q=q.getPrevious();
        } while (q.getNext()!=p && p!=q);
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty())
            return false;
        else if (this.first==this.last)
            this.first=this.last=null;
        else{
            DobleNodo<E> temp= this.first.getNext();
            this.first.setNext(null);
            this.first=temp;
        }
        ctrl--;
        closeList(this);
        return true;
    }

    @Override
    public boolean removeLast() {
        if (this.isEmpty())
            return false;
        else if(this.first==this.last)
            this.first=this.last=null;
        else{
            DobleNodo<E> temp= this.last.getPrevious();
            this.last.setPrevious(null);
            this.last=temp;
            this.last.setNext(null);
        }
        ctrl--;
        closeList(this);
        return true;
    }

    @Override
    public E get(int index) {
                if (this.isEmpty() || index<0 || index>=ctrl)
            return null;
        DobleNodo<E> p= this.first,q= this.last;
        int i=0,j=ctrl-1;
        do{
            if (i==index)
                return p.getData();
            else if (j==index)
                return q.getData();
            p=p.getNext(); q=q.getPrevious();
            i++; j--;
        } while (q.getNext()!=p && p!=q);
        return null;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        if (inicio<0 || fin>ctrl || this.isEmpty())
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
        DobleNodo<E> viajero=this.first;
        CDoubleLinkedList<E> listaSlicing= new CDoubleLinkedList<>();
        int acum=0;
        do {
            if (acum>=inicio && acum<fin)
                listaSlicing.addLast(viajero.getData());
            acum+=1;
            viajero=viajero.getNext();
        } while(viajero!=this.last);
        closeList(listaSlicing);
        return listaSlicing;
    }

    @Override
    public boolean remove(int index) {
        if (index<0 || index>=ctrl || this.isEmpty())
            return false;
        DobleNodo<E> p= this.first,q=this.last;
        int i=0,j=ctrl-1;
        do{
            if (i==index)
                remove(p);
            else if (j==index)
                remove(q);
            p=p.getNext();
            i++;
            q=q.getPrevious();
            j--;
        } while (q.getNext()!=p && p!=q);
        return false;
    }

    @Override
    public E set(int index, E element) {
        checkArguments(index,element);
        DobleNodo<E> p= this.first,q=this.last,nodo=new DobleNodo<>(element);
        int i=0,j=ctrl-1;
        do{
            if (i==index)
                replace(p,nodo);
            else if (j==index)
                replace(q,nodo);
            p=p.getNext(); q=q.getPrevious();
            i++; j--;
        } while (q.getNext()!=p && p!=q);
        return null;       
    }

    @Override
    public boolean add(int index, E element) {
        checkArguments(index,element);
        DobleNodo<E> p= this.first,q=this.last,nodo=new DobleNodo<>(element);
        int i=0,j=ctrl-1;
        do{
            if (i==index)
                add(p,nodo);
            else if (j==index)
                add(q,nodo);
            p=p.getNext(); q=q.getPrevious();
            i++; j--;
        } while (q.getNext()!=p && p!=q);
        return false; 
    }

    @Override
    public int indexOf(E element) {
        if (element==null||this.isEmpty())
            return -1;
        DobleNodo<E> p= this.first,q=this.last;
        int i=0,j=ctrl-1;
        do {
            if (p.getData().equals(element))
                return i;
            else if(q.getData().equals(element))
                return j;
            p=p.getNext(); q=q.getNext();
            i++;j--;
        }while (q.getNext()!=p && p!=q);
        return -1;
    }
    
    private void closeList(CDoubleLinkedList list){
        list.last.setNext(list.first);
        list.first.setPrevious(list.last);
    }
    
    private boolean remove(DobleNodo<E> nodo){
        nodo.getPrevious().setNext(nodo.getNext());
        nodo.setNext(null);
        nodo.setPrevious(null);
        ctrl--;
        closeList(this);
        return true;
    }
    
    private E replace(DobleNodo<E> nodoOld, DobleNodo<E> nodoNew){
        nodoOld.getPrevious().setNext(nodoNew);
        nodoNew.setNext(nodoOld.getNext());
        nodoNew.setPrevious(nodoOld.getPrevious());
        nodoOld.setNext(null);
        nodoOld.setPrevious(null);
        return nodoOld.getData();
    }
    
    private boolean add(DobleNodo<E> nodoOld, DobleNodo<E> nodoNew){
        nodoOld.getPrevious().setNext(nodoNew);
        nodoNew.setNext(nodoOld);
        nodoNew.setPrevious(nodoOld.getPrevious());
        ctrl++;
        closeList(this);
        return true;
    }
    
    private void checkArguments(int index, E element){
        if (element==null)
            throw new IllegalArgumentException("Objeto null no puede ser "
                    + "almacenado");
        else if (index<0 || index>=ctrl)
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
        else if (this.isEmpty())
            throw new ArrayStoreException("El arreglo esta vacio");
    } 
    
    
    @Override
    public String toString() {
        String s="[";
        DobleNodo<E> viajero=this.first;
        while(viajero!=null){
            if (viajero.getNext()==null)
                s+=viajero.getData().toString();
            else
                s+=viajero.getData().toString()+", ";
            viajero=viajero.getNext();
        }
        s+=" ]";
        return s;
    }

}
