package edu.ti.collections.list.linked;

import sun.awt.image.ImageWatched;

public class LinkedList {
    private class Node {
        Object payload;
        Node next = null;


        public Node(Object payload) {
            this.payload = payload;
        }

        public Object getPayload() {
            return payload;
        }

        public void setPayload(Integer payload) {
            this.payload = payload;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head = null;
    private Node previous = null;
    private Node current = null;

    public LinkedList() {
        // nothing
    }

    public LinkedList(Object payload) {
        head = new Node(payload);
    }

    public boolean isEmpty() {
        return (head == null);
    }

    //TODO -- implement private helper method end that returns last Node in list
    private  Node end() {
        current = head;
        while (current.getNext() != null){
            previous = current;
            current = current.getNext();
        }
        return current;
    }

    //TODO -- implement size to return number of Nodes in list
    public int size() {
        int count = 0;
        current = head;
        if (current != null){
            count = 1;
        }
        while (current.getNext() != null){
            previous = current;
            current = current.getNext();
            count++;
        }
        return count;
    }

    //TODO -- implement insert, which inserts Node for object as new head of list
    public void insert(Object object) {
        //code needed here
        Node newNode = new Node(object);
        newNode.setNext(head);
        head = newNode;
        if ((current == head.getNext()) && (current != null)){
            previous = head;
        }
    }

    //TODO -- implement append, that appends Node to end of list
    public void append(Object object) {
        //code needed here
        Node last = end();
        Node newNode = new Node(object);
        last.setNext(newNode);


    }

    //TODO -- implement get to retrieve the n-th object in the list,
    //        return null if n > (size() - 1)
    public Object get(int n) {
        current = head;
        int count = -1;
        boolean found = false;

        while ((current != null) && ! found){
            count++;
            if (count == n){
                found = true;
            }
            else{
                previous = current;
                current = current.getNext();
            }
        }
        if(current == null){
            return null;
        }
        return current.payload;
    }

    //TODO -- implement remove to remove n-th element of list,
    //        return Object if n < size(), null otherwise
    public Object remove(int n) {
        if (n < size()){
            current = head;
            previous = null;
            int count = -1;
            boolean found = false;

            while (! found){
                count++;
                if (count == n){
                    found = true;
                }
                else{
                    previous = current;
                    current = current.getNext();
                }
            }
            Object ret = current.payload;
            if (previous == null){
                head = current.getNext();
                current = head;
                return ret;
            }
            else{
                previous.next = current.getNext();
                current = current.getNext();
                return ret;
            }


        }
        else{
            return null;
        }



    }

    //TODO -- implement remove to remove given object from list,
    //        return Object if object is in the list, null otherwise
    public Object remove(Object object) {
        boolean found = false;
        current = head;
        while ((current != null) && ! found){
            Object dataAtPosition = current.payload;
            if (dataAtPosition.equals(object)){
                found = true;
            }
            else{
                previous = current;
                current = current.getNext();
            }
        }
        if (!found){
            return null;
        }
        Object ret = current.payload;
        if (previous == null){
            head = current.getNext();
            current = head;
            return ret;
        }
        else{
            previous.next = current.getNext();
            current = current.getNext();
            return ret;
        }



    }
}
