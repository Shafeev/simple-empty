package org.mcs.tasks.memory;

import java.util.*;

/**
 * Имея две строки s и p, вернуть массив всех начальных индексов анаграмм p в s. Вы можете вернуть ответ в любом порядке.
 * <p>
 * Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы, обычно с
 * использованием всех исходных букв ровно один раз.
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(findAnagrams(s1, p1));
        String s2 = "abab";
        String p2 = "ab";
        System.out.println(findAnagrams(s2, p2));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        char[] symbols = new char[30];
        for (int i = 0; i < p.length(); i++) {
            symbols[p.charAt(i) - 'a']++;
        }

        int sLength = s.length();
        int index = 0;
        while((index + p.length()) <= sLength) {
            char[] symbolsTwo = new char[30];
            String anagram = s.substring(index, index + p.length());
            System.out.println(anagram);
            for (int i = 0; i < anagram.length(); i++) {
                symbolsTwo[anagram.charAt(i) - 'a']++;
            }
            if (Arrays.equals(symbols, symbolsTwo)) {
                result.add(index);
            }
            index++;

        }

        return result;
    }

}
