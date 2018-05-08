package net.cqwu.datastructure;

import net.cqwu.datastructure.interfaces.IStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;


public interface Stack<T> extends IStack<T> {

    /**
     * This stack implementation is backed by an array.
     * @param <T>
     */
    public static class ArrayStack<T> implements Stack<T> {
        private static final int MINIMUM_SIZE = 1024;
        private T[] array = (T[])new Object[MINIMUM_SIZE];
        private int size = 0;
        @Override
        public boolean push(T value) {
            //对数组进行扩容
            if(this.size > array.length) {
                grow();
            }
            array[size ++] = value;
            return true;
        }

        /**
         * 弹出栈顶元素
         * @return
         */
        @Override
        public T pop() {
            if(this.size <= 0) {
                return null;
            }
            T t = this.array[--this.size];
            this.array[this.size] = null;
            //对原来的数组进行所容
            int shrinkSize = this.array.length >> 1;
            if(MINIMUM_SIZE <= shrinkSize && this.size < shrinkSize) {
                shrink();
            }
            return t;
        }

        /**
         * 取出栈顶元素
         * @return
         */
        @Override
        public T peek() {
            if(this.size <= 0) {
                return null;
            }
            T t = this.array[--this.size];
            return t;
        }

        /**
         * 通过索引获取元素
         * @param index
         * @return
         */
        public T get(int index) {
            if(index >= 0 && index < this.size) {
                return this.array[index];
            }
            return null;
        }

        /**
         * 移除栈中某个元素
         * @param value
         * @return
         */
        @Override
        public boolean remove(T value) {
            for(int i = 0; i < this.size; i ++) {
                T obj = this.array[i];
                if(value.equals(obj)) {

                }
            }
            return false;
        }

        /**
         * 通过索引移除某个元素
         * @param index
         * @return
         */
        private boolean remove(int index) {
            //Object src,  int  srcPos, Object dest, int destPos, int length
            if(index != --this.size) {
                System.arraycopy(this.array, index + 1, this.array, index, this.size - index);
            }
            this.array[this.size] = null;
            //缩容
            int shrinkSize = this.array.length >> 1;
            if(this.size >= MINIMUM_SIZE && this.size < shrinkSize) {
                shrink();
            }
            return true;
        }

        @Override
        public void clear() {
            this.size = 0;
        }

        /**
         * 判断栈中是否包含某个元素
         * @param value
         * @return
         */
        @Override
        public boolean contains(T value) {
            for(int i = 0; i < this.size; i ++) {
                T obj = this.array[i];
                if(obj.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int size() {
            return this.size;
        }

        /**
         * 校验栈是否合理：栈中是否有空元素
         * @return
         */
        @Override
        public boolean validate() {
            int localSize = 0;
            for(int i = 0; i < this.array.length; i ++) {
                T t = this.array[i];
                if(i < this.size) {
                    if(t == null) {
                        return false;
                    }
                    localSize ++;
                } else {
                    if(t != null) {
                        return false;
                    }
                }
            }
            return this.size == localSize;

        }

        @Override
        public Queue<T> toQueue() {
            return null;
        }

        @Override
        public Collection<T> toCollection() {
            return null;
        }

        /**
         * 对原来数组进行扩容，扩大为原来的2倍
         */
        private void grow() {
            int growSize = this.size + this.size << 1;
            this.array = Arrays.copyOf(this.array,growSize);
        }

        /**
         * 将原来的额数组缩小为原来的一半
         */
        private void shrink() {
            int shrinkSize = this.array.length >> 1;
            this.array = Arrays.copyOf(this.array,shrinkSize);
        }


        @Override
        public String toString() {
            return super.toString();
        }
    }


    /**
     * This stack implementation is backed by a linked list.
     * @param <T>
     */
    public static class LinkedStack<T> implements Stack<T> {

        private Node<T> top;
        private int size;
        @Override
        public boolean push(T value) {
            return push(new Node<T>(value));
        }

        private boolean push(Node node) {
            if(this.top == null) {
                this.top = node;
            } else {
                //将元素插入栈顶
                Node<T> oldTop = this.top;
                this.top = node;
                this.top.below = oldTop;
                oldTop.above = this.top;
            }
            size ++;
            return true;
        }

        /**
         * 弹出栈顶元素
         * @return
         */
        @Override
        public T pop() {
            if(this.top == null) {
                return null;
            }
            Node<T> nodeToRemove = this.top;
            this.top = nodeToRemove.below;
            if(this.top != null) {
                this.top.above = null;
            }
            T value = nodeToRemove.value;
            size --;
            return value;
        }

        /**
         * 获取栈顶元素
         * @return
         */
        @Override
        public T peek() {
            return this.top == null ? null:this.top.value;
        }

        /**
         * 根据索引获取数据
         * @param index
         * @return
         */
        public T get(int index) {
          Node<T> current = this.top;
          for(int i = 0; i < index; i ++) {
              if(current == null) {
                  break;
              }
              current = current.below;
          }
          return current == null?null:current.value;
        }

        /**
         * 根据值移除某个元素
         * @param value
         * @return
         */
        @Override
        public boolean remove(T value) {
            Node<T> node = this.top;
            while (node != null && !node.value.equals(value)) {
                node = node.below;
            }
            if(node == null) {
                return false;
            }
            return remove(node);
        }

        private boolean remove(Node<T> node) {
             Node<T> below = node.below;
             Node<T> above = node.above;
             //node是栈底元素
             if(below == null && above != null) {
                 above.below = null;
                 //node是栈顶元素
             } else if(below != null && above == null) {
                  below.above = null;
                  this.top = below;
             } else if(below != null && above != null) {
                 above.below = below;
                 below.above = above;
             } else {
                 this.top = null;
             }
             size --;
             return true;
        }

        @Override
        public void clear() {
             this.top = null;
             this.size = 0;
        }

        @Override
        public boolean contains(T value) {
            Node<T> node = this.top;
            while (node !=null) {
                if(node.value.equals(value)) {
                    return true;
                }
                node = node.below;
            }
            return false;
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public Queue<T> toQueue() {
            return null;
        }

        @Override
        public Collection<T> toCollection() {
            return null;
        }

        private static class Node<T> {
            private T value;
            private Node<T> above;
            private Node<T> below;
            private Node(T value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "value=" + value + " above=" + ((above != null) ? above.value : "NULL") + " below="
                        + ((below != null) ? below.value : "NULL");
            }
        }
    }


}
