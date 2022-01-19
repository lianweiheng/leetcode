package string;

/*
https://leetcode-cn.com/problems/check-if-a-parentheses-string-can-be-valid/submissions/
 */
public class ValidParenthesis {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (locked.charAt(i) == '0') {
                if (min == 0) min = 1;
                else min --;
                max ++;
            } else {
                if (s.charAt(i) == '(') {
                    min ++;
                    max ++;
                } else {
                    min --;
                    max --;
                }
                if (min < 0) min += 2;
                if (max < 0) return false;
            }
        }
        return min == 0;
    }
}
