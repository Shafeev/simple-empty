package org.mcs.tasks;

import java.util.Arrays;
import java.util.Random;

/**
 * Вам дан массив из k списков связанных списков, каждый связанный список отсортирован в порядке возрастания.
 * Объедините все связанные списки в один отсортированный связанный список и верните его.
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class SimpleMergedList {

    public static void main(String[] args) {
        ListNode[] arrayListNode = new ListNode[4];

        generateListNode(arrayListNode, 5);
        for (ListNode listNode : arrayListNode) {
            printListNode(listNode);
            System.out.println("");
        }
    }

    private static void generateListNode(ListNode[] arrayListNode, int count) {

        for (int index = 0; index < arrayListNode.length; index++) {
            int randomCount = new Random().nextInt(count);
            while (randomCount ==0) {
                randomCount = new Random().nextInt(count);
            }
            System.out.println("Random count " + randomCount);
            if (randomCount > 0) {
                ListNode node = new ListNode(0);

                for (int secondIndex = 1; secondIndex < randomCount; secondIndex++) {
                    addListNote(node, secondIndex);
                }
                arrayListNode[index] = node;
            }
        }
    }

    private static void addListNote(ListNode node, int index) {
        if (node.val < index && node.next != null) {
            addListNote(node.next, index);
        } else {
            node.next = new ListNode(index);
        }
    }

    private static void printListNode(ListNode node) {
        System.out.print(" " + node.val);
        if (node.next != null) {
            printListNode(node.next);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return new ListNode();
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
