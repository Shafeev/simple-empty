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
            System.out.println("not sorted ");
            printListNode(listNode);
            System.out.println("");
        }

        System.out.println("Kmeerged");
        ListNode result = mergeKLists(arrayListNode);

        printListNode(result);
    }

    private static void generateListNode(ListNode[] arrayListNode, int count) {

        for (int index = 0; index < arrayListNode.length; index++) {
            int randomCount = new Random().nextInt(count);
            while (randomCount == 0) {
                randomCount = new Random().nextInt(count);
            }
            System.out.println("Random count " + randomCount);
            if (randomCount > 0) {
                ListNode node = new ListNode(randomCount);

                for (int secondIndex = 1; secondIndex < randomCount; secondIndex++) {
                    int randomValue = new Random().nextInt(10);
                    addListNote(node, randomValue);
                }
                arrayListNode[index] = node;
            }
        }
    }

    private static void addListNote(ListNode node, int index) {
        if (node.next != null) {
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

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        for (int index = 0; index < lists.length; index++) {
            ListNode current = lists[index];
            ListNode nextNode;

            while (current != null) {
                nextNode = current.next;

                result = sortListHelper(result, current);
                current = nextNode;
            }
        }

        return result;
    }

    private static ListNode sortLinkedList(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        ListNode nextNode;

        while (current != null) {
            nextNode = current.next;

            result = sortListHelper(result, current);
            current = nextNode;
        }
        return current;
    }

    private static ListNode sortListHelper(ListNode head, ListNode newNode) {
        ListNode temp = new ListNode();
        ListNode current = temp;
        temp.next = head;

        while (current.next != null && current.next.val < newNode.val) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return temp.next;
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
