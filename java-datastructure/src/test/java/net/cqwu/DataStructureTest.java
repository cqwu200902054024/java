package net.cqwu;

import net.cqwu.datastructure.Queue;
import net.cqwu.datastructure.Stack;
import net.cqwu.datastructure.tree.BinaryNode;
import net.cqwu.datastructure.tree.BinaryNodeOperation;
import net.cqwu.datastructure.tree.BinarySearchTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu
 *
 * @author： Administrator
 * Create Date：  2018-05-08
 * Modified By：   Administrator
 * Modified Date:  2018-05-08
 * Why & What is modified
 * Version:        V1.0
 */
public class DataStructureTest {

    @Test
    public void testQueue() {
   /*     Queue<Integer> queue = new Queue.ArrayQueue<>();
        for(int i = 0; i < 100; i ++) {
            queue.offer(i);
        }
        for(int i = 0; i < 100; i ++) {
            System.out.println(queue.poll());
        }*/
        System.out.println(2 >> 1);
    }

    @Test
    public void testBinaryTree() {
        BinaryNode root = BinaryNodeOperation.createBinaryNode();
        BinaryNodeOperation.thePostOrderTraversal(root);
        List<String> elems = new ArrayList<>();
        BinaryNodeOperation.thePostOrderTraversal1(root,elems);
        root = BinaryNodeOperation.createBinaryTreeByThePostOrderTraversal(elems);
        System.out.println("===========");
        BinaryNodeOperation.thePostOrderTraversal(root);
    }

    /**
     *
     */
    @Test
    public void testBase() {
        System.out.println("c".charAt(0));
    }

    /**
     *
     */

    @Test
    public void testBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode(6);
        BinarySearchTree bt = new BinarySearchTree(root);
        bt.insert(2);
        bt.insert(8);
        bt.insert(1);
        bt.insert(4);
        bt.insert(3);
        BinaryNodeOperation<Integer> bno = new BinaryNodeOperation<>();
        bno.firstTraversal(root);
        bt.insert(5);
        System.out.println();
        bno.firstTraversal(root);
        System.out.println();
        System.out.println(bt.findMax());
    }
}
