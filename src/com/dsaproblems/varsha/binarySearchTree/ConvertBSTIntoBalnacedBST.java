package com.dsaproblems.varsha.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTIntoBalnacedBST {

    static class  Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static Node convertBST(Node root){

        List<Node> list = new ArrayList<>();
        inorderTraversal(root,list);

        return buildBalanceBST(list,0, list.size()-1);
    }


    public static void inorderTraversal(Node root, List<Node> list){

        if(root==null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root);
        inorderTraversal(root.right, list);
    }

    public static Node buildBalanceBST(List<Node> list, int start, int end){

        if(list.isEmpty() || start > end) {
            return null;
        }

        int mid = start + (end - start)/2;
        Node root = new Node(list.get(mid).data);

        root.left = buildBalanceBST(list, start, mid - 1);
        root.right = buildBalanceBST(list, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.right = new Node(2);
        root.right.right = new Node(3);
        root.right.right.right = new Node(4);

        root = convertBST(root);
        System.out.println(root.data);

    }
}
