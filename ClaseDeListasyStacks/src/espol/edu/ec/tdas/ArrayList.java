
package espol.edu.ec.tdas;

import espol.edu.ec.interfaces.List;

/**
 * @author Daniel Alejandro Arroyo Yanez
 */
public class ArrayList<E> implements List<E> {
    private E[] arreglo;
    private int MAX=10;
    private int ctrl;
    
    public ArrayList(){
        this.arreglo= (E[]) new Object[MAX];
        this.ctrl=0;
    }
    
    public ArrayList(int size){
        this.MAX=size;
        this.arreglo= (E[]) new Object[MAX];
        this.ctrl=0;
    }
    
    public ArrayList(E[] arreglo){
        this.arreglo=arreglo;
        this.ctrl=arreglo.length-1;
    }
    
    @Override
    public boolean isEmpty() {
        return ctrl==0;
    }

    @Override
    public int size() {
        return ctrl;
    }

    @Override
    public boolean addFirst(E element) {
        if (this.isEmpty()){
            this.arreglo[ctrl]= element;
            ctrl++;
            return true;
        }
        else if (element==null)
            throw new ArrayStoreException("Objeto null no puede ser almacenado");
        else if (ctrl==MAX){
            this.copy();
        }
        else{
            for (int i=ctrl-1; i>=0;i--)
                arreglo[i+1]=arreglo[i];
            this.arreglo[0]=element;
            ctrl++;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element==null)
            throw new ArrayStoreException("Objeto null no puede ser almacenado");
        else if (ctrl==MAX){
            this.copy();
        }
        this.arreglo[ctrl]= element;
        ctrl ++;
        return true;
    }

    @Override
    public E getFirst() {
        if (this.isEmpty())
            throw new IllegalStateException("El arreglo esta vacio");
        return this.arreglo[0];
    }

    @Override
    public E getLast() {
        if (this.isEmpty())
            throw new IllegalStateException("El arreglo esta vacio");
        return this.arreglo[ctrl-1];
    }

    @Override
    public boolean contains(E element) {
        for (int i=0; i<ctrl-1;i++){
            if (this.arreglo[i].equals(element))
                return true;
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty())
            return false;
        for (int i=0;i<ctrl;i++)
            this.arreglo[i]=arreglo[i+1];
        ctrl--;
        return true;
    }

    @Override
    public boolean removeLast() {
        this.arreglo[ctrl-1]=this.arreglo[ctrl];
        ctrl--;
        return true;
    }

    @Override
    public E get(int index) {
        if (index>=0 && index<this.ctrl)
            return this.arreglo[index];
        else
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
    }
    
    private void copy(){
        MAX*=2;
        E[] arregloNew= (E[]) new Object[MAX];
        for (int i=0; i<ctrl;i++)
            arregloNew[i]=this.arreglo[i];
        this.arreglo=arregloNew;
    }

    @Override
    public List<E> slicing(int inicio, int fin) {
        if (inicio<0 ||fin>ctrl)
            throw new IndexOutOfBoundsException("El indice esta fuera de "
                    + "los limites del arreglo");
        E[] arregloSlice= (E[]) new Object[fin-inicio];
        for (int i=inicio;i<fin;i++)
            arregloSlice[i]=this.arreglo[i];
        ArrayList<E> arrayS= new ArrayList<>(fin-inicio);
        arrayS.arreglo=arregloSlice;
        arrayS.ctrl=fin;
        return arrayS;
    }
    
    @Override
    public String toString(){
        String impresion="[";
        if (this.isEmpty())
            return impresion+"]";
        for (int i=0;i<ctrl;i++){
            if(i==ctrl-1)
                impresion+=this.arreglo[i].toString()+"]";
            else
                impresion+=this.arreglo[i].toString()+",";
        }
        return impresion;
    }

    @Override
    public boolean remove(int index) {
        if (this.isEmpty()|| index<0 || index>=this.ctrl)
            return false;
        for (int i=index;i<ctrl;i++)
            this.arreglo[i]=arreglo[i+1];
        ctrl--;
        return true;
    }

    @Override
    public E set(int index, E element) {
        if (index <0 && index >= this.ctrl || !(this.isEmpty()&& index==0))
            return null;
        else if (element==null)
            throw new ArrayStoreException("Objeto null no puede ser almacenado");
        E temp= this.arreglo[index];
        this.arreglo[index]=element;
        return temp;
    }

    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index >= this.ctrl)
            return false;
        else if (element==null)
            throw new ArrayStoreException("Objeto null no puede ser almacenado");
        for (int i=ctrl-1; i>index;i--)
                arreglo[i+1]=arreglo[i];
        this.arreglo[index]= element;
        ctrl++;
        return true;    
    }

    @Override
    public int indexOf(E element) {
        if (element==null||this.isEmpty())
            return -1;
        for (int i=0; i<ctrl; i++){
            if (this.arreglo[i].equals(element))
                return i;
        }
        return -1;
    }
}
