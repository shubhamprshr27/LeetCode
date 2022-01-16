package Weekly160122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMovesToTarget {

    public static int minMoves(int target, int maxDoubles) {
        if(maxDoubles==0) return target-1;
        int ctr=maxDoubles;
        int targetCopy=target;
        List<Integer> doublePts=new ArrayList<>();
        while(ctr>0 && targetCopy>1){
            targetCopy=targetCopy/2;
            ctr--;
            doublePts.add(targetCopy);
        }
        Collections.reverse(doublePts);
        int init=1;
        int moves=0;
        //Will double at every point as per array.
        for(int i=0;i<doublePts.size();i++){
            moves=moves+(doublePts.get(i)-init)+1;
            init=doublePts.get(i)*2;
        }
        return moves+(target-init);
    }
    
    public static void main(String[] args) {
        int target = 4, maxDoubles=2;
        System.out.println(minMoves(target, maxDoubles));
    }
}
