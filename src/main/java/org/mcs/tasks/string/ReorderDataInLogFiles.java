package org.mcs.tasks.string;

import java.util.*;

/**
 * Вам дан массив журналов. Каждый журнал представляет собой строку слов, разделенных пробелами,
 * где первое слово - это идентификатор.
 *
 * Существует два типа журналов:
 *
 * Буквенные записи: Все слова (кроме идентификатора) состоят из строчных английских букв.
 * Цифровые журналы: Все слова (кроме идентификатора) состоят из цифр.
 * Упорядочите эти журналы таким образом:
 *
 * Буквенные записи идут раньше всех цифровых записей.
 * Буквенные журналы сортируются лексикографически по их содержанию. Если их содержимое одинаково, то отсортируйте их
 * лексикографически по их идентификаторам.
 * Цифровые журналы сохраняют свой относительный порядок.
 * Возвращает окончательный порядок журналов.
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 *
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 */
public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs2 = {"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));
        System.out.println(Arrays.toString(reorderLogFiles2(logs)));
        System.out.println(Arrays.toString(reorderLogFiles(logs2)));
        System.out.println(Arrays.toString(reorderLogFiles2(logs2)));
        //["let3 art zero","let1 art zero can","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

        System.out.println(Arrays.toString(reorderLogFiles3(logs2)));
        System.out.println(Arrays.toString(reorderLogFiles4(logs2)));
    }

    private static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;

        int len = logs.length;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
        Collections.sort(letterList, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);
                }
            }
            return s1[0].compareTo(s2[0]);
        });

        int count =0;

        while(count < letterList.size()) {
            logs[count]= letterList.get(count);
            count++;
        }

        int i=0;

        while(i < digitList.size()) {
            logs[count] = digitList.get(i);
            count++;
            i++;
        }

        return logs;
    }

    private static String[] reorderLogFiles2(String[] logs) {
        if (logs == null || logs.length == 0) {
            return logs;
        }

        List<String> stringList = new ArrayList<>();
        List<String> numbersList = new ArrayList<>();

        for(String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                numbersList.add(log);
            } else {
                stringList.add(log);
            }
        }

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");

                int len1 = s1.length;
                int len2 = s2.length;

                for (int i = 1; i< Math.min(len1, len2); i++) {
                    if (!s1[i].equals(s2[i])) {
                        return s1[i].compareTo(s2[i]);
                    }
                }

                return s1[0].compareTo(s2[0]);
            }
        });

        int count = 0;

        while(count < stringList.size()) {
            logs[count]= stringList.get(count);
            count++;
        }

        int i=0;

        while(i < numbersList.size()) {
            logs[count] = numbersList.get(i);
            count++;
            i++;
        }

        return logs;
    }

    private static String[] reorderLogFiles3(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int identA = a.indexOf(" ") + 1;
            int identB = b.indexOf(" ") + 1;

            boolean isLetterA = Character.isLetter(a.charAt(identA));
            boolean isLetterB = Character.isLetter(b.charAt(identB));

            if (isLetterA && isLetterB) {
                int compare = a.substring(identA).compareTo(b.substring(identB));

                if (compare != 0) return compare;
                return a.compareTo(b);
            } else if (isLetterA) {
                return -1;
            } else if (isLetterB) {
                return 1;
            } else return 0;
        });

        return logs;
    }

    private static String[] reorderLogFiles4(String[] logs) {
        int size = logs.length;

        List<String> strLogs = new ArrayList<>();
        List<String> intLogs = new ArrayList<>();

        for(String log : logs) {
            int spaceInd = log.indexOf(' ');
            if(log.charAt(spaceInd + 1) - 'a' >= 0) {
                strLogs.add(log);
            }else {
                intLogs.add(log);
            }
        }

        strLogs.sort((s1, s2) -> {
            String s1Content = s1.substring(s1.indexOf(' ') + 1);
            String s2Content = s2.substring(s2.indexOf(' ') + 1);

            int compareContent = s1Content.compareTo(s2Content);
            if(compareContent == 0) {
                return s1.compareTo(s2);
            }

            return compareContent;
        });
        strLogs.addAll(intLogs);
        String[] orderedLogs = new String[size];
        for(int i = 0; i < size; i++) {
            orderedLogs[i] = strLogs.get(i);
        }

        return orderedLogs;
    }
}
