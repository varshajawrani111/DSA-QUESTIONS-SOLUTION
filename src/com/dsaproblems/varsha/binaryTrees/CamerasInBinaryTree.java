package com.dsaproblems.varsha.binaryTrees;

import java.util.HashSet;
import java.util.Set;

public class CamerasInBinaryTree {

    static class  Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int camera;
//    static Set<Node> covered; //to store the covered nodes --> this will give space complexity of O(N)
//
//    public static int minCameras(Node root){
//        if(root==null){
//            return 0;
//        }
//
//        camera=0;
//        covered=new HashSet<>();
//        covered.add(null); //so that we don't add cameras at leaf nodes
//
//        dfs(root, null); //parent of root is null
//
//        return camera;
//    }
//
//    public static void dfs(Node node, Node parent){
//        if(node != null){
//
//            dfs(node.left, node);
//            dfs(node.right, node);
//
//            //check if i need to add camera
//            //Parent is null and node is not covered --> rootof tree
//            //OR
//            //if any of its right or left child are not covered
//            if(parent == null && !covered.contains(node) //root of tree
//                    || !covered.contains(node.left) || !covered.contains(node.right)
//                //this will not add cameras at leaf nodes because is already added in set
//            ){
//                camera++;
//                covered.add(node); //node itself will be covered
//                covered.add(parent); //its parent will be covered
//                covered.add(node.left); //its left child will be covered
//                covered.add(node.right); //its right child will be covered
//            }
//
//        }
//    }

    public static int minCamera(Node root) {

        return dfs(root) == 0 ? camera + 1 : camera;
        //if root is not covered then camera will be placed at root so increase count by 1
    }

    //2-->Has camera
    //1--> Covered with camera
    //0-->No camera is covering this node
    public static int dfs(Node node){

        if(node == null){
            return 1;  //null nodes are covered i.e means camera will not be placed at leaf nodes
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        //check if we need camera

        //if either of the child is not covered by camera place camera at the node and return 2
        if(left == 0 || right == 0){
            camera++;
            return 2;
        }

        //if either of child has camera
        else if(left == 2 || right == 2){
            return 1; //this node is covered by its child
        }

        else return 0; //this node is not covered by any one

    }

    public static void main(String[] args) {

        /*
                    0
                   / \
                  0   0
                     /
                    0
        */

        Node root = new Node(0);
        root.left = new Node(0);
        root.right = new Node(0);
        root.right.left = new Node(0);

        System.out.println("Minimum cameras: " + minCamera(root));
    }

}
