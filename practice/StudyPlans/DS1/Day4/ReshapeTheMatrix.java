package StudyPlans.DS1.Day4;

import java.util.Arrays;

public class ReshapeTheMatrix {

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length) return mat;
        int [] elements = new int[mat.length*mat[0].length];
        int ctr = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++) elements[ctr++]=mat[i][j];
        }
        int[][] ans=new int [r][c];
        for(int i=0;i<elements.length;i++) ans[i/c][i%c] = elements[i];
        return ans;
    }
    
    public static void main(String[] args) {
        int [][] mat = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 4, 1)));
    }
}
