package shuzuAndzifchuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_reverseWords {
    public static String reverseWords(String s) {
       s = s.trim();
       List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();
       for (String ii : list){
           if(!ii.trim().equals("") ) {
               stringBuilder.append(ii).append(" ");
           }
       }
       return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String name = "  hello   world  ";
        System.out.println(reverseWords(name));
    }
}
