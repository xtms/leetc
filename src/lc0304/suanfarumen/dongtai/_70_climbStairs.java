package lc0304.suanfarumen.dongtai;

import java.util.Arrays;

public class _70_climbStairs {

    public int climbStairs(int n) {
        int [] mem = new int[n+1];
        Arrays.fill(mem, -1);
        return extracted(n, mem);
    }

    private int extracted(int n, int[] mem) {
        if (n == 1 ){
            return 1;
        }
        if(n == 2 ){
            return 2;
        }
        if(mem[n] > 0){
            return mem[n];
        }
        mem[n] =  extracted(n -1, mem) + extracted(n -2, mem);
        return mem[n];
    }
}

