package com.dsaproblems.varsha.linkedlist;

import java.util.HashMap;

public class LRUCacheImplementation {

    //Doubly linked list node
    static class Node{

        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private static HashMap<Integer,Node> map;
    private static int capacity;
    static Node head;
    static Node tail;

    LRUCacheImplementation(int capacity){
        LRUCacheImplementation.capacity = capacity;
        map = new HashMap<Integer,Node>();

        // Dummy head & tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);


        head.next = tail;
        tail.prev = head;
    }

    //Delete node function
    public static void deleteNode(Node node){

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    //Insert node function
    public static void insertNodeAfterHead(Node node){

        Node currNodeAfterHead = head.next;

        head.next = node;
        node.next = currNodeAfterHead;
        node.prev = head;

        currNodeAfterHead.prev = node;
    }

    //get value function
    public static int get(int key){

        if(!map.containsKey(key)){
            return -1;
        }

        //if the key is present in the map then we need to delete that node nad then inser tit afer the head
        Node node = map.get(key);
        deleteNode(node);
        insertNodeAfterHead(node);

        return node.value;
    }

    //put key and value function
    public static void put(int key,int value){

        //if the map has the key
        if(map.containsKey(key)){

            Node node = map.get(key); //get the node from key value
            node.value = value; //change the node value
            deleteNode(node); //delete that node as it is now most recently used
            insertNodeAfterHead(node); //insert the node in front the head
        }
        else {

            //if the map does not contain the key also the map size is equal to the capacity
            // then we need to delete least recently used node
            // Remove LRU (node before tail)
            if(map.size() == capacity){

                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertNodeAfterHead(newNode);
        }
    }

    public static void main(String[] args) {

        LRUCacheImplementation cache = new LRUCacheImplementation(2);

        put(1, 1);
        System.out.println("put(1,1)");

        put(2, 2);
        System.out.println("put(2,2)");

        System.out.println("get(1) -> " + get(1)); // 1

        put(3, 3);
        System.out.println("put(3,3)  // evicts key 2");

        System.out.println("get(2) -> " + get(2)); // -1

        put(4, 4);
        System.out.println("put(4,4)  // evicts key 1");

        System.out.println("get(1) -> " + get(1)); // -1
        System.out.println("get(3) -> " + get(3)); // 3
        System.out.println("get(4) -> " + get(4)); // 4

    }


}
