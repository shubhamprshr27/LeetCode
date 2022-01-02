package PairsOfSongs;

public class PairsOfSongs{

    public static int numPairsDivisibleBy60(int[] time) {
        int ans= 0;
        int[] modMap = new int[60];
        for(int i=0;i<time.length;i++){
            int mod = time[i]%60;
            modMap[mod]++;
        }
        for(int i=0;i<=30;i++){
            if(i==0 || i==30){
                //Need to select any 2 in these cases.
                ans = ans + (modMap[i]*(modMap[i]-1))/2;
            } else{
                ans = ans + (modMap[i]*(modMap[60-i]));
            }
        }
        //System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int [] time = {30,20,150,100,40};
        PairsOfSongs.numPairsDivisibleBy60(time);
    }
}