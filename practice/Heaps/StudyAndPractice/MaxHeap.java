package Heaps.StudyAndPractice;

public class MaxHeap {
    private int [] heapArray;
    private int heapSize;
    private int maxHeapSize;

    public MaxHeap(int maxHeapSize){
        this.maxHeapSize = maxHeapSize;
        heapSize = 0;
        heapArray = new int[this.maxHeapSize];
    }

    private int parent(int pos) {return (pos-1)/2;}

    private int leftChild(int pos) {return 2*pos +1;}

    private int rightChild(int pos) {return 2*pos+ 2;}

    private boolean isLeafNode(int pos){
        if(pos> heapSize/2 && pos<=heapSize) return true;
        return false;
    }

    private void swap(int pos1, int pos2){
        int tmp;
        tmp = heapArray[pos1];
        heapArray[pos1] = heapArray[pos2];
        heapArray[pos2] = tmp;
    }

    private void maxHeapify(int pos){
        if (isLeafNode(pos)) return;
        
        int lChild = heapArray[leftChild(pos)];
        int rChild = heapArray[rightChild(pos)];
        int node = heapArray[pos];
        if(lChild>node || rChild>node){
            if(lChild>rChild){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else{
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void insert(int element){
        heapArray[heapSize] = element;
        int current = heapSize;
        while(parent(current)>-1 && heapArray[current]> heapArray[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
        heapSize++;
    }

    public int extractMax(){
        int popped = heapArray[0];
        heapArray[0] = heapArray[heapSize-1]; //GFG has it 1 indexed, but here we do 0m indexing.
        maxHeapify(0);
        heapSize--;
        return popped;
    }

    public void print() {
        for(int i=0;i<heapSize;i++) System.out.print(heapArray[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(20);

        heap.insert(5);
        heap.insert(6);
        //heap.print();
        heap.insert(10);
        heap.insert(3);
        heap.print();
        heap.extractMax();
        heap.print();
    }
}
