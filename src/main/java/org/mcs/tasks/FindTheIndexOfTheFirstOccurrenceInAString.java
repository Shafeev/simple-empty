package org.mcs.tasks;

/**
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 *
 * Input: haystack = "sadbutsad", haystack = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (haystack.isEmpty()) {
            return -1;
        }
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }

        return -1;
    }
}
