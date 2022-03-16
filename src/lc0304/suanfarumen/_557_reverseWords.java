package lc0304.suanfarumen;

public class _557_reverseWords {
    public String reverseWords(String s) {
        String [] subString = s.split(" ");
        StringBuilder ans  = new StringBuilder();
        for (int i = 0; i < subString.length; i++){
            StringBuilder stringBuilder = new StringBuilder(subString[i]);
            stringBuilder.reverse();
            ans.append(stringBuilder.toString());
            if(i != subString.length -1){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
