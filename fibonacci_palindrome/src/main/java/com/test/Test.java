package com.test;



import java.util.Arrays;
import java.util.List;

/**
 * 入口
 * @author Leo Wang
 */
public class Test {
    public static void main(String[] args) throws Exception {


        // test case  满足条件的多元素序列
        Integer[] array = {12, 7, 5, 7, 21, 343, 121, 343, 456, 145};


        // convert to List
        List<Integer> params = Arrays.asList(array);

        // 1. the sequence is the same whether read backward or forward
        // 2. either the sequence has fewer than three elements, or every contiguous three-element sequence
        // {a, b, c} in it satisfies at least one of these conditions: a==c, a+b==c, or a==b+c.
            FibonacciPalindrome fibonacciPalindrome = new FibonacciPalindromeImpl();
            Pair result = fibonacciPalindrome.findFibonacciPalindrome(params);
            System.out.println("startIndex:" + result.getFirst() + ",length of the palindrome:" + result.getSecond());

    }
}
