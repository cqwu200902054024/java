package net.cqwu.datastructure.tree;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:  二叉查找树
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.datastructure.tree
 *
 * @author： Administrator
 * Create Date：  2018-07-12
 * Modified By：   Administrator
 * Modified Date:  2018-07-12
 * Why & What is modified
 * Version:        V1.0
 */
public class BinarySearchTree<T extends Comparable<? super T>>{
    private BinaryNode<T> root;

    public BinarySearchTree(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * 往查找二叉树中插入元素
     * @param x
     */
    public BinaryNode<T> insert(T x) {
       return  insert(x,this.root);
    }

    private BinaryNode<T> insert(T x,BinaryNode<T> t) {
        if(t == null) {
            return new BinaryNode<>(x);
        }
        if(x.compareTo(t.getData()) < 0) {
            t.setLeft(insert(x,t.getLeft()));
        } else if(x.compareTo(t.getData()) > 0) {
            t.setRight(insert(x,t.getRight()));
        } else {
            //return t;
        }
        return t;
    }

    /**
     * 查找二叉树中是否包含元素x
     * @param x
     * @return
     */
    public boolean contains(T x) {
       return contains(x,this.root);
    }

    private boolean contains(T x,BinaryNode<T> t) {
          if(t == null) {
              return false;
          }
          if(x.compareTo(t.getData()) < 0) {
              return contains(x,t.getLeft());
          } else if(x.compareTo(t.getData()) > 0) {
              return contains(x,t.getRight());
          } else {
              return true;
          }
    }

    public T findMin() {
        return findMin(this.root);
    }

    private T findMin(BinaryNode<T> t) {
        if(t == null) {
            return null;
        }
        if(t.getLeft() == null) {
            return t.getData();
        }
        return findMin(t.getLeft());
    }

    public T findMax() {
          return findMax(this.root);
    }

    public T findMax(BinaryNode<T> t) {
        if(t == null) {
            return null;
        }
        if(t.getRight() == null) {
            return t.getData();
        }
        return findMax(t.getRight());
    }
}
