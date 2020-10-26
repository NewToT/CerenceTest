package com.test;



import java.util.Arrays;
import java.util.List;

/**
 * 入口
 * @author Leo Wang
 */
public class Test {
    public static void main(String[] args) throws Exception {


        // test case
        Integer[] array = {1,11};
//        Integer[] array = {12, 13, 5,31, 21};
//        Integer[] array = {12, 5, 7, 12,21, 343, 121, 343, 456, 145};

        List<Integer> params = Arrays.asList(array);
        FibonacciPalindrome fibonacciPalindrome = new FibonacciPalindromeImpl();
        Pair result = fibonacciPalindrome.findFibonacciPalindrome(params);
        if(result != null){
            System.out.println("startIndex:" + result.getFirst() + ",length of the palindrome:" + result.getSecond());
        }else {
            System.out.println("not found");
        }
    }
}
