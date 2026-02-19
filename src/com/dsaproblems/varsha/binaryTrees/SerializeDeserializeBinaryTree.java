package com.dsaproblems.varsha.binaryTrees;

public class SerializeDeserializeBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static String serializeBinaryTree(Node root){
        StringBuilder sb = new StringBuilder();

        serialize(root,sb);

        return sb.toString();
    }

    public static void serialize(Node root, StringBuilder sb){

        if(root == null){
            sb.append("#").append(",");
            return;
        }

        //Preorder serialization will be done
        sb.append(root.data).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    static int idx;

    public static Node deserializeBinaryTree(String str){
        idx = 0;

        String[] arr = str.split(",");

        return desiralize(arr);
    }

    public static Node desiralize(String[] arr){
        if(idx >= arr.length){
            return null;
        }

        //if it is the null node
        String val = arr[idx++];

        if(val.equals("#")){
            return null;
        }

        Node root = new Node(Integer.parseInt(val));
        root.left = desiralize(arr);
        root.right = desiralize(arr);

        return root;
    }

    public static void main(String[] args) {

        /*
                    1
                   / \
                  2   3
                     / \
                    4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String serialized = serializeBinaryTree(root);
        System.out.println("Serialized Tree: " + serialized);

        Node newRoot = deserializeBinaryTree(serialized);
        System.out.println("Tree deserialized successfully");
    }


}
