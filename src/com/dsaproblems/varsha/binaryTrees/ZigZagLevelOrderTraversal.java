package com.dsaproblems.varsha.binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (leftToRight) {
                    list.addLast(node.val);
                }
                else  {
                    list.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans.add(list);
            leftToRight = !leftToRight; //changing the flag value level wise
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(zigzagLevelOrder(root));
    }
}
