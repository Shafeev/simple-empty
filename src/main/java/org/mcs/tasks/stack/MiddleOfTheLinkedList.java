package org.mcs.tasks.stack;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        middleNode(node);
    }

    private static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        list.add(head);
        while (head.next != null) {
            list.add(head.next);
            head = head.next;
        }

        int index = list.size() / 2;

        return (list.size() == 0 ? head : list.get(index));
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
