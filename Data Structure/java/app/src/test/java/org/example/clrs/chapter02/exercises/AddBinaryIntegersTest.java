package org.example.clrs.chapter02.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

public class AddBinaryIntegersTest {
    @Test
    public void addBinaryTest() {
        var A = new LinkedList<Integer>();
        var B = new LinkedList<Integer>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        B.add(1);
        B.add(1);
        B.add(1);
        B.add(1);
        var binary = AddBinaryIntegers.addBinary(A, B);
        var actual = new LinkedList<Integer>();
        actual.add(1);
        actual.add(1);
        actual.add(1);
        actual.add(1);
        actual.add(0);
        assertEquals(binary, actual);
    }

    @Test
    public void addBinaryTest_2() {
        var A = new LinkedList<Integer>();
        var B = new LinkedList<Integer>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        B.add(0);
        B.add(1);
        B.add(1);
        B.add(1);
        var binary = AddBinaryIntegers.addBinary(A, B);
        var actual = new LinkedList<Integer>();
        actual.add(1);
        actual.add(0);
        actual.add(1);
        actual.add(1);
        actual.add(0);
        assertEquals(binary, actual);
    }
}
