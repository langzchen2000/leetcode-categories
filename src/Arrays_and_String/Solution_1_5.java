package Arrays_and_String;

public class Solution_1_5 {
    //char set?
    //spaces count?
    // characters appear as multiples of 2. At most one sigular character is allowed. Assume ASCII
    public static boolean oneAway(String string1, String string2){
        int length1 = string1.length();
        int length2 = string2.length();
        final int abs = Math.abs(length1 - length2);
        if(abs > 1 ) {
            return false;
        } else {
            if (abs == 1) {
                return length1 > length2? oneStepRemove(string1, string2)
                        : oneStepRemove(string2, string1);
            } else {
                return oneStepReplace(string1, string2);
            }

        }
    }

    private static boolean oneStepReplace(String string1, String string2) {
        boolean oneChance = false;
        for(int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) != string2.charAt(i)) {
                if(oneChance) return false;
                oneChance = true;
                i++;
            }
        }
        return true;
    }

    private static boolean oneStepRemove(String string1, String string2) {
        boolean oneChance = false;
        for(int i = 0, j = 0; i < string1.length() && j < string2.length();) {
            if(string1.charAt(i) == string2.charAt(j)) {
                i++;
                j++;
            } else {
                if(oneChance) return false;
                oneChance = true;
                i++;
            }
        }
        return true;
     }


    public static void main(String[] args) {
        System.out.println(oneAway("abca", "abcd"));
        System.out.println();
    }
}
