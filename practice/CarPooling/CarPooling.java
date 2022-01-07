package CarPooling;

import java.util.Arrays;

public class CarPooling {

    //My Solution -> can be optimized further. 0(nlogn)
    public static boolean carPooling(int[][] trips, int capacity) {
        int totalPassengers = 0;
        int [][] departures = trips.clone();
        Arrays.sort(trips,(a,b) -> a[1]-b[1]);
        Arrays.sort(departures,(a,b) -> a[2]-b[2]);
        int n = trips.length;
        int a_i=0; int d_i=0;
        while(a_i<n && d_i<n){
            totalPassengers = totalPassengers+trips[a_i][0];
            while(departures[d_i][2]<=trips[a_i][1]){
                totalPassengers = totalPassengers-departures[d_i][0];
                d_i++;
            }
            if(totalPassengers>capacity) return false;
            a_i++;
        }
        return true;   
    }

    //O(n) solution
    private static boolean carPoolingO_n(int[][] trips, int capacity) {
        int totalTrip[] = new int [1001]; 
        for ( int trip[]: trips){
            totalTrip[trip[1]]+=trip[0];
            totalTrip[trip[2]]-=trip[0];
        }
        int totalPassengers = 0;
        for(int i=0;i<1001;i++){
            totalPassengers+=totalTrip[i];
            if(totalPassengers>capacity) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips={{2,1,5},{3,3,7}};
        System.out.println(carPoolingO_n(trips, 4));
    }
}