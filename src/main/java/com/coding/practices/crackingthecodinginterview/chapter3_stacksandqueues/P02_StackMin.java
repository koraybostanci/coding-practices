package com.coding.practices.crackingthecodinginterview.chapter3_stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class P02_StackMin {

    class StackWithMin extends Stack<Integer> {

        Stack<Integer> minStack;

        public StackWithMin() {
            minStack = new Stack<>();
        }

        public void push(int value) {
            if (value <= currentMin()) {
                minStack.push(value);
            }
            super.push(value);
        }

        public Integer pop() {
            int value = super.pop();
            if (value == currentMin()) {
                minStack.pop();
            }
            return value;
        }

        public Integer min() {
            return minStack.peek();
        }

        private int currentMin() {
            return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

    }

    @Test
    void test() {
        final StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(12);
        stack.push(3);

        assertEquals(3 , (long)stack.min());

        stack.pop();
        stack.push(24);

        assertEquals(4, (long)stack.min());
        stack.push(2);

        assertEquals(2 , (long)stack.min());
    }
}
