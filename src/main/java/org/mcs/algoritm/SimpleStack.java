package org.mcs.algoritm;

import java.util.Stack;

public class SimpleStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.add("one");
        stack.add("two");
        stack.add("tree");
        stack.add("four");
        stack.add("five");

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.search("four"));
        System.out.println(stack.search("tree"));
        System.out.println(stack.search("one"));
        System.out.println(stack.search("five"));

    }
}
