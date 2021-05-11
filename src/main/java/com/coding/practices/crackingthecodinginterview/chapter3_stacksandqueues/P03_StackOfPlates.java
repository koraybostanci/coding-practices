package com.coding.practices.crackingthecodinginterview.chapter3_stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop ( )
 * should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 */
public class P03_StackOfPlates {

    /**
     * This solution does not provide to shift items into previous stack when a popAt occurs for one of intermediate stacks
     */
    class SetOfStacks<T> {
        private final int capacity;
        private final Stack<Stack<T>> stacks;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
            this.stacks = new Stack<>();
        }

        public void push(T item) {
            Stack<T> stack = getCurrentStack();
            stack.push(item);
        }

        public T pop() {
            Stack<T> stack = stacks.peek();
            return popOnStack(stack);
        }

        public T popAt(int index) {
            if (index > stacks.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Stack<T> stack = stacks.get(index);
            return popOnStack(stack);
        }

        private T popOnStack(Stack<T> stack) {
            T item = stack.pop();
            if (stack.isEmpty()) {
                stacks.pop();
            }
            return item;
        }

        private Stack<T> getCurrentStack() {
            if (stacks.isEmpty() || isFullCapacity(stacks.peek())) {
                stacks.push(new Stack<>());
            }
            return stacks.peek();
        }

        private boolean isFullCapacity(Stack<T> stack) {
            return stack.size() == capacity;
        }
    }

    @Test
    public void testPushPop() {
        SetOfStacks<String> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push("a");
        setOfStacks.push("b");
        setOfStacks.push("c");

        String item = setOfStacks.pop();
        assertEquals("c", item);

        setOfStacks.push("d");
        setOfStacks.push("e");
        setOfStacks.push("f");
        setOfStacks.push("g");

        item = setOfStacks.pop();
        assertEquals("g", item);
    }

    @Test
    public void testPopAt() {
        SetOfStacks<String> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push("a");
        setOfStacks.push("b");
        setOfStacks.push("c");

        String item = setOfStacks.popAt(0);
        assertEquals("b", item);

        item = setOfStacks.popAt(1);
        assertEquals("c", item);

        item = setOfStacks.popAt(0);
        assertEquals("a", item);
    }

    @Test
    public void testPopAtException() {
        SetOfStacks<String> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push("a");
        setOfStacks.push("b");
        setOfStacks.push("c");

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> setOfStacks.popAt(2));
    }

    @Test
    public void testPopItemAndRemoveStack() {
        SetOfStacks<String> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push("a");
        setOfStacks.push("b");
        setOfStacks.push("c");

        String item = setOfStacks.pop();
        assertEquals(setOfStacks.stacks.size(),1);
    }
}
