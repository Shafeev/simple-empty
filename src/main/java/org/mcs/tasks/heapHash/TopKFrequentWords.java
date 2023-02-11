package org.mcs.tasks.heapHash;

import java.util.*;

/**
 * Учитывая массив строк words и целое число k, вернуть k наиболее часто встречающихся строк.
 *
 * Верните ответ, отсортированный по частоте от самой высокой до самой низкой. Отсортируйте слова с одинаковой
 * частотностью по их лексикографическому порядку.
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words1 = new String[]{"i","love","leetcode","i","love","coding"};
        int k1 = 2;
        List<String> result1 = topKFrequent(words1, k1);
        System.out.println(result1.toString());
    }

    private static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Set<String> setWord = new HashSet<>();
        TreeMap<String, Integer> hashMap = new TreeMap<>();

        for(String word : words) {
            boolean isAdded = !setWord.add(word);
            if (isAdded) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }

        List<Integer> frequency = new ArrayList<>(hashMap.values());
        frequency.sort(Collections.reverseOrder());
        System.out.println(frequency);

        for (int index = 0; index < k; index++) {
            Integer count = frequency.get(index);
            for (String word : hashMap.keySet()) {
                Integer freq = hashMap.get(word);
                if (freq.equals(count)) {
                    result.add(word);
                    hashMap.remove(word);
                    break;
                }
            }
        }


//        Collections.sort(result);
        return result;
    }
}
