package Heaps.Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @param points
 * @param k
 * @return
 */
class Point {
    int[] point;
    int dist;
    Point(int [] point){
        dist = point[0]*point[0]+point[1]*point[1];
        this.point = point;
    }
}

/**
 * Can be solved using Binary Search as well.
 * Todo: Solve using binary search.
 */
public class KClosestPointsToOrigin {
    PriorityQueue<Point> pq;
    int [] distances;
    public int[][] kClosest(int[][] points, int k) {
        pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point p1,Point p2){
                if(p1.dist!=p2.dist) return (p1.dist-p2.dist);
                return 0;
            }
        });
        for(int i=0;i<points.length;i++){
            pq.add(new Point(points[i]));
        }
        int [][]ans = new int[k][];
        int ctr = 0;
        while(k-->0){
            ans[ctr] = pq.poll().point;
            ctr++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [][] m = {{3,3},{5,-1},{-2,4}};
        new KClosestPointsToOrigin().kClosest(m, 2);
    }
}

/**
 * Optimum approach: Using binary search
 * Runs in O(n) -> N+N/2+N/4+ ...... ~= 2*N
 * Brilliant solution
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Precompute the Euclidean distance for each point,
        // define the initial binary search range,
        // and create a reference list of point indices
        double[] distances = new double[points.length];
        double low = 0, high = 0;
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            distances[i] = euclideanDistance(points[i]);
            high = Math.max(high, distances[i]);
            remaining.add(i);
        }

        // Perform a binary search of the distances
        // to find the k closest points
        List<Integer> closest = new ArrayList<>();
        while (k > 0) {
            double mid = low + (high - low) / 2;
            List<List<Integer>> result = splitDistances(remaining, distances, mid);
            List<Integer> closer = result.get(0), farther = result.get(1);
            if (closer.size() > k) {
                // If more than k points are in the closer distances
                // then discard the farther points and continue
                remaining = closer;
                high = mid;
            } else {
                // Add the closer points to the answer array and keep
                // searching the farther distances for the remaining points
                k -= closer.size();
                closest.addAll(closer);
                remaining = farther;
                low = mid;
            }
        }
        
        // Return the k closest points using the reference indices
        k = closest.size();
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            answer[i] = points[closest.get(i)];
        }
        return answer;
    };
    
    private List<List<Integer>> splitDistances(List<Integer> remaining, double[] distances,
                                               double mid) {
        // Split the distances around the midpoint
        // and return them in separate lists
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> closer = new ArrayList<>();
        List<Integer> farther = new ArrayList<>();
        result.add(closer);
        result.add(farther);
        for (int point : remaining) {
            if (distances[point] <= mid) {
                closer.add(point);
            } else {
                farther.add(point);
            }
        }
        return result;
    }
    
    private double euclideanDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
