package org.mcs.tasks;


/**
 * Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
 * Цифры хранятся в обратном порядке, и каждый их узлов содержит одну цифру.
 * Сложите два числа и верните сумму в виде связанного списка.
 * <p>
 * Можно предположить, что эти два числа не содержат никаких ведущих нулей, кроме самого числа 0.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        int value = 128;
        String strValue = String.valueOf(value);
        System.out.println(strValue.toCharArray()[1]);
        System.out.println(strValue.toCharArray()[0]);
        System.out.println(value%10);
        System.out.println(value/=10);

        ListNode head = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode secondHead = new ListNode(9);
        ListNode secondNode2 = new ListNode(9);
        ListNode secondNode3 = new ListNode(9);
        ListNode secondNode4 = new ListNode(9);

        secondHead.next = secondNode2;
        secondNode2.next = secondNode3;
        secondNode3.next = secondNode4;

        printListNode(head);
        System.out.println("");
        printListNode(secondHead);
        System.out.println("");
        ListNode result = addTwoNumbers(head, secondHead);
        System.out.println("");
        printListNode(result);
    }

    private static ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode result = new ListNode();
        ListNode resultCopy = result;



        while (listNode1 != null || listNode2 != null) {
            int decimal = 0;
            int value = 0;
            if (listNode1 != null && listNode2 != null) {
                value = listNode1.val + listNode2.val + resultCopy.val;
            } else {
                if (listNode1 != null) {
                    value = listNode1.val + resultCopy.val;
                }
                if (listNode2 != null) {
                    value = listNode2.val + resultCopy.val;
                }
            }
            if (resultCopy.val > 0) {
                decimal = 0;
            }

            String strValue = String.valueOf(value);
            int intValue = value;
            if (strValue.length() > 1) {
                decimal = Character.getNumericValue(strValue.toCharArray()[0]);
                intValue = Character.getNumericValue(strValue.toCharArray()[1]);
            }
            resultCopy.val = intValue;

            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }

            if ((listNode1 != null && listNode2 != null) ) {
                resultCopy.next = new ListNode(decimal);
                resultCopy = resultCopy.next;

            } else if ((listNode1 != null || listNode2 != null)) {
                resultCopy.next = new ListNode(decimal);
                resultCopy = resultCopy.next;
            } else if (decimal > 0 ) {
                resultCopy.next = new ListNode(decimal);
                resultCopy = resultCopy.next;
            }

        }

        return result;
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

    private static void printListNode(ListNode node) {
        System.out.print(" " + node.val);
        if (node.next != null) {
            printListNode(node.next);
        }
    }
}
