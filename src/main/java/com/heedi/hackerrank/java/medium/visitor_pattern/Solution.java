package com.heedi.hackerrank.java.medium.visitor_pattern;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private static final int M = 1000000007;
    private long result = 1;

    public int getResult() {
        return (int) result;
    }

    /*
    ProductRedNodesVisitor's getResult method must be computed modulo 10(9) + 7
     */
    public void visitNode(TreeNode node) {
        if(node.getColor().equals(Color.RED)) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenRootValue = 0;
    private int greenLeafValue = 0;

    public int getResult() {
        return Math.abs(evenRootValue - greenLeafValue);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0) {
            evenRootValue += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.GREEN)) {
            greenLeafValue += leaf.getValue();
        }
    }
}

public class Solution {
    private static int[] value;
    private static Color[] color;
    private static Map<Integer, Set<Integer>> lines;

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        value = new int[n];
        color = new Color[n];
        lines = new HashMap<>();

        String[] values = sc.nextLine().split(" ");
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] colors = sc.nextLine().split(" ");
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            lines.put(i, new HashSet<>()); // edge 관계 map 초기화 (java7 not support diamond)
            int vItem = Integer.parseInt(values[i]);
            value[i] = vItem; // value 값 저장
            int cItem = Integer.parseInt(colors[i]);
            color[i] = cItem == 0 ? Color.RED : Color.GREEN;  // color 값 저장
        }

        for (int i = 0; i < n - 1; i++) {
            values = sc.nextLine().split(" ");
            Integer node1 = Integer.parseInt(values[0]) - 1;
            Integer node2 = Integer.parseInt(values[1]) - 1;

            lines.get(node1).add(node2);
            lines.get(node2).add(node1);
        }

        return makeTree();
    }

    private static Tree makeTree() {
        if (lines.get(0).isEmpty())
            return new TreeLeaf(value[0], color[0], 0);
        else {
            TreeNode root = new TreeNode(value[0], color[0], 0);
            makeChildTree(root, 0);
            return root;
        }
    }

    private static void makeChildTree(TreeNode parent, int parentIndex) {
        for (int childIndex : lines.get(parentIndex)) {
            lines.get(childIndex).remove(parentIndex); // 중복확인 제거

            Tree child;
            Set<Integer> childsOfChild = lines.get(childIndex);
            if (childsOfChild == null || childsOfChild.isEmpty()) {
                child = new TreeLeaf(value[childIndex], color[childIndex], parentIndex + 1);
            } else {
                child = new TreeNode(value[childIndex], color[childIndex], parentIndex + 1);
            }

            if (child instanceof TreeNode) {
                makeChildTree((TreeNode) child, childIndex);
            }

            parent.addChild(child);
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}