package lc0304.suanfajinjie.bfs_dfs;

import java.util.*;

public class _752_openlocks {
    public int openLock(String[] deadends, String target) {
        int ans = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> deadList = new ArrayList<String>(Arrays.asList(deadends));
        queue.offer("0000");
        visited.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currStr = queue.poll();
                if (deadList.contains(currStr)) {
                    continue;
                }
                if (target.equals(currStr)) {
                    return ans;
                }
                for (int j = 0; j < currStr.length(); j++) {
                    String plusStr = plusOne(currStr, j);
                    if (!visited.contains(plusStr)) {
                        queue.add(plusStr);
                        visited.add(plusStr);
                    }
                    String minStr = minusOne(currStr, j);
                    if (!visited.contains(minStr)) {
                        queue.add(minStr);
                        visited.add(minStr);
                    }
                }
            }
        }

        return -1;
    }

    String plusOne(String ccc, int j){
        char[] chars = ccc.toCharArray();
        if(chars[j] == '9'){
            chars[j] = '0';
        } else {
            chars[j] +=1;
        }
        return String.valueOf(chars);
    }

    String minusOne(String ccc, int j){
        char[] chars = ccc.toCharArray();
        if(chars[j] == '0'){
            chars[j] = '9';
        } else {
            chars[j] -=1;
        }
        return String.valueOf(chars);
    }
}
