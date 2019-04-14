package Vector;

import java.util.Arrays;
import java.util.Comparator;

public class MyVector<E> {
    private int size;
    private Object[] elements;

    public synchronized int getSize(){
        return size;
    }
    public synchronized E get(int index){
        return (E) elements[index];
    }
    public MyVector(){
        this.size = 0;
        this.elements = new Object[10];
    }

    public synchronized boolean isEmpty(){
        return size == 0;

    }

    public synchronized void set(int index,E data){
        elements[index] = data;
    }

    public synchronized void add(E data){
        if (isEmpty()){
            elements[0] = data;
            size++;
        } else{
            if (size == elements.length){
                elements = Arrays.copyOf(elements,size + size);
            }
            elements[size] = data;
            size++;
        }
    }

    public synchronized void remove(int index){
        int j = index + 1;
        for (int i = index; j < size; i++) {
            elements[i] = elements[j];
            j++;
        }
        size--;
    }

    public synchronized boolean contains(E data, Comparator<E> comparator){
        for (int i = 0; i < size; i++) {
            if(comparator.compare(data , (E) elements[i]) == 0){
                return true;
            }
        }
        return false;
    }

    public synchronized boolean contains(E data){
        if(data instanceof Comparable){
            for (int i = 0; i < size; i++) {
                if (((Comparable) data).compareTo(elements[i]) == 0){
                    return true;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(elements[i].equals(data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public synchronized String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += elements[i]+",";
        }
        s = s.substring(0,s.length() - 1);
        s += "]";
        return s;
    }

}
