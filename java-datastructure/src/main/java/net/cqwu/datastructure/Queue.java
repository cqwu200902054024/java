package net.cqwu.datastructure;

import net.cqwu.datastructure.interfaces.IQueue;

import java.util.Collection;

public interface Queue<T> extends IQueue<T> {
    /**
     *  This queue implementation is backed by an array.
     * @param <T>
     */
    class ArrayQueue<T> implements  Queue<T> {
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

        @Override
        public boolean offer(T value) {
            return false;
        }

        @Override
        public T poll() {
            return null;
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
            return 0;
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
    }
}
