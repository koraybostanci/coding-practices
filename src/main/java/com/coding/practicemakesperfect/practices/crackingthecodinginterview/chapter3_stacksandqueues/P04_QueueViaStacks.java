package com.coding.practicemakesperfect.practices.crackingthecodinginterview.chapter3_stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class P04_QueueViaStacks {

    public class QueueWithStack<T> {

        private final Stack<T> stack1;
        private final Stack<T> stack2;

        public QueueWithStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void add(T value) {
            stack1.push(value);
        }

        public T remove() {
            shift();
            return stack2.pop();
        }

        public T peek() {
            shift();
            return stack2.peek();
        }

        public int count() {
            return stack1.size() + stack2.size();
        }

        private void shift() {
            if (stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
    }

    @Test
    public void test() {
        QueueWithStack<String> queue = new QueueWithStack<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        assertEquals(3, queue.count());
        assertEquals("a", queue.remove());
        assertEquals(2, queue.count());

        queue.add("d");

        assertEquals("b", queue.remove());
        assertEquals("c", queue.remove());
        assertEquals(1, queue.count());
        assertEquals("d", queue.remove());

    }

}

