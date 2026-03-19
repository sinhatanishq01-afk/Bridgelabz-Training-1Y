package com.gla.string;

public class Lc2119 {
    class Solution {
        public boolean isSameAfterReversals(int num) {
            return num == 0 || num % 10 != 0;
        }
    }
}
