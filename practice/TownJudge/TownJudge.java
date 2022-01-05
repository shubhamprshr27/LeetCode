package TownJudge;

import java.util.Arrays;

public class TownJudge {

    public static int findJudge(int n, int[][] trust) {
        int [] mostVotes = new int[n];
        for(int i=0;i<trust.length;i++){
            mostVotes[trust[i][1]-1]++;
            mostVotes[trust[i][0]-1]--;
        }
        for(int i=1;i<=n;i++){
            if (mostVotes[i-1]==n-1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int [][] votes= {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(n, votes));
    }
}
