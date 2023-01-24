package org.mcs.algoritm;

import java.util.PriorityQueue;
import java.util.Queue;

public class SimpleQueue {

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(2);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        queue.offer("5");
        queue.offer("6");

        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
