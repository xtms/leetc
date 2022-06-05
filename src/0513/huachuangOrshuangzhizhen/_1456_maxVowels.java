package huachuangOrshuangzhizhen;

public class _1456_maxVowels {
    public int maxVowels(String s, int k) {
        int vole = 0;
        int max = 0;
        for(int i = 0; i < k; i++){
            vole += isVole(s.charAt(i));
        }
        max = vole;
        for(int j = k; j < s.length(); j++){
            vole += isVole(s.charAt(j)) - isVole(s.charAt(j - k));
            max = Math.max(max, vole);
        }
        return max;
    }

    private int isVole(char ch){
        return ch =='a' || ch =='i' ||ch =='o' ||ch =='u' ||ch =='e' ? 1 : 0;
    }

}
