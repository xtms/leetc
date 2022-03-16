package lc0304.suanfarumen.bit;

public class _231_isPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {


        if ( n > 0 ){
            String ff  = Long.toBinaryString(n);
            int [] result = new int [2];
            for(char ch : ff.toCharArray()){
                result[ch - '0']++;
            }
            if( result[1] == 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(14));
    }
}
