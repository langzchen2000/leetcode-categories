package Arrays_and_String;

import java.util.*;

import static Arrays_and_String.Solution_1_6.stringCompression;

public class Solution_1_8 {
//O(n)
    public static int[][] zeroMatrix(int[][] matrix) {
        List<Integer>  zeroRow = new ArrayList<>();
        List<Integer> zeroColumn = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroColumn.add(j);
                }
            }
        }
        for(int i : zeroRow) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for(int j : zeroColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] testSet = new int[6][6];
        int number = 1;
        for(int i = 0; i < testSet.length; i++){
            for(int j = 0; j < testSet[0].length; j++) {
                testSet[i][j] = i + j < 10 ? i + j : 0;
            }
        }
        zeroMatrix(testSet);
        for(int i = 0; i < testSet.length; i++){
            for(int j = 0; j < testSet[0].length; j++) {
                System.out.print(testSet[i][j]);
            }
            System.out.println();
        }
    }
}
