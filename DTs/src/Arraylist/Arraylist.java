package Arraylist;

import java.util.Arrays;
import java.util.Comparator;

public class Arraylist<E> {
    private int size;
    private Object[] elements;

    public int size(){
        return size;
    }

    public E get(int index){
        return (E) elements[index];
    }

    public Arraylist(){
        this.size = 0;
        this.elements = new Object[10];
    }

    public boolean isEmpty(){
        return size == 0;

    }

    public void set(int index,E data){
        elements[index] = data;
    }

    public void add(E data){
        if (isEmpty()){
            elements[0] = data;
            size++;
        } else{
            if (size == elements.length){
                elements = Arrays.copyOf(elements,size + (size/2));
            }
            elements[size] = data;
            size++;
        }
    }

    public void remove(int index){
        int j = index + 1;
        for (int i = index; j < size; i++) {
                elements[i] = elements[j];
                j++;
        }
        size--;
    }

    public boolean contains(E data, Comparator<E> comparator){
        for (int i = 0; i < size; i++) {
            if(comparator.compare(data , (E) elements[i]) == 0){
                return true;
            }
        }
        return false;
    }

    public boolean contains(E data){
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
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += elements[i]+",";
        }
        s = s.substring(0,s.length() - 1);
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        Arraylist<Integer> list = new Arraylist();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.elements.length);
    }
}
