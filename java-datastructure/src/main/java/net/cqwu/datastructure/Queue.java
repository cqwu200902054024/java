package net.cqwu.datastructure;

import net.cqwu.datastructure.interfaces.IQueue;

import java.util.Collection;

public interface Queue<T> extends IQueue<T> {
    /**先进先出（FIFO）
     *  This queue implementation is backed by an array.
     *  在数组的末尾插入元素，在数组的首部删除元素
     * @param <T>
     */
    class ArrayQueue<T> implements  Queue<T> {
        private static final int MINIMUM_SIZE = 10;
        private T[]  array = (T[])new Object[MINIMUM_SIZE];
        private int lastIndex = 0;
        private int firstIndex = 0;
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        /**
         * 在队列的开始出添加一个元素
         * 在数组的尾部插入元素
         * @param value
         * @return
         */
        @Override
        public boolean offer(T value) {
            System.out.println(this.lastIndex + "=====");
            if(this.size() >= this.array.length) {
                System.out.println("扩容。。。。");
                 this.grow(this.size());
            }
            this.array[this.lastIndex % this.array.length] = value;
            this.lastIndex ++;
            return true;
        }

        @Override
        public T poll() {
            int size = lastIndex - firstIndex;
            if (size < 0) {
                return null;
            }

            T t = array[firstIndex % array.length];
            array[firstIndex % array.length] = null;
            firstIndex++;

            size = lastIndex - firstIndex;
            if (size <= 0) {
                // Removed last element
                lastIndex = 0;
                firstIndex = 0;
            }

            int shrinkSize = array.length>>1;
            if (shrinkSize >= MINIMUM_SIZE && size < shrinkSize) {
                shrink();
            }
            return t;
        }

        @Override
        public T peek() {
            return null;
        }

        @Override
        public boolean remove(T value) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(T value) {
            return false;
        }

        @Override
        public int size() {
            return this.lastIndex - this.firstIndex;
        }

        @Override
        public boolean validate() {
            return false;
        }

        @Override
        public java.util.Queue<T> toQueue() {
            return null;
        }

        @Override
        public Collection<T> toCollection() {
            return null;
        }

        /**
         * 对数组进行扩容
         */
        private void grow(int size) {
            //在原来的基础上扩容50%
           int growSize = size + size << 1;
           T[] temp = (T[])new Object[growSize];
           //可以往数组中循环加入数据
           int adjLast = this.lastIndex % this.array.length;
           //往数组头部加入数据
           if(adjLast < this.firstIndex) {
               System.out.println("循环加载。。。");
             System.arraycopy(this.array,0,temp,this.array.length - adjLast,adjLast + 1);
           }
           //扩容
            System.arraycopy(this.array,this.firstIndex,temp,0,this.array.length - this.firstIndex);
           this.array = null;
           this.array = temp;
           this.lastIndex = this.lastIndex - this.firstIndex;
           this.firstIndex = 0;
        }

        private void shrink() {
            int shrinkSize = array.length>>1;
            T[] temp = (T[]) new Object[shrinkSize];
            // Since the array can wrap around, make sure you grab the first chunk
            int adjLast = lastIndex % array.length;
            int endIndex = (lastIndex>array.length)?array.length:lastIndex;
            if (adjLast <= firstIndex) {
                System.arraycopy(array, 0, temp, array.length-firstIndex, adjLast);
            }
            // Copy the remaining
            System.arraycopy(array, firstIndex, temp, 0, endIndex-firstIndex);
            array = null;
            array = temp;
            lastIndex = (lastIndex - firstIndex);
            firstIndex = 0;
        }
    }
}
