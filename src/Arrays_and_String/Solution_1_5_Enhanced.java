package Arrays_and_String;

public class Solution_1_5_Enhanced {
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
                return length1 > length2? oneStep(string1, string2)
                        : oneStep(string2, string1);
            } else {
                return oneStep(string1, string2);
            }

        }
    }


    private static boolean oneStep(String string1, String string2) {
        boolean oneChance = false;
        for(int i = 0, j = 0; i < string1.length() && j < string2.length();) {
            if(string1.charAt(i) == string2.charAt(j)) {
                i++;
                j++;
            } else {
                if(oneChance) return false;
                oneChance = true;
                i++;
                if(string1.length() == string2.length()) {
                    j++;
                }
            }
        }
        return true;
     }


    public static void main(String[] args) {
        System.out.println(oneAway("abaa", "abcd"));
        System.out.println();
    }
}
