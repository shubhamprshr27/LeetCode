package StudyPlans.DS1.Day5;

public class BinarySearchMatrix {
    //Since every 2d matrix is easily converted to a one dimensional array, use that concept.
    public boolean binarySearch(int [][]matrix, int l, int r, int target, int cols){
        if(l>r) return false;
        int mid = l+(r-l)/2;
        if(target == matrix[mid/cols][mid%cols]) return true;
        else if( target > matrix[mid/cols][mid%cols]) return binarySearch(matrix, mid+1, r, target, cols);
        return binarySearch(matrix, l, mid-1, target, cols);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        return binarySearch(matrix, 0, cols*matrix.length-1, target, cols);
    }

    public static void main(String[] args) {
        int target = 3;
        int [][]matrix = {{1}};
        System.out.println(new BinarySearchMatrix().searchMatrix(matrix, target));
    }
}
