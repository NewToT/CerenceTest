package com.test;


import java.util.List;

/**
 * 具体实现
 *
 * @author LeoWang
 */
public class FibonacciPalindromeImpl implements FibonacciPalindrome {
    /**
     * find pair of fibonacci
     *
     * @param sequence A non-empty sequence of unsigned integers.
     * @return
     */
    public Pair findFibonacciPalindrome(List<Integer> sequence) {
        int start = 0;
        int length = 0;
        int tempIndex = 0;
        int tempLength = 0;

        // seq元素数量<=2
        if (sequence.size() <= 2) {
            StringBuilder stringBuilder = new StringBuilder();
            sequence.forEach(e -> stringBuilder.append(e.toString()));
            if (!checkPalindrome(stringBuilder.toString())) {
                return null;
            }

            length = stringBuilder.length();
        } else {
            // seq元素数量 > 2
            for (int i = 0; i < sequence.size() - 2; i++) {
                if (sequence.get(i).intValue() == sequence.get(i + 2).intValue() ||
                        sequence.get(i) + sequence.get(i + 1) == sequence.get(i + 2) ||
                        sequence.get(i) == sequence.get(i + 1) + sequence.get(i + 2)) {
                    tempIndex = i;
                    //拼接后面3个元素，看是否符合要求
                    StringBuilder stringBuilder = new StringBuilder(sequence.get(i).toString()).append(sequence.get(i + 1).toString()).append(sequence.get(i + 2).toString());
                    tempLength = stringBuilder.length();
                    // 是否回文 、 是否最长
                    if (length < tempLength && checkPalindrome(stringBuilder.toString()) ) {
                        start = tempIndex;
                        length = tempLength;
                    }
                }
            }

            // 无符合规则的序列
            if (length == 0) {
                return null;
            }
        }
        return new PairImpl(start, length);
    }

    /**
     * 回文验证
     *
     * @param str
     * @return
     */
    private static Boolean checkPalindrome(String str) {
        boolean result = false;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                result = true;
            } else {
                return result;
            }
        }
        return result;
    }
}
