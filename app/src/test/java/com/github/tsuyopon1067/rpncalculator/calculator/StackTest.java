package com.github.tsuyopon1067.rpncalculator.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testIsEmpty_NewStack_ReturnsTrue() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testIsEmpty_AfterPush_ReturnsFalse() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testIsEmpty_AfterPushAndPop_ReturnsTrue() {
        stack.push(1);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPushAndPop_SingleElement() {
        Integer value = 42;
        stack.push(value);
        assertEquals(value, stack.pop());
    }

    @Test
    void testPushAndPop_MultipleElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPeek_ReturnsTopElementWithoutRemovingIt() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPop_EmptyStack_ThrowsException() {
        assertThrows(Exception.class, () -> stack.pop());
    }

    @Test
    void testPeek_EmptyStack_ThrowsException() {
        assertThrows(Exception.class, () -> stack.peek());
    }

    @Test
    void testClear_EmptiesTheStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test
    void testGenericSupport_StringStack() {
        Stack<String> stringStack = new Stack<>();

        stringStack.push("Hello");
        stringStack.push("World");

        assertEquals("World", stringStack.pop());
        assertEquals("Hello", stringStack.pop());
    }
}