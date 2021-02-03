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
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class FancyVisitor extends TreeVis {
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

public class Solution {
    private static int[] value;
    private static Color[] color;
    private static Map<Integer, List<Integer>> lines;

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        value = new int[n];
        color = new Color[n];
        lines = new HashMap<>();

        String[] cItems = sc.nextLine().split(" ");
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            value[i] = cItem; // value 값 저장
            lines.put(i, new ArrayList<>()); // edge 관계 map 초기화
        }

        cItems = sc.nextLine().split(" ");
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            color[i] = cItem == 0 ? Color.RED : Color.GREEN;  // color 값 저장
        }
        for (int i = 0; i < n - 1; i++) {
            cItems = sc.nextLine().split(" ");
            Integer node1 = Integer.parseInt(cItems[0]) - 1;
            Integer node2 = Integer.parseInt(cItems[1]) - 1;

            lines.get(node1).add(node2);
            lines.get(node2).add(node1);
        }

        return makeTree();
    }

    private static boolean[] trace;

    private static Tree makeTree() {
        if (lines.get(0).isEmpty())
            return new TreeLeaf(value[0], color[0], 0);
        else {
            trace = new boolean[value.length];
            return dfsTree(0, 0);
        }
    }

    private static Tree dfsTree(int i, int depth) {
        trace[i] = true;

        List<Tree> childs = new ArrayList<>();
        for (int childValue : lines.get(i)) {
            if(!trace[childValue]) {
                childs.add(dfsTree(childValue, depth + 1));
            }
        }

        if (childs.isEmpty()) {
            return new TreeLeaf(value[i], color[i], depth);
        } else {
            TreeNode me = new TreeNode(value[i], color[i], depth + 1);
            for (Tree child : childs) {
                me.addChild(child);
            }

            return me;
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