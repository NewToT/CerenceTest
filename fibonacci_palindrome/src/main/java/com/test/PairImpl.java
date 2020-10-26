package com.test;

public class PairImpl implements Pair {
    private Integer first;
    private Integer second;

    PairImpl(Integer start, Integer length) {
        first = start;
        second = length;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }
}
