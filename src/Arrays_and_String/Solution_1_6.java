package Arrays_and_String;

public class Solution_1_6 {
//O(n)
    public static String stringCompression(String string) {

        if(string == null || string.length() <= 2) return string;
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 1;
        int counter = 1;
        while(p2 < string.length()) {
            if(string.charAt(p1) == string.charAt(p2)) {
                counter++;

            } else {
                sb.append(string.charAt(p1));
                sb.append(counter);
                counter = 1;
            }
            if(p2 == string.length() - 1) {
                sb.append(string.charAt(p2));
                sb.append(counter);
            }
            p1++;
            p2++;
        }
        String returnString = sb.toString();
        return returnString.length() > string.length() ? string : returnString;

    }

    public static void main(String[] args) {
        String[] testSet = new String[]{null, "abc", "aabccd", "aaaaaaaaaaaaaaaa"};
        for(String s:testSet) {
            System.out.println(stringCompression(s));
        }
    }
}
