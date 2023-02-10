package org.mcs.tasks.queue;

import java.util.*;

/**
 * Получив строку s, содержащую только символы '(', ')', '{', '}', '[' и ']', определите, является ли входная строка допустимой.
 * <p>
 * Входная строка является допустимой, если:
 * <p>
 * Открытые скобки должны быть закрыты скобками того же типа.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждая закрытая скобка имеет соответствующую открытую скобку того же типа.
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s) + " == false");
        String s2 = "(){}}{";
        System.out.println(isValid(s2) + " == false");
        String s3 = "(){}{}";
        System.out.println(isValid(s3) + " == true");
        String s4 = "()a{}{a}";
        System.out.println(isValid(s4) + " == true");
        String s5 = "({{{{}}}))";
        System.out.println(isValid(s5) + " == false");
        String s6 = "()";
        System.out.println(isValid(s6) + " == true");
    }

    private static boolean isValid(String s) {
        boolean result = true;
        Map<String, String> queueMap = new HashMap<>();
        queueMap.put("}", "{");
        queueMap.put("]", "[");
        queueMap.put(")", "(");

        List<String> symbols = Arrays.asList("{", "}", "(", ")", "[", "]");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            String symbol = s.substring(i, i + 1);
            if (symbols.contains(symbol)) {
                if (queueMap.values().contains(symbol)) {
                    stack.add(symbol);
                } else if (queueMap.keySet().contains(symbol)) {
                    if (!stack.isEmpty()) {
                        String peek = stack.peek();
                        if (!queueMap.get(symbol).equals(peek)) {
                            result = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    } else {
                        result = false;
                        break;
                    }

                }

            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
}
