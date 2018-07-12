package net.cqwu.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.datastructure.tree
 *
 * @author： p.z
 * Create Date：  2018-07-12
 * Modified By：   Administrator
 * Modified Date:  2018-07-12
 * Why & What is modified
 * Version:        V1.0
 */
public class BinaryNodeOperation<T> {

    /**
     * create binaryNode
     * 创建二叉树
     */
    public static BinaryNode createBinaryNode() {
        BinaryNode<String> a = new BinaryNode<>("a");
        BinaryNode<String> b = new BinaryNode<>("b");
        BinaryNode<String> c = new BinaryNode<>("c");
        BinaryNode<String> d = new BinaryNode<>("d");
        BinaryNode<String> e = new BinaryNode<>("e");
        BinaryNode<String> f = new BinaryNode<>("f");
        BinaryNode<String> g = new BinaryNode<>("g");

        BinaryNode<String> xl = new BinaryNode<>("*");
        xl.setLeft(b);
        xl.setRight(c);

        BinaryNode<String> al = new BinaryNode<>("+");
        al.setLeft(a);
        al.setRight(xl);

        BinaryNode<String> rx = new BinaryNode<>("*");
        rx.setLeft(d);
        rx.setRight(e);

        BinaryNode<String> ra = new BinaryNode<>("+");
        ra.setLeft(rx);
        ra.setRight(f);

        BinaryNode<String> rx2 = new BinaryNode<>("*");
        rx2.setLeft(ra);
        rx2.setRight(g);

        BinaryNode<String> root = new BinaryNode<>("+");
        root.setLeft(al);
        root.setRight(rx2);

        return root;
    }


    /**
     * 先序遍历：
     * 根节点，左子树，右子树
     * @param root
     */
    public static void theFirstTraversal(BinaryNode<String> root) {
        System.out.print(root);
        if(root.getLeft() != null) {
            theFirstTraversal(root.getLeft());
        }
        if(root.getRight() != null) {
            theFirstTraversal(root.getRight());
        }
    }

    /**
     * 先序遍历
     */
    public void firstTraversal(BinaryNode<T> t) {
        System.out.print(t);
        if(t.getLeft() != null) {
            firstTraversal(t.getLeft());
        }
        if(t.getRight() != null) {
            firstTraversal(t.getRight());
        }
    }

    /**
     * 后序遍历：
     * 左子树，右子树，根节点
     * @param root
     */
    public static void thePostOrderTraversal(BinaryNode<String> root) {
         BinaryNode<String> left = root.getLeft();
         if(left != null) {
             thePostOrderTraversal(left);
         }
        BinaryNode<String> right = root.getRight();
         if(right != null) {
             thePostOrderTraversal(right);
         }
       System.out.print(root);
    }

    /**
     *
     * @param root
     * @return
     */
    public static void thePostOrderTraversal1(BinaryNode<String> root,List<String> elems) {
        BinaryNode<String> left = root.getLeft();
        if(left != null) {
            thePostOrderTraversal1(left,elems);
        }
        BinaryNode<String> right = root.getRight();
        if(right != null) {
            thePostOrderTraversal1(right,elems);
        }
        elems.add(root.getData());
    }

    /**
     * 中序遍历：
     * 左节点，根节点，又节点
     * @param root
     */
    public static void theInOrderTraversal(BinaryNode<String> root) {
          BinaryNode<String> left = root.getLeft();
          if(left != null) {
              theInOrderTraversal(left);
          }
        System.out.print(root);
        BinaryNode<String> right = root.getRight();
        if(right != null) {
            theInOrderTraversal(right);
        }
    }

    /**
     * 通过后序遍历构造表达式二叉树
     * @param elems
     * @return
     */
    public static BinaryNode<String> createBinaryTreeByThePostOrderTraversal(List<String> elems) {
        Stack<BinaryNode<String>> stack = new Stack<>();
        for(String elem : elems) {
            if(isChar(elem.charAt(0))) {
                stack.push(new BinaryNode<String>(elem + ""));
            } else {
                if(!stack.empty()) {
                    BinaryNode<String> right = stack.pop();
                    BinaryNode<String> left = stack.pop();
                    BinaryNode<String> root = new BinaryNode<String>(elem + "", left, right);
                    stack.push(root);
                }
            }
        }
        return stack.pop();
    }

    private static boolean isChar(char c) {
        return Integer.valueOf(c) >= 97 && Integer.valueOf(c) <= 122 ? true : false;
    }

}
