package org.mcs.tasks;

import java.util.*;

/**
 * Напишите функцию для поиска самой длинной общей префиксной строки среди массива строк.
 * <p>
 * Если общего префикса нет, возвращается пустая строка "".
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"wordd", "hddshdfkjswordsdfsd", "sddwordKLlj" };
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
        System.out.println("Prefix " + longestCommonPrefix3(strs));
    }

    private static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 0 : -1;
            }
        });
        if (strs[0].length() == 0) {
            return "";
        }
        System.out.println("Template " + strs[0]);
        List<String> result = new ArrayList<>();

        int index = 1;
        String template = strs[0];
        String prefix = template.substring(0, 1);
        while (index < template.length()) {
            boolean isExist = true;
            for (int i = 1; i < strs.length; i++) {
                String word = strs[i];
                if (!word.contains(prefix)) {
                    isExist = false;
                }
            }

            if (isExist) {
                prefix += template.substring(index, index + 1);
            } else {
                if (prefix.length() > 1) {
                    index--;
                    result.add(prefix.substring(0, prefix.length() - 1));
                }
                prefix = template.substring(index, index + 1);
            }
            index++;

            System.out.println("prefix " + prefix);
        }
        if (prefix.length() > 1) {
            result.add(prefix);
        }

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1 : 0;
            }
        });
        System.out.println("result " + result);
        return result.isEmpty() ? "" : result.get(0);
    }

    static String commonPrefix(String arr[], int n) {
        String prefix = arr[0];

        for (int i = 1; i <= n - 1; i++) {
            prefix = commonPrefixUtil(prefix, arr[i]);
        }
        return (prefix);
    }

    static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(),
                n2 = str2.length();

        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }

    private static String longestCommonPrefix2(String[] strs) {
        int n = strs.length;
        String ans = commonPrefix(strs, n);

        if (ans.length() > 0) {
            System.out.printf("The longest common prefix is - %s",  ans);
        } else {
            System.out.printf("There is no common prefix");
        }
        return ans;
    }

    private static String longestCommonPrefix3(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
            }
        }

        return prefix;
    }
}
