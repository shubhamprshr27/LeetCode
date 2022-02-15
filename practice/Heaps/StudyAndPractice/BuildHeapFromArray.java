package Heaps.StudyAndPractice;

public class BuildHeapFromArray {

    public static void heapify(int [] arr,int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<arr.length && arr[l]>arr[largest]) largest = l;
        if(r<arr.length && arr[r]>arr[largest]) largest = r;

        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest);
        }
    }

    public static void heapify(int arr[]){
        int start = (arr.length/2) -1;

        for(int i=start;i>-1;i--) heapify(arr,i);
    }

    static void print(int arr[]){
        for(int i:arr) System.out.print(i+" ");
        System.out.println();
    }   
    
    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17} ; 
        heapify(arr);
        print(arr);
    }
}
