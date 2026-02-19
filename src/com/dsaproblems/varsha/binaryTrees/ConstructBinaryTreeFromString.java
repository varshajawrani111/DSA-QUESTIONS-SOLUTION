package com.dsaproblems.varsha.binaryTrees;

public class ConstructBinaryTreeFromString {

    static class  Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = 0; //global variable to iterate through string

    public static void buildTree(Node root, String str){

        //if the encountered element in string is digit
        if(idx < str.length() && Character.isDigit(str.charAt(idx))){
            int sum =0;
            while(idx < str.length() && Character.isDigit(str.charAt(idx))){
                sum *= 10;
                sum += (str.charAt(idx) - '0');
                idx++;
            }

            root.data = sum;
        }

        //encountering '(' for the first time
        if(idx < str.length() && str.charAt(idx) == '('){

            root.left = new Node(0);
            idx++;
            buildTree(root.left, str);
        }

        //encountering '(' for the second time
        if(idx < str.length() && str.charAt(idx) == '('){

            root.right = new Node(0);
            idx++;
            buildTree(root.right, str);
        }

        if(idx >= str.length() || str.charAt(idx) == ')'){
            idx++;
            return;
        }
    }

    public static Node constructBinaryTreeFromString(String str){
        int n = str.length();
        Node root = new Node(0); //crating root node with random value

        buildTree(root,str);

        return root;
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";

        Node root = constructBinaryTreeFromString(str);
    }
}
