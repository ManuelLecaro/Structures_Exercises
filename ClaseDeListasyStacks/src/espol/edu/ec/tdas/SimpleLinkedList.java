
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.List;

/**
 *
 * @author Daniel Alejandro Arroyo Yanez
 * @param <E> Cualquier objeto que sera el tipo de dato de la lista.
 */
public class SimpleLinkedList<E> implements List<E> {
    private Nodo<E> first,last;
    private int ctrl;
    
    public SimpleLinkedList(){
        this.first=this.last=null;
    }

    @Override
    public boolean isEmpty() {
        return this.first==null && this.last==null;
    }

    @Override
    public int size() {
        //En este caso el tiempo de ejecucion es O(1)
        return ctrl;
        
        //En este caso el tiempo de ejecucion es O(n) donde n es el numero
        //de nodos en el LinkedList
        /*//Si no tuviera el atributo ctrl, seria con esto:
        int acum=0;
        Nodo<E> viajero=this.first;
        while(viajero!=null){
            acum+=1;
            viajero=viajero.getNext();
        }
        return acum;*/
    }

    @Override
    public boolean addFirst(E element) {
        Nodo<E> nodo= new Nodo<>(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            nodo.setNext(this.first);
            this.first=nodo;
        }
        ctrl++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Nodo<E> nodo= new Nodo<>(element);
        if (element==null)
            return false;
        else if (this.isEmpty())
            this.first=this.last=nodo;
        else{
            this.last.setNext(nodo);
            this.last=nodo;
        }
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
        while(viajero!=null){
            if (viajero.getData().equals(element))
                return true;
            viajero=viajero.getNext();
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty())
            return false;
        else if (ctrl==1)   //tambien puede ser: else if(this.first==this.last)
            this.first=this.last=null;
        else{
            Nodo <E> temp= this.first;
            this.first=this.first.getNext();
            temp.setNext(null);
        }
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
            this.last=temp;
            this.last.setNext(null);
        }
        return true;
    }

    @Override
    public E get(int index) {
        Nodo<E> viajero=this.first;
        int acum=0;
        while(viajero!=null){
            if(index==acum)
                return viajero.getData();
            acum+=1;
            viajero=viajero.getNext();
        }
        return null;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        if (inicio<0 || fin>=ctrl || this.isEmpty())
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
        Nodo<E> viajero=this.first;
        SimpleLinkedList<E> listaSlicing= new SimpleLinkedList<>();
        int acum=0;
        while(viajero!=null){
            if (acum>=inicio && acum<fin){
                listaSlicing.addLast(viajero.getData());
            }
            acum+=1;
            viajero=viajero.getNext();
        }
        return listaSlicing;
    }
    
    @Override
    public String toString(){
        String s="[";
        Nodo<E> viajero=this.first;
        while(viajero!=null){
            if (viajero.getNext()==null)
                s+=viajero.getData().toString();
            else
                s+=viajero.getData().toString()+",";
            viajero=viajero.getNext();
        }
        s+="]";
        return s;
    }
    
    private Nodo<E> getPrevious(Nodo<E> nodo){
        Nodo<E> viajero=this.first;
        while(viajero!=null){
            if (viajero.getNext()==nodo)
                return viajero;
            viajero=viajero.getNext();
        }
        return null;
    }

    @Override
    public boolean remove(int index) {
        if (this.isEmpty()||index<0||index>=ctrl)
            return false;
        Nodo<E> viajero=this.first;
        int i=0;
        while(viajero!=null&&viajero.getNext()!=null){
            if (i==index){
                Nodo<E> temp= viajero.getNext();
                viajero.setNext(temp.getNext());
                temp.setNext(null);
                ctrl--;
                return true;
            }
            viajero=viajero.getNext();
            i++;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        Nodo<E> viajero=this.first, nodo= new Nodo<>(element);
        if (element==null)
           throw new IllegalArgumentException("Objeto null no puede ser almacenado");
        else if (this.isEmpty()&&index==0){
            this.addFirst(element);
            return null;
        }
        int i=0;
        while(viajero!=null){
            if (i==index){
                Nodo<E> temp= viajero;
                temp.setNext(nodo);
                nodo.setNext(viajero.getNext());
                return viajero.getData();
            }
            viajero=viajero.getNext();
            i++;
        }
        return null;
    }

    @Override
    public boolean add(int index, E element) {
        Nodo<E> viajero=this.first, nodo= new Nodo(element);
        if (this.isEmpty()&&index==0){
            this.addFirst(element);
            return true;
        }
        else if (element==null)
            throw new IllegalArgumentException("Objeto null no puede ser almacenado");
        int i=0;
        while(viajero!=null){
            if (i==index){
                Nodo<E> temp= viajero;
                temp.setNext(nodo);
                nodo.setNext(viajero);
                ctrl++;
                return true;
            }
            viajero=viajero.getNext();
            i++;
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        if (this.isEmpty()||element==null)
            return -1;
        Nodo<E> viajero=this.first;
        int i=0;
        while(viajero!=null){
            if (viajero.getData().equals(element)){
                return i;
            }
            viajero=viajero.getNext();
            i++;
        }
        return -1;
    }
    
    public Nodo<E> getFirstNodo(){
        return this.first;
    }
    public Nodo<E> getLastNodo(){
        return this.last;
    }
    
}
