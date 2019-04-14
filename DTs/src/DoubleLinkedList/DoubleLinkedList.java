package DoubleLinkedList;

import javax.xml.crypto.Data;

public class DoubleLinkedList<E> {

    int size = 0;
    Node<E> head ;
    Node<E> tail;

    public boolean isEmpty(){
        if (head == null && tail == null){
            return true;
        }
        return false;
    }

    public void addAtHead(E data){
        if (isEmpty()){
            head = new Node(data);
            tail = head;
        }else{
            Node<E> newNode = new Node(data);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(E data){
        if (isEmpty()){
            tail = new Node(data);
            head = tail;
        }else{
            Node<E> newNode = new Node(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index,E data){
        if (index == 0){
            addAtHead(data);
        }else if(index == size-1){
            addAtTail(data);
        }else{
            Node previous = null;
            Node current = null;
            Node ref = head;

            for (int i = 0; i < size; i++) {
                if (i == index-1){
                    previous = ref;
                }
                if (i == index){
                    current = ref;
                    Node<E> newNode =  new Node(data);

                    previous.next = newNode;
                    newNode.previous = previous;

                    current.previous = newNode;
                    newNode.next = current;

                    size++;
                    break;
                }
                ref = ref.next;
            }
        }
    }

    public void deleteHead(){
        Node<E> temp = head.next;
        head.next = null;
        temp.previous = null;
        head = temp;
        size--;
        if (size == 1){
            tail = head;
        }
    }

    public void deleteTail(){
        Node<E> temp = tail.previous;
        tail.previous = null;
        temp.next = null;
        tail = temp;
        size--;
        if (size == 1){
            head = tail;
        }
    }

    public void delete(int index){
        if (index == 0){
            deleteHead();
        }else if (index == size - 1){
            deleteTail();
        } else {
            Node<E> current = null;
            Node<E> previous = null;
            Node<E> ref = head;

            for (int i = 0; i < size; i++) {
                if (i == index - 1){
                    previous = ref;
                }
                if (i == index){
                    current = ref;

                    previous.next = current.next;
                    current.next.previous = previous;

                    current.next = null;
                    current.previous = null;

                    size--;
                    break;
                }
                ref = ref.next;
            }
        }
    }

    public E get(int index){
        if(index == 0) {
            return head.getData();
        } else if(index == size - 1) {
            return tail.getData();
        } else {
            Node<E> current = head;

            for(int i = 0 ; i < size ; i++) {
                if(i == index) {
                    break;
                }

                current = current.next;
            }

            return current.getData();
        }
    }

    class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data){
            this.data = data;
        }

        public E getData(){
            return this.data;
        }
    }
}
