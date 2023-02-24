package org.mcs.tasks.string;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(new FizzBuzzList(15));
    }

    private static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }

    private static class FizzBuzzList extends AbstractList<String> implements RandomAccess {
        private int size;

        public FizzBuzzList(int size) {
            this.size = size;
        }

        public String get(int index) {
            int n = index + 1;
            if (n % 3 == 0) {
                if (n % 5 == 0) {
                    return "FizzBuzz";
                }
                return "Fizz";
            }
            if (n % 5 == 0) {
                return "Buzz";
            }
            return Integer.toString(n);
        }

        public int size() {
            return size;
        }
    }
}
