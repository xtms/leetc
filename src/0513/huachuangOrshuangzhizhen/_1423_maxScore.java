package huachuangOrshuangzhizhen;

// n - k 作为划窗
public class _1423_maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
        }

        int nkSum = 0;
        for (int i = 0; i < n - k; i++) {
            nkSum += cardPoints[i];
        }

        int min = nkSum;
        for(int j = n-k; j < n; j ++){
            nkSum += cardPoints[j] - cardPoints[j - n+k];
            min = Math.min(min, nkSum);
        }
        return total - min;
    }
}
