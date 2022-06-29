package com.shama.datastructures.btree.pep;

import java.io.*;
import java.util.*;

public class Diameter {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static int diameter0(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);
        int ld = diameter0(node.left);
        int rd = diameter0(node.right);

        int td = Math.max(lh + rh + 2, Math.max(ld, rd));
        return td;
    }

    static class DPair {
        int ht;
        int dia;
    }

    public static DPair diameter(Node node) {
        if (node == null) {
            DPair bp = new DPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }

        DPair lp = diameter(node.left);
        DPair rp = diameter(node.right);

        DPair mp = new DPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));
        return mp;
    }

    /////////////////////////////////////////////////  recursive solution /////////////////////////////////////////////////
    public int diameterOfBinaryTree(Node root) {
        int[] max = new int[1];
        getMaxDepth(root, max);
        return max[0];
    }

    public int getMaxDepth(Node node, int[] max) {
        if (node == null) {
            return 0;
        }

        int maxLeftDepth = getMaxDepth(node.left, max);
        int maxRightDepth = getMaxDepth(node.right, max);

        max[0] = Math.max(max[0], maxLeftDepth + maxRightDepth);

        return 1 + Math.max(maxLeftDepth, maxRightDepth);
    }
    ///////////////////////////////////////////////// /////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        Node root = construct(arr);

//        Dpair result = diameter(root);
//        System.out.println(result.dia);
    }

    ///////////////////////////////////////////////// TUF /////////////////////////////////////////////////

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left, diameter);
        int rh = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    ///////////////////////////////////////////////// /////////////////////////////////////////////////

}
