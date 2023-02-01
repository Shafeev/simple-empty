package org.mcs.tasks.stack;

import java.util.*;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        //[3,2,0,-4]
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = null;


        System.out.println(hasCycle2(head));
    }

    private static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }

        return false;
    }

    private static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (first != second) {
            if (second == null || second.next == null) {
                return false;
            }
            first = first.next;
            second = second.next.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
