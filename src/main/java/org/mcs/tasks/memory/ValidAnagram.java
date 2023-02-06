package org.mcs.tasks.memory;

import java.util.Arrays;

/**
 * Имея две строки s и t, вернуть true, если t является анаграммой s, и false в противном случае.
 * <p>
 * Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы,
 * обычно с использованием всех исходных букв ровно один раз.
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        boolean result = false;

        if (s.length() != t.length()) {
            return result;
        }

        char[] symbols = new char[30];
        char[] symbolsTwo = new char[30];
        for (int index = 0; index < s.length(); index++) {
            symbols[s.charAt(index) - 'a']++;
            symbolsTwo[t.charAt(index) - 'a']++;
        }

        if (Arrays.equals(symbols, symbolsTwo)) {
            result = true;
        }

        return result;
    }
}
