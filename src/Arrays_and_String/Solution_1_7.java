package Arrays_and_String;

public class Solution_1_7 {

    public static int[][] rotateMatrix(int[][] img){
        int N  = img[0].length;
        //L=4, N=4, 0 N=2, 1
        int i = 0;
        while(N - 2 * i >= 1) {
            for(int j = i; j < N - i - 1; j++) {
                int temp1 = img[i][j];
                int temp2 = img[j][N - 1 -i];
                int temp3 = img[N - 1 - i][N - 1 - j];
                img[i][j] = img[N - 1 - j][i];
                img[j][N - 1 -i] = temp1;
                img[N - 1 - i][N - 1 - j] = temp2;
                img[N - 1 - j][i] = temp3;
            }
            i++;
        }
        return img;
    }

    public static void main(String[] args) {
        int[][] testSet = new int[6][6];
        int number = 1;
        for(int i = 0; i < testSet.length; i++){
            for(int j = 0; j < testSet[0].length; j++) {
                testSet[i][j] = i + j < 10 ? i + j : 7;
            }
        }
        for(int i = 0; i < testSet.length; i++){
            for(int j = 0; j < testSet[0].length; j++) {
                System.out.print(testSet[i][j]);
            }
            System.out.println(' ');
        }
        rotateMatrix(testSet);

        System.out.println();
        System.out.println();
        for(int i = 0; i < testSet.length; i++){
            for(int j = 0; j < testSet[0].length; j++) {
                System.out.print(testSet[i][j]);
            }
            System.out.println(' ');
        }
    }
}
