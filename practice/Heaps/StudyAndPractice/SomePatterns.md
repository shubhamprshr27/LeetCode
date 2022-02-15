This post is to deep dive into one of the most fundamental data structures called Heap. The objective of this post is to understand the basics of Heap, time complexities, and identify patterns when to use Heap as a data structure.

Heap questions are one of the most common questions frequently asked in interviews.

The confidence in HEAP data structure is guranteed if you finish below mentioned 23 questions.

What is Heap?
=============

1.  It is mainly used to represent a priority queue.
2.  It is represented as a Binary Tree (a tree structure where a node of a tree has a maximum of two child nodes). Heaps are complete binary trees.
3.  A simple array can be used to represent a Heap where array indices refer to the node position in the tree.
4.  Parent and child nodes can be accessed with indices:
    *   A root node｜i = 0, the first item of the array
    *   A parent node｜parent(i) = (i-1)/ 2
    *   A left child node｜left(i) = 2i+1
    *   A right child node｜right(i)=2i+2
5.  Two type of Heaps — Min Heap, Max Heap  
    Min Heap — the parent node always has a smaller value than the child nodes.  
    Max Heap — the parent node is always larger than the child node value.
6.  Usually, when a type is not mentioned, it refers to the MinHeap. Python Heap has minHeap as default.
7.  In python, theheapqmodule provides the basic features for Heap data structure.
8.  minHeap are used in tasks related to scheduling or assignment. A more detailed explanation is under the Patterns section below.

Heap Operations --- Implemented via **PYTHON**
===============

The basic operations in Python heapq are:

**heapify**  
The heapify operation converts the iterable array heap into a tree structure w.r.t heap order.

**heappush**  
It inserts an element into the heap. Post insertion the heap order is adjusted to maintain the heap properties.

    import heapq as hq
    # Simple array is heap
    minHeap = []
    # Adding an element to the heap
    hq.heappush(minHeap, 5)
    

**heappop**  
This operation is to remove the element from the heap. By default it is minHeap, so this operation removes the min element from the minHeap. And for maxHeap, it is the maximum element. Post removal, heapify is called internally to maintain the heap order.

    import heapq as hq
    minHeap = [5, 6, 2]
    # this is done to convert iterable into a heap tree
    hq.heapify(minHeap) 
    # Getting top element from the heap
    value = hq.heappop(minHeap) # the value here is 2 as 2 is the minimum value. 
    

Other operations in heapq python module includes heappushpop ,heapreplace , nlargest , nsmallest .

A simple Python implementation of MIN HEAP
==========================================

    class MinHeap:
      """
      Min Heap Implementaion
      """
      
      def __init__(self, array):
        """Initialization method."""
          
        # Build heap. Below statement is to convert 
        # an array into heap order. This is similar to 
        # heapq.heapify
          
        self.heap = self.buildHeap(array)
    
      # TC O(N) | SC O(1) 
      def buildHeap(self, array):
        """Build heap from iterable"""
        
        firstParentIdx = (len(array)-2)//2
        for currentIdx in reversed(range(firstParentIdx + 1)):
          self.siftDown(currentIdx, len(array) - 1, array)
        return array
    
      # TC O(logN) | SC O(1) 
      def siftDown(self, currentIdx, endIdx, heap):
        """Sifting down operation moves the value successively
        down the tree if its childer has smaller value.
        This is done to maintain the heap order.
        """
        childOneIdx = (2*currentIdx) + 1
        while childOneIdx < len(heap):
          childTwoIdx = (2*currentIdx) + 2 if currentIdx*2+2 <= endIdx else -1
          if childTwoIdx != -1 and heap[childTwoIdx] < heap[childOneIdx]:
            idxToSwap = childTwoIdx
          else:
            idxToSwap = childOneIdx
          if heap[idxToSwap] < heap[currentIdx]:
            self.swap(currentIdx, idxToSwap, heap)
            currentIdx = idxToSwap
            childOneIdx = currentIdx * 2 +1
          else:
            break
    
      # TC O(logN) | SC O(1) 
      def siftUp(self, currentIdx, heap):
        """
        It is exact opposite of sift down. 
        """
        parent = (currentIdx-1)//2
        while currentIdx > 0 and heap[parent] > heap[currentIdx]:
          self.swap(parent, currentIdx, heap)
          currentIdx = parent
          parentIdx = (currentIdx-1)//2
    		
      # TC O(1) | SC O(1) 
      def peek(self):
        """Get the top value of the heap.
        It returns the smallest value in min heap.
        """
        return self.heap[0]
    
      # TC O(logN) | SC O(1) 
      def remove(self):
        """
        Removing an element from heap. 
        This is similar to heaq.heappop
        """
        self.swap(0, len(self.heap)-1, self.heap)
        valueToRemove = self.heap.pop()
        self.siftDown(0, len(self.heap)-1, self.heap)
        return valueToRemove
    
      # TC O(logN) | SC O(1) 
      def insert(self, value):
        """
        Inserting an element in the heap. 
        Similar to heappush operation. 
        """
        self.heap.append(value)
        self.siftUp(len(self.heap)-1, self.heap)
    
      def swap(self, i, j , heap):
        """Swap two elements in an array"""
        heap[i], heap[j] = heap[j], heap[i]
    

