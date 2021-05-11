package com.coding.practices.crackingthecodinginterview.chapter3_stacksandqueues;


import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Sort Stack: Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into any other
 * data structure (such as an array).
 *
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */
public class P05_SortStack {

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        final Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            Integer item = stack.pop();
            while (!stack2.isEmpty() && item < stack2.peek()) {
                stack.push(stack2.pop());
            }
            stack2.push(item);
        }

        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    @Test
    public void testWithEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        sortStack(stack);
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    public void testWithOneElement() {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);

        sortStack(stack);
        assertEquals(9, (long)stack.pop());
    }

    @Test
    public void testSorting() {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(5);
        stack.push(10);
        stack.push(7);
        stack.push(12);
        stack.push(8);

        sortStack(stack);
        assertEquals(5, (long)stack.pop());
    }

}
