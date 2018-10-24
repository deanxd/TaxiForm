package com.deanxd.taxiform.queue;

/**
 * 循环队列--数组实现
 */
public class CircleArrayQueue {

    private String[] mElements;
    private int head = 0, tail = 0;
    private int size;

    public CircleArrayQueue(int capacity) {
        mElements = new String[capacity];
        size = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String element) {
        if ((tail + 1) % size == head) {
            return false;
        }

        mElements[tail] = element;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队列
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String mElement = mElements[head];
        head = (head + 1) % size;
        return mElement;
    }


}
