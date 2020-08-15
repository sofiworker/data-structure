package me.sofiworker.algorithm.kmp;

/**
 * @author sofiworker
 * @date 2020/8/14
 */
public class StrMatch {

    public static void main(String[] args) {
        System.out.println(violenceMatch("1111111daafafewt43vdfva", "1111111"));
        System.out.println(kmp("1111111daafafewt43vdfva", "1111111", kmpNext("1111111")));
    }

    /**
     * kmp 匹配
     * @param str1 长串
     * @param str2 子串
     * @param next kmp 数组
     * @return 是否匹配
     */
    private static boolean kmp(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return true;
            }
        }
        return false;
    }

    // 获取部分
    private static int[] kmpNext(String dest) {
        int[] result = new int[dest.length()];
        result[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = result[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            result[i] = j;
        }
        return result;
    }

    private static boolean violenceMatch(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (chars1[i] == chars2[j]) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == len2;
    }
}
