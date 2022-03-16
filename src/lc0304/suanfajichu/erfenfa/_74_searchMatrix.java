package lc0304.suanfajichu.erfenfa;

import java.util.Arrays;

public class _74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int  [] mav : matrix){
           if(Arrays.binarySearch(mav, target) > 0) {
               return true;
           }
        }
        return false;
    }
}
