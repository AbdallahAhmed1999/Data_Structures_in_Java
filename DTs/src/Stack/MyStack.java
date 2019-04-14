package Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E> {

    private int size;
    private ArrayList<E> list;

    public MyStack(){
        size = 0;
        list = new ArrayList();
    }

    public int size(){
        return size;
    }

    public void purge(){
        for (int i = 0; i < size ; i++){
            list.set(i,null);
        }
    }

    public void push(E data){
        list.add(data);
        size++;
    }

    public void pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        list.remove(size-1);
        size--;
    }

    public E peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list.get(size - 1);

    }

    public boolean isEmpty(){
        return size == 0;
    }



}
