package net.cqwu.datastructure.interfaces;

import java.util.Collection;
import java.util.Queue;

public interface IStack<T> {

    /**
     * push the value on top of stack
     * @param value
     * @return
     */
    public boolean push(T value);

    /**
     * pop the value from the top stack
     * @return
     */
    public T pop();

    /**
     * peek the value from the top of stack
     * @return
     */
    public T peek();

    public boolean remove(T value);

    public void clear();

    public boolean contains(T value);

    public int size();

    public boolean validate();

    public Queue<T> toQueue();

    public Collection<T> toCollection();


}
