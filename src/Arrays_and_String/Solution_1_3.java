package Arrays_and_String;

public class Solution_1_3 {
    //what spaces are counted
    //should I ignore the spaces before the first alphabet?
    public static String URLify(String string, int length){
        char[] chars = string.toCharArray();
        int i = length - 1;
        while(chars[i] == ' ') {
            i--;
        }
        int j = length - 1;
        while(j >= 0) {
            if(chars[i] != ' ') {
                chars[j] = chars[i];
                j--;
                i--;
            } else {
                chars[j] = '0';
                chars[j - 1] = '2';
                chars[j - 2] = '%';
                j -= 3;
                i--;
            }
        }
        String s = new String(chars);
        return s;
    }

    public static void main(String[] args) {
        System.out.println(URLify("abc de  ", 8 ));
    }
}
