package lc0304.suanfajichu.shuangzhizhen;

import java.util.Objects;
import java.util.Stack;

public class _844_backspaceCompare {
    public static boolean backspaceCompare1(String s, String t) {
        return Objects.equals(covertString(s) , covertString(t));
    }

    public static boolean backspaceCompare(String s, String t) {
        return Objects.equals(covertString(s) , covertString(t));
    }

    static  String covertString(String s){
        Stack<Character> stack = new Stack<>();
        char [] chars = s.toCharArray();
        for(char ch : chars) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String ss = "ab#c";
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
}
