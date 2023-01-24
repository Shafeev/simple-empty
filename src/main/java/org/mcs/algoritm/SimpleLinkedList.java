package org.mcs.algoritm;

import java.util.Collections;
import java.util.LinkedList;

public class SimpleLinkedList {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory before" + usedMemoryBefore);
        // working code here
        LinkedList<String> linkedList = new LinkedList<>();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory increased:" + (usedMemoryAfter - usedMemoryBefore));
        System.out.println(linkedList);

        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("tree");
        linkedList.add("four");
        linkedList.add("five");

        LinkedList<String> linkedList2 = new LinkedList<>();

        linkedList2.add("one1");
        linkedList2.add("two1");
        linkedList2.add("tree1");
        linkedList2.add("four1");
        linkedList2.add("five1");

        LinkedList<String> linkedList3 = new LinkedList<>();
        linkedList3.addAll(linkedList);
        linkedList3.addAll(linkedList2);

        System.out.println(linkedList3);

        LinkedList[] arrayLinkedList = new LinkedList[3];
        arrayLinkedList[0] = linkedList;
        arrayLinkedList[1] = linkedList2;
        arrayLinkedList[2] = linkedList3;

        LinkedList<String> result = mergeKLists(arrayLinkedList);

        Collections.sort(result);
        System.out.println(result);
    }

    private static LinkedList mergeKLists(LinkedList[] lists) {
        LinkedList result = new LinkedList<>();

        for (LinkedList list : lists) {
            result.addAll(list);
        }
        return result;
    }

}
