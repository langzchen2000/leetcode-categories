package Arrays_and_String;

public class Solution_1_4 {
    //char set?
    //spaces count?
    // characters appear as multiples of 2. At most one sigular character is allowed. Assume ASCII
    public static boolean palindromePermutation(String string){
        if(string.length() == 0 || string == null || string.length() == 1) {
            return true;
        }
        int[] hashMap = new int[128];
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' ') continue;
            hashMap[string.charAt(i)] += 1;
        }
        int odd = 0;
        for(int i : hashMap) {
            if(odd > 1) {
                return false;
            }
            if(i%2 == 0) continue;
            if(i%2 == 1) odd += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromePermutation("taco bcat"));
        System.out.println(palindromePermutation("acca"));
    }
}
