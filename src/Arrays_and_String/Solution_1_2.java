package Arrays_and_String;

import java.util.concurrent.ScheduledExecutorService;

public class Solution_1_2 {
    //should check character set. Assume ASCII
    public static boolean checkPermutation(String string1, String string2){
        if(string1.length() != string2.length()) return false;
        int[] hashMap = new int[128];
        for(int i = 0 ; i < string1.length(); i++) {
            hashMap[string1.charAt(i)]++;
            hashMap[string2.charAt(i)]--;
        }
        for(int value: hashMap) {
            if(value != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("abcde", "edcba"));
    }
}
