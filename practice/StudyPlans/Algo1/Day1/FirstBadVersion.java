package StudyPlans.Algo1.Day1;

public class FirstBadVersion {

    public boolean isBadVersion(int n){return n>3;}
    
    public int binarySearch(int left, int right, int n){
        int mid =left+(right-left)/2;
        boolean resultMid = isBadVersion(mid);
        boolean prev = isBadVersion(mid-1);
        if(resultMid && !prev) return mid;
        if(resultMid) return binarySearch(left,mid-1,n);
        else return binarySearch(mid+1,right,n);
    }
    
    public int firstBadVersion(int n) {
        return binarySearch(0,n,n);
    }

    public static void main(String[] args) {
        FirstBadVersion f = new FirstBadVersion();
        System.out.println(f.firstBadVersion(5));
    }
}