Problem Patterns where HEAP is used
===================================

Based on my understanding, different questions where HEAP is common data structure to use can be categorized in following 4 categories:

*   Top K Pattern
*   Merge K Sorted Pattern
*   Two Heaps Pattern
*   Minimum Number Pattern

All questions under one patterns has some similarities in terms of using HEAP as a data structure. Completing these questions would gurantee you mastery on the HEAP data structure. Below list includes some of the most common questions asked in most of the companies.

Top K Pattern
-------------

[LC #215](https://leetcode.com/problems/kth-largest-element-in-an-array/) - Kth largest number in an array  
[LC #973](https://leetcode.com/problems/k-closest-points-to-origin) - K closest points to origin  
[LC #347](https://leetcode.com/problems/top-k-frequent-elements/) - Top k frequent elements/numbers  
[LC #692](https://leetcode.com/problems/top-k-frequent-words) - Top k frequent words  
[LC #264](https://leetcode.com/problems/ugly-number-ii/) - Ugly Number II  
[LC #451](https://leetcode.com/problems/sort-characters-by-frequency/) - Frequency Sort  
[LC #703](https://leetcode.com/problems/kth-largest-element-in-a-stream/) - Kth largest number in a stream  
[LC #767](https://leetcode.com/problems/reorganize-string/) - Reorganize String  
[LC #358](https://leetcode.com/problems/rearrange-string-k-distance-apart) - Rearrange string K distance apart  
[LC #1439](https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/) - Kth smallest sum of a matrix with sorted rows

Merge K sorted pattern
----------------------

[LC #23](https://leetcode.com/problems/merge-k-sorted-lists) - Merge K sorted  
[LC #373](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/) - K pairs with the smallest sum  
[LC #378](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/) - K smallest numbers in M-sorted lists

Two Heaps Pattern
-----------------

[LC #295](https://leetcode.com/problems/find-median-from-data-stream) - Find median from a data stream  
[LC #480](https://leetcode.com/problems/sliding-window-median/) - Sliding window Median  
[LC #502](https://leetcode.com/problems/ipo/) - Maximize Capital/IPO

Minimum number Pattern
----------------------

[LC #1167](https://leetcode.com/problems/minimum-cost-to-connect-sticks/) - Minimum Cost to connect sticks/ropes  
[LC #253](https://leetcode.com/problems/meeting-rooms-ii) - Meeting Rooms II  
[LC #759](https://leetcode.com/problems/employee-free-time) - Employee free time  
[LC #857](https://leetcode.com/problems/minimum-cost-to-hire-k-workers/) - Minimumcost to hire K workers  
[LC #621](https://leetcode.com/problems/task-scheduler/) - Minimum number of CPU (Task scheduler)  
[LC #871](https://leetcode.com/problems/minimum-number-of-refueling-stops/) - Minimum number of Refueling stops

I'll be editing this post soon with more detailed explanation on each of the patterns. Till then keep leetcoding. Identify as many patterns and you would be able to solve pretty much every question.

Please don't forget to UPVOTE if you like the post :)