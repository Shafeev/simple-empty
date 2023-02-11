package org.mcs.tasks.sort;

import java.util.*;

/**
 * Учитывая массив интервалов, где intervals[i] = [starti, endi], объединить все пересекающиеся интервалы и
 * вернуть массив непересекающихся интервалов, которые покрывают все интервалы на входе.
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3},
                {2, 6},
                {8, 10},
                {15, 18}};
        int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
        int[][] intervals3 = new int[][]{{1, 4}, {1, 4}};
        int[][] intervals4 = new int[][]{{2, 4}, {0, 1}};
        int[][] intervals5 = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals6 = new int[][]{{1,4},{5,6}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge(intervals2)));
        System.out.println(Arrays.deepToString(merge(intervals3)));
        System.out.println(Arrays.deepToString(merge(intervals4)));
        System.out.println(Arrays.deepToString(merge(intervals5)));
        System.out.println(Arrays.deepToString(merge(intervals6)));
    }

    private static int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[0] - b[0];
            }
            return a[0] - b[0];
        });


        int index = 0;
        var start = intervals[index][0];
        var end = intervals[index][1];
        while (index < intervals.length) {
            int eachStart = intervals[index][0];
            int eachEnd = intervals[index][1];
            if (eachStart <= end || (end+1) == eachStart) {
                end = Math.max(eachEnd, end);
                start = Math.min(eachStart, start);
            } else {
                result.add(Arrays.asList(start, end));
                start = eachStart;
                end = eachEnd;
            }

            index++;
        }
        result.add(Arrays.asList(start, end));
        return getInts(result);
    }

    private static int[][] getInts(List<List<Integer>> result) {
        int[][] newInterval = new int[result.size()][2];
        int index = 0;
        for (List<Integer> interval1 : result) {
            newInterval[index][0] = interval1.get(0);
            newInterval[index][1] = interval1.get(1);
            index++;
        }
        return newInterval;
    }

}
