package com.dsaproblems.varsha.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCacheImplementation {

    // ================= NODE CLASS =================
    // Represents a cache entry
    // Each node stores:
    // - key and value
    // - frequency count
    // - prev & next pointers for DLL
    static class Node {
        int key, value, freq;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;          // every new node starts with frequency = 1
            prev = null;
            next = null;
        }
    }

    // ================= DOUBLY LINKED LIST =================
    // Each frequency has its own doubly linked list
    // This DLL maintains LRU order for nodes with SAME frequency
    static class DLL {
        Node head, tail;
        int size;

        DLL() {
            // Dummy head and tail to avoid null checks
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Insert node at the front (Most Recently Used for this frequency)
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        // Remove a given node from the DLL
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Remove Least Recently Used node (node before tail)
        Node removeLast() {
            if (size == 0) return null;
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    // ================= LFU CACHE DATA MEMBERS =================
    private final int capacity;                 // maximum cache capacity
    private int minFreq;                        // minimum frequency in cache
    private final Map<Integer, Node> keyNode;   // key -> node
    private final Map<Integer, DLL> freqList;   // frequency -> DLL of nodes

    // ================= CONSTRUCTOR =================
    public LFUCacheImplementation(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqList = new HashMap<>();
    }

    // ================= GET OPERATION =================
    public int get(int key) {

        // If key does not exist, return -1
        if (!keyNode.containsKey(key)) return -1;

        // Fetch node from map
        Node node = keyNode.get(key);

        // Increase its frequency and move it to new freq list
        updateFreq(node);

        // Return stored value
        return node.value;
    }

    // ================= PUT OPERATION =================
    public void put(int key, int value) {

        // Edge case: capacity = 0
        if (capacity == 0) return;

        // Case 1: key already exists
        if (keyNode.containsKey(key)) {

            // Update value
            Node node = keyNode.get(key);
            node.value = value;

            // Increase frequency since it is accessed
            updateFreq(node);

        } else {

            // Case 2: key does not exist and cache is full
            if (keyNode.size() == capacity) {

                // Evict Least Frequently Used node
                // If tie, remove LRU from that frequency list
                DLL minList = freqList.get(minFreq);
                Node evict = minList.removeLast();

                // Remove from key map
                keyNode.remove(evict.key);
            }

            // Insert new node with frequency = 1
            Node newNode = new Node(key, value);
            keyNode.put(key, newNode);

            // Add node to frequency list 1
            freqList.computeIfAbsent(1, k -> new DLL()).addFirst(newNode);

            // Reset min frequency to 1
            minFreq = 1;
        }
    }

    // ================= UPDATE FREQUENCY =================
    // Moves node from old frequency list to new frequency list
    private void updateFreq(Node node) {

        int oldFreq = node.freq;
        DLL oldList = freqList.get(oldFreq);

        // Remove node from its current frequency list
        oldList.remove(node);

        // If this node was the only one with minFreq,
        // then increase minFreq
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Increase node's frequency
        node.freq++;

        // Add node to new frequency list at front (MRU)
        freqList
                .computeIfAbsent(node.freq, k -> new DLL())
                .addFirst(node);
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        LFUCacheImplementation cache = new LFUCacheImplementation(2);

        cache.put(1, 1);        // cache = {1}
        cache.put(2, 2);        // cache = {1,2}

        System.out.println(cache.get(1)); // 1 → freq(1)=2

        cache.put(3, 3);        // evicts key 2 (lowest freq)

        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 3

        cache.put(4, 4);        // evicts key 1 (freq=2, LRU)

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
