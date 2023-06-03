package Arrays_and_String;

import java.util.ArrayList;
import java.util.List;

public class Solution_1_9 {
//O(n)
    public static boolean stringRotation(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s2);
        sb.append(s2);
        if(sb.toString().contains(s1)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
       System.out.println(stringRotation("waterbottle", "erbottlewat"));
    }
}
