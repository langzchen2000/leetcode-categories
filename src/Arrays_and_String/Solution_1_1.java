package Arrays_and_String;

public class Solution_1_1 {
//    Characters are in ASCII or Unicode.
    public static boolean isUnique(String string) {
        boolean[] hashSet = new boolean[128];
        for(int i = 0; i < string.length(); i++) {
            char theChar = string.charAt(i);
            if(!hashSet[theChar]) {
                hashSet[theChar] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcdee"));
    }
}
