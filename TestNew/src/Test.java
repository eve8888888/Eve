public class Test {
    public static void main(String[] args) {
        System.out.println(Solution.reverseString("hello"));
    }
}
class Solution {
    public static String reverseString(String s) {
        int i,j;
        char[] c = s.toCharArray();
        for(i = 0,j = s.length() - 1;i < s.length() / 2; i++,j--){
            char temp;
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return new String(c);
    }
}
