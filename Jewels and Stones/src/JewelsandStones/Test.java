package JewelsandStones;

public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.numJewelsInStones("aA","aAAbbb"));
    }
}
class Solution {
    public static int numJewelsInStones(String J, String S) {
        int sum = 0;
        for(int i = 0; i<J.length(); i++){
            for(int j = 0; j<S.length(); j++){
                if(S.charAt(j) == J.charAt(i)){
                    sum++;
                }
            }
        }
        return sum;
    }
}
