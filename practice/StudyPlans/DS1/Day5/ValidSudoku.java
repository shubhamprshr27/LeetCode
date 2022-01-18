package StudyPlans.DS1.Day5;

import java.util.Arrays;

public class ValidSudoku {

    public boolean checkForDot(char c){
        return c!='.';
    }

    //checks for any invalid box.
    public boolean checkEachBox(char[][] board, int l, int r){
        int [] map = new int [9];
        if(checkForDot(board[l][r])) map[board[l][r]-'0'-1]++;
        for(int i=1;i<3;i++){
            if(checkForDot(board[l+i][r])) map[board[l+i][r]-'0'-1]++;
            if(checkForDot(board[l][r+i])) map[board[l][r+i]-'0'-1]++;
            if(checkForDot(board[l+i][r+i])) map[board[l+i][r+i]-'0'-1]++;
        }
        if(checkForDot(board[l+1][r+2])) map[board[l+1][r+2]-'0'-1]++;
        if(checkForDot(board[l+2][r+1])) map[board[l+2][r+1]-'0'-1]++;
        for(int i=0;i<9;i++){
            if(map[i]>1) return false;
        }
        return true;
    }

    public boolean checkEachLine(char[][] board, int l, int r){
        int []map1 = new int[9]; //horizontal traversal
        int [] map2 = new int[9]; //vertical traversal
        if(checkForDot(board[l][r])){
            map1[board[l][r]-'0'-1]++;
            map2[board[l][r]-'0'-1]++;
        }
        for(int i=1;i<9;i++){
            if(r+i<9 && checkForDot(board[l][r+i])) map1[board[l][r+i]-'0'-1]++;
            if(r-i>-1 && checkForDot(board[l][r-i])) map1[board[l][r-i]-'0'-1]++;
            if(l+i<9 && checkForDot(board[l+i][r])) map2[board[l+i][r]-'0'-1]++;
            if(l-i>-1 && checkForDot(board[l-i][r])) map2[board[l-i][r]-'0'-1]++;
        }
        for(int i=0;i<9;i++){
            if(map1[i]>1||map2[i]>1) return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!checkEachBox(board, i, j)) return false;
            }
        }
        for(int i=0;i<9;i++){
            if(!checkEachLine(board, i, i)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        char [][] board = 
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        ValidSudoku validSudoku = new ValidSudoku();
        System.out.println(validSudoku.isValidSudoku(board));
    }
}
