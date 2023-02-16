package org.mcs.tasks.palindromic;

/**
 * Учитывая строку s, верните самую длинную палиндромную подстроку из s.
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        String s1 = "cbbd";
        System.out.println(longestPalindrome(s1));
        String s2 = "kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd";
        System.out.println(longestPalindrome2(s2));
    }

    private static String longestPalindrome(String s) {

        int n = s.length();
        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int flag = 1;
                System.out.println("k = (j - i + 1)/2 = " + "(" + j + "-" + i + " + 1)/2 =" + (j - i + 1) / 2);
                for (int k = 0; k < (j - i + 1) / 2; k++) {
                    System.out.println(i + " + " + k + " != " + j + " - " + k);
                    System.out.println(s.charAt(i + k) + " != " + s.charAt(j - k));
                    if (s.charAt(i + k) != s.charAt(j - k)) {
                        flag = 0;
                    }
                }

                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static String longestPalindrome2(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len)
                        && (len < 2 || dp[i + 1][i + len - 1]);
                if (dp[i][i + len] && len > end - start) {
                    start = i;
                    end = i + len;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
