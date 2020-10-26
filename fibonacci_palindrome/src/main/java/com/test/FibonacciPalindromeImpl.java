package com.test;

import java.util.ArrayList;
import java.util.List;


public class FibonacciPalindromeImpl implements FibonacciPalindrome {
    public Pair findFibonacciPalindrome(List<Integer> sequence) {

        if (sequence == null || sequence.isEmpty() || sequence.size() ==1) {
            return null;
        }
        if(sequence.size() ==2){
            if(sequence.get(0) == sequence.get(1))
                return new PairImpl(0, 2);
        }

        Pair palindromePair = findOutPalindrome(sequence);

        if ((int) palindromePair.getSecond() >= 3) {
            return palindromePair;
        } else {
            Pair fibonacci = findOutFibonacci(sequence);
            return fibonacci;
        }
    }
    /**
     * To find Palindrome sequence
     * <p>
     *
     *
     * @param sequence
     * @return A Pair(startIndex, length)
     */
    private static PairImpl findOutPalindrome(List<Integer> sequence) {
        int start = 0, end = 0;
        int num1, num2, len;
        for (int i = 0; i < sequence.size(); i++) {
            num1 = getMaxLength(sequence, i, i);
            num2 = getMaxLength(sequence, i, i + 1);
            len = Math.max(num1, num2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        //return string.substring(start, end + 1);
        return new PairImpl(start , end - start + 1);
    }
    /**
     * To find Fibonacci sequence in Palindrome seq
     * <p>
     *
     * @param sequence 
     * @return A Pair(startIndex, length)
     */
    private static Pair findOutFibonacci(List<Integer> sequence){

        List<Integer> tempList = new ArrayList<>();

        for(int i=0;i<=sequence.size()-3;i++){
            tempList = sequence.subList(i,i+3);

            if(tempList.get(0) == tempList.get(2)||
                    tempList.get(0)+ tempList.get(1) == tempList.get(2)||
                    tempList.get(0) == tempList.get(1) + tempList.get(2)
            )
                return new PairImpl(i+1, 3);
        }
        return null;
    }

    /**
     * To get the max length between two results
     * <p>
     *
     * @param s
     * @param left
     * @param right
     * 
     * @return A Pair(startIndex, length)
     */
    private static int getMaxLength(List<Integer> s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.size() && s.get(L) == s.get(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
