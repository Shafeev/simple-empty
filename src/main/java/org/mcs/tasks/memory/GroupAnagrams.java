package org.mcs.tasks.memory;

import java.util.*;

/**
 * Учитывая массив строк strs, сгруппируйте анаграммы вместе. Вы можете вернуть ответ в любом порядке.
 * <p>
 * Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы, обычно с
 * использованием всех исходных букв ровно один раз.
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
        String[] strs2 = {"", "b"};
        System.out.println(groupAnagrams(strs2));
        String[] strs3 = {"ac", "c"};
        System.out.println(groupAnagrams(strs3));
        String[] strs4 = {"ddddddddddg", "dgggggggggg"};
        System.out.println(groupAnagrams(strs4));
        String[] strs5 = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(groupAnagrams(strs5));
        String[] strs6 = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
        System.out.println(groupAnagrams(strs6));
        String[] strs7 = {"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"};
        System.out.println(groupAnagrams(strs7));
        String[] strs8 = {"ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo"};
        System.out.println(groupAnagrams(strs8));
        String[] strs9 = {"arc", "hag"};
        System.out.println(groupAnagrams(strs9));

        System.out.println(groupAnagrams2(strs));
        System.out.println(groupAnagrams2(strs2));
        System.out.println(groupAnagrams2(strs3));
        System.out.println(groupAnagrams2(strs4));
        System.out.println(groupAnagrams2(strs5));
        System.out.println(groupAnagrams2(strs6));
        System.out.println(groupAnagrams2(strs7));
        System.out.println(groupAnagrams2(strs8));
        System.out.println(groupAnagrams2(strs9));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Set<String> groups = new HashSet<>();

        for (int index = 0; index < strs.length; index++) {
            String word = strs[index];
            String variants = getCharaster(word);
            groups.add(variants);
        }


        for (String group : groups) {
            List<String> groupList = new ArrayList<>();
            for (int index = 0; index < strs.length; index++) {
                String text = strs[index];
                String variant = getCharaster(text);
                if (group.equals(variant)) {
                    groupList.add(text);
                }
            }
            if (!groupList.isEmpty()) {
                result.add(groupList);
            }

        }

        return result;
    }

    private static Set<String> getVariants(String word) {
        Set<String> result = new HashSet<>();

        if (word == null) {
            return null;
        } else if (word.length() == 0) {
            result.add("");
            return result;
        }

        char symbol = word.charAt(0);
        String changeWord = word.substring(1);
        Set<String> newWords = getVariants(changeWord);
        for (String text : newWords) {
            for (int index = 0; index <= text.length(); index++) {
                String changeText = getChangeText(text, symbol, index);
                result.add(changeText);
            }
        }
        return result;
    }

    private static String getChangeText(String text, char symbol, int index) {
        String leftText = text.substring(0, index);
        String rigthText = text.substring(index);
        return leftText + symbol + rigthText;
    }

    private static String getCharaster(String word) {
        List<String> result = new ArrayList<>();

        if (word == null) {
            return null;
        } else if (word.length() == 0) {
            return "";
        }

        for (int index = 0; index < word.length(); index++) {
            result.add(word.substring(index, index + 1));
        }

        Collections.sort(result);
        StringBuilder text = new StringBuilder();
        for (String s : result) {
            text.append(s);
        }
        return text.toString();
    }

    /**
     * мы присвоим каждой букве уникальное простое число, то произведение простых чисел букв в первой и второй строках
     * должно быть равным для анаграмм.
     */
    private static List<List<String>> groupAnagrams2(String[] strs) {

        Map<String, Integer> dictionary = getDictionary(strs);
        dictionary.put("", 0);

        Map<Double, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            double index = getNumber(word, dictionary);
            if (groups.containsKey(index)) {
                List<String> list = groups.get(index);
                list.add(word);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(word);
                groups.put(index, newList);
            }
        }

        return new ArrayList<>(groups.values());
    }

    private static Map<String, Integer> getDictionary(String[] strs) {
        Map<String, Integer> dictionary = new HashMap<>();
        Set<String> alhabetic = new HashSet<>();

        for (int indexWord = 0; indexWord < strs.length; indexWord++) {
            String word = strs[indexWord];
            for (int index = 0; index < word.length(); index++) {
                alhabetic.add(word.substring(index, index + 1));
            }
        }
        int[] simpleNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
                419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};
        int indexSymbol = 0;
        for (String s : alhabetic) {
            dictionary.put(s, simpleNumber[indexSymbol]);
            indexSymbol++;
        }

        return dictionary;
    }

    private static double getNumber(String word, Map<String, Integer> dictionary) {
        double result = 1;
        if (word.length() == 0) {
            result = 0;
            return result;
        }
        for (int index = 0; index < word.length(); index++) {
            int value = dictionary.get(word.substring(index, index + 1));
            result = result * value;
        }
        return result;
    }

    private static List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());

        return result;
    }
}
