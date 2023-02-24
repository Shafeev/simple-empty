package org.mcs.tasks.hashTable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char symbol = magazine.charAt(i);
            if (symbolMap.containsKey(symbol)) {
                int value = symbolMap.get(symbol);
                value++;
                symbolMap.put(symbol, value);
            } else {
                symbolMap.put(symbol, 1);
            }
        }
        boolean answer = true;
        for (int j = 0; j < ransomNote.length(); j++) {
            char s = ransomNote.charAt(j);
            if (symbolMap.containsKey(s)) {
        int value = symbolMap.get(s);
        if (value == 0) {
            answer = false;
            break;
        } else {
            value--;
            symbolMap.put(s, value);
        }
    } else {
        answer = false;
        break;
    }
}
        return answer;
                }
}
