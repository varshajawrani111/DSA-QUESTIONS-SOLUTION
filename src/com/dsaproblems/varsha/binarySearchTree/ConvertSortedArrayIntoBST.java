package com.dsaproblems.varsha.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedArrayIntoBST {

    static class  Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBalanceBST(List<Integer> list, int start, int end)
    {
       if(start > end)
       {
           return null;
       }

       int mid = start + (end - start)/2;
       Node root = new Node(list.get(mid));

       root.left = buildBalanceBST(list, start, mid - 1);
       root.right = buildBalanceBST(list, mid + 1, end);

       return root;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Node root = buildBalanceBST(list, 0, list.size() - 1);
        System.out.println(root.data);
    }
}
