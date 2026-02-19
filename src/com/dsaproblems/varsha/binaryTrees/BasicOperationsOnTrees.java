package com.dsaproblems.varsha.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOperationsOnTrees {

    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static Node root;

    public void insert(int val){
        if(root == null){
            root = new Node(val);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node newNode = new Node(val);

        while(!q.isEmpty()){
            Node node = q.poll();

            //finding the first null node
            if(node.left == null){
                node.left = newNode;
                return;
            }else {
                q.add(node.left);
            }

            if(node.right == null){
                node.right = newNode;
                return;
            }
            else {
                q.add(node.right);
            }
        }
    }

    public void delete(int key){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(root.val == key){
                root = null;
                return;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node keyNode = null;
        Node curr = null;

        while(!q.isEmpty()){
            curr = q.poll();

            if(curr.val==key){
                keyNode = curr;
            }

            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }

        if(keyNode != null){
            keyNode.val = curr.val; //swapping the keyNode value to deleteNode
            deleteDeepest(curr); //delete the curr node
        }
    }

    public void deleteDeepest(Node deleteNode){

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.left != null) {
                if (curr.left == deleteNode) {
                    curr.left = null;
                    return;
                }
                q.add(curr.left);
            }

            if (curr.right != null) {
                if (curr.right == deleteNode) {
                    curr.right = null;
                    return;
                }
                q.add(curr.right);
            }
        }
    }

    public boolean searchNode(int key){
        if(root == null){
            return true;
        }


        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node node = q.poll();

            if(node.val == key){
                return true;
            }

            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        BasicOperationsOnTrees tree = new BasicOperationsOnTrees();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        System.out.println(root.val);

        System.out.println(tree.searchNode(5));
        System.out.println(tree.searchNode(14));

        tree.delete(1);
        tree.delete(2);

        System.out.println(root.val);
    }
}
