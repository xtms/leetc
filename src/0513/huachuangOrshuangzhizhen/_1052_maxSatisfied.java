package huachuangOrshuangzhizhen;

public class _1052_maxSatisfied {
    public static int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        int sumTotal = 0;
        int subTotal = 0;
        int isStatiALl = 0;
        for (int i = 0; i < customers.length; i++) { //计算总数： 所有总数，所有生气的人
            sumTotal += customers[i];
            if (grumpy[i] == 0) {
                isStatiALl += customers[i];
            }
        }
        if (minutes > customers.length) {
            return sumTotal;
        }
        int isStatiTotal = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0) {
                subTotal += customers[i];
            }
            isStatiTotal += customers[i];
        }

        int result = -subTotal + isStatiTotal;
        //System.out.println("isStatiAll："+ isStatiALl);  // 10
        //System.out.println("subTotal:"+subTotal);
        // System.out.println("result-->"+ result);
        for (int j = minutes; j < customers.length; j++) {
            isStatiTotal += customers[j] - customers[j - minutes];
            //System.out.println("isStatiTotal-->"+ isStatiTotal);
            if (grumpy[j] == 0) {
                subTotal += customers[j];
            }
            if (grumpy[j - minutes] == 0) {
                subTotal -= customers[j - minutes];
            }
            //System.out.println("sumTotal-->"+ subTotal);
            result = Math.max(result, -subTotal + isStatiTotal);
            //System.out.println("result after-->"+ result);
        }
        return isStatiALl + result;
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int isStatiALl = 0;
        for (int i = 0; i < customers.length; i++) { //计算总数： 所有总数，所有生气的人
            if (grumpy[i] == 0) {
                isStatiALl += customers[i];
            }
        }
        int subtotal = 0;
        for(int i = 0; i < minutes; i++){
            subtotal += customers[i] * grumpy[i]; // 生气后，不满意人数
        }

        int max = subtotal;
        for(int j = minutes; j < customers.length; j++){
            subtotal += customers[j] * grumpy[j] -  customers[j - minutes] * grumpy[j- minutes]; // 生气后，不满意人数在j分钟
            max = Math.max(max, subtotal); // 划窗内最大的不满意人数
        }
        return isStatiALl + max; //已经存在的最大满意人数，和填满的最大不满意人数，就是最后的值
    }

    public static void main(String[] args) {
        int [] customers = {1,0,1,2,1,1,7,5};
        int [] grumy = {0,1,0,1,0,1,0,1};
        int min = 3;
        System.out.println(maxSatisfied(customers, grumy, min));
    }
}

