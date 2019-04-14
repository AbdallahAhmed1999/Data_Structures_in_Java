package Queue;

import java.util.ArrayList;

public class MyQueue<E> {
    private int size;
    private ArrayList<E> list ;

    public MyQueue(){
        size = 0;
        list = new ArrayList();
    }

    public void enqueue(E data){
        list.add(data);
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E dequeue(){
        if (isEmpty()){
            throw new NullPointerException("Queue is Empty");
        }
        return list.remove(0);
    }

    public void clear(){
        for (int i = 0 ; i < size; i++){
            list.set(i,null);
        }
    }

    public E getHead(){
        return list.get(0);
    }
}
