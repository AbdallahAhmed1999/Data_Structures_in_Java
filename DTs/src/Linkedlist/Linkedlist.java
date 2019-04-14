package Linkedlist;

import java.util.LinkedList;

public class Linkedlist<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public Linkedlist(){
        size = 0;
    }

    public int recSize(){
        return sizeHelper(this.head);
    }

    private int sizeHelper(Node<E> node){
        if (head == null){
            return 0;
        }
        if (head.next == null){
            return 1;
        }
        return 1 + sizeHelper(node.next);
    }


    public int getIndexRec(Node node,E data){
        if (head == null){
            return -1;
        }
        if (data == node.data){
            return 1;
        }
        return 1 + getIndexRec(node.next,data);
    }


    public int size()  {
        return size;
    }

    public boolean isEmpty(){
        if(head == null && tail == null){
            return true;
        }
        return false;
    }

    public void addAtHead(E data){
        if (isEmpty()){
            head = new Node(data);
            tail = head;
            size++;
        }else{
            Node temp = head;
            head = new Node(data);
            head.next = temp;
            size++;
        }
    }

    public void addAtTail(E data){
        if (isEmpty()){
            tail = new Node(data);
            head = tail;
            size++;
        }else {
            tail.next = new Node(data);
            tail = tail.next;
            size++;
        }
    }

    public void add(E data){
        if (isEmpty()){
            addAtHead(data);
        }else{
            addAtTail(data);
        }
    }

    public void add(int index,E data){
        if (index == 0){
            addAtHead(data);
        }else if (index == size-1){
            addAtTail(data);
        }else{
            Node currnet = head;
            Node previus = null;
            int i = 0;
            while (i <= index){
                if (i == index - 1){
                    previus = currnet;
                }
                if (i == index){
                    previus.next = new Node(data);
                    previus.next.next = currnet;
                    size++;
                    break;
                }
                currnet = currnet.next;
                i++;
            }
        }
    }

    public void deleteHead(){
        if (size == 1){
            head = null;
            tail = null;
            size--;
        }else{
            head = head.next;
            size--;
        }
    }

    public void deleteTail(){
        if (size == 1){
            head = null;
            tail = null;
            size--;
        }else{
            Node current = head;
            for (int i = 0 ; i<size ; i++){
                if (i == size-2){
                    tail = current;
                    size--;
                }
                current = current.next;
            }
        }

    }

    public void delete(int index){
        if (index == 0){
            deleteHead();
        }else if(index == size-1){
            deleteTail();
        }else{
            Node current = head;
            for (int i = 0; i < size; i++) {
                if (index-1 == i){
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
    }

    public E getHead(){
        return head.getData();
    }

    public E getTail(){
        return tail.getData();
    }

    public E get(int index){
        if(index == 0) {
            return getHead();
        } else if(index == size - 1) {
            return getTail();
        }else{
            Node current = head;
            for (int i = 0; i < size; i++) {
                current = current.next;
                if (i == index){
                    break;
                }
            }
            return (E) current.getData();
        }
    }

    class Node<E> {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

    }

    public static void main(String[] args) {
        Linkedlist<Integer> list = new Linkedlist();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.getIndexRec(list.head,4));
    }
}























