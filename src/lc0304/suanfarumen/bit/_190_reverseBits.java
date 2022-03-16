package lc0304.suanfarumen.bit;

public class _190_reverseBits {

    public static  int reverseBits(int n) {
        String ss = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(ss);
        sb.reverse();
        int ans = Integer.parseUnsignedInt(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        reverseBits(1);
    }
}
