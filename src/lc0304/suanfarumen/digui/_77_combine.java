package lc0304.suanfarumen.digui;

import java.util.ArrayList;
import java.util.List;

public class _77_combine {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), ans, 1, n, k);
        return  ans;
    }

    public  static  void dfs(List<Integer> tmpList, List<List<Integer>> ans, int start, int end, int k){
        if(tmpList.size() == k){
            ans.add(new ArrayList<>(tmpList));
            return;
        }

        for(int i = start; i <= end - (k-tmpList.size()) +1 ; i++){
            tmpList.add(i);
            dfs(tmpList, ans, i+1, end, k);
            tmpList.remove(tmpList.size()  -1 );
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> ans = combine(n, k);
    }
}
