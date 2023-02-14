package org.mcs.tasks.binary;

public class AddBinary {

    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        System.out.println(addBinary(a, b));
    }


    private static String addBinary(String a, String b) {
        if (a == null || b == null) return "";
        int first = a.length() - 1;
        int second = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (first >= 0 || second >= 0) {
            int sum = carry;
            if (first >= 0) {
                sum += a.charAt(first) - '0';
                first--;
            }
            if (second >= 0) {
                sum += b.charAt(second) - '0';
                second--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            sb.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0)
            sb.append('1');

        sb.reverse();
        return String.valueOf(sb);
    }

    private static String addBinary2(String a, String b) {
        String result = "";
        int val1 = Integer.parseInt(a, 2);
        int val2 = Integer.parseInt(b, 2);
        int val3 = val1 + val2;
        System.out.println(Integer.toBinaryString(val3));
        return result;
    }
}
