package lc0304.suanfajichu.digui;

import java.util.ArrayList;
import java.util.List;

public class _17_letterCombinations {
    String[] letterMap = {
            " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return ans;
        }
        dfs(digits, "", 0);
        return ans;
    }


    public void dfs(String digits, String tmpStr, int index) {
        if (index == digits.length()) {
            ans.add(tmpStr);
            return;
        }

        char ch = digits.charAt(index);
        String letter = letterMap[ch - '0'];
        for (int i = 0; i < letter.length(); i++) {
            dfs(digits, tmpStr + letter.charAt(i), index + 1);
        }
    }
}
