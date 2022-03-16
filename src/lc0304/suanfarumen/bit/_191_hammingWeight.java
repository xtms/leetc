package lc0304.suanfarumen.bit;

public class _191_hammingWeight {
    public static  int hammingWeight(int n) {
        String ss = Long.toBinaryString(n);
        int [] result = new int [2];
        for(char ch : ss.toCharArray()){
            result[ch - '0']++;
        }
        return result[1];
    }

    public static int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) { // 判断1
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight1(1));
    }
}
