package backtrack;


import java.util.ArrayList;
import java.util.List;

public class GenerateBrackets {

    List<String> generateBrackets(int n) {
        List<String> ans = new ArrayList();
        backtrack(n, 0, 0, "", ans);
        return ans;
    }

    void backtrack(int n, int l, int r, String pre, List<String> ans) {
        if (l > n) return;
        String newPre;
        if (l == r) {
            if (l == n)  {
                ans.add(pre);
                return;
            }
            newPre = pre + "(";
            backtrack(n, l + 1, r, newPre, ans);
        } else {
            newPre = pre + "(";
            backtrack(n, l + 1, r, newPre, ans);
            newPre = pre + ")";
            backtrack(n, l, r + 1, newPre, ans);
        }
    }

    public static void main(String[] args) {
        List<String> ans = new GenerateBrackets().generateBrackets(5);
        for (String str: ans) System.out.println(str);
    }
}
