package lc0304.suanfajichu.shuangzhizhen;

import java.util.ArrayList;
import java.util.List;

public class _986_intervalIntersection {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int fn = firstList.length;
        if (fn == 0) {
            return secondList;
        }
        int fm = firstList[0].length;
        int sn = secondList.length;
        if (sn == 0) {
            return firstList;
        }
        int sm = secondList[0].length;
        List<int[]> ansList = new ArrayList<>();
        int fleft = 0;
        int sleft = 0;
        while (fleft < fn && sleft < sn) {
            if (firstList[fleft][0] <= secondList[sleft][0]) {
                if ( firstList[fleft][1] >= secondList[sleft][0] && firstList[fleft][1] <= secondList[sleft][1] ) {
                    System.out.println(" 1  " +secondList[sleft][0]+" "+ firstList[fleft][1] );
                    ansList.add(new int[]{secondList[sleft][0], firstList[fleft][1]});
                    fleft++;
                } else if(secondList[sleft][1] <= firstList[fleft][1]){
                    System.out.println(" 2 " +secondList[sleft][0]+" "+ secondList[sleft][1]);
                    ansList.add(new int[]{secondList[sleft][0], secondList[sleft][1]});
                    sleft++;
                }
            }
            else  if(firstList[fleft][0] >= secondList[sleft][0]) {
                if (firstList[fleft][1] <= secondList[sleft][1]) {
                    System.out.println(" 3 " +firstList[fleft][0]+" "+ firstList[fleft][1]);
                    ansList.add(new int[]{firstList[fleft][0], firstList[fleft][1]});
                    fleft++;
                } else if(firstList[fleft][0] <= secondList[sleft][1]) {
                    System.out.println(" 4 " +firstList[fleft][0]+" "+ secondList[sleft][1]);
                    ansList.add(new int[]{firstList[fleft][0], secondList[sleft][1]});
                    sleft++;
                }
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }

    public static void main(String[] args) {
        int [][] first = {{0,2},{5,10},{13,23},{24,25}};
        int [][] second = {{1,5},{8,12},{15,24},{25,26}};
        int[][] ans = intervalIntersection(first, second);
        for(int [] an : ans){
            System.out.println(an[0] +" "+ an[1]);
        }
    }
}
