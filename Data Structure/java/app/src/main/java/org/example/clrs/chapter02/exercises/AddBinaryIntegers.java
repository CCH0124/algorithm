package org.example.clrs.chapter02.exercises;

import java.util.LinkedList;
import java.util.List;

public class AddBinaryIntegers {
    public static List<Integer> addBinary(List<Integer> A, List<Integer> B) {
        var c = new LinkedList<Integer>();
        int carry = 0;
        for (int i = A.size(); i > 0; i--) {
            int num = (A.get(i - 1) + B.get(i - 1) + carry)%2;
            c.addFirst(num);
            carry = (int)Math.floor((A.get(i - 1) + B.get(i - 1) + carry)/2);
        }
        c.addFirst(carry);
        return c;
    }

    public static void main(String[] args) {
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
        var result = AddBinaryIntegers.addBinary(A, B);
        System.err.println(result);
    }
}
