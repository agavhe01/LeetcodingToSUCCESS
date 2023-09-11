/*
 Leetocode: 295. Find Median from Data Stream

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

*/

class MedianDataStream {
     List<Integer> list;

    public MedianFinder() {
         this.list = new ArrayList<Integer>();
        
    }
    
    public void addNum(int num) {
        //list.add(num);
        //Collections.sort(list);
        if(list.size() == 0) list.add(0, num);  
        else{
            int i=0;
            while(list.get(i) <= num && i<list.size()-1) i++;
            //*****The reason why I didn't traversed till the last index was to escape from IndexOutOfBounds Error*****
            if(list.get(i) <= num) list.add(i+1, num);
            else list.add(i, num);
        }
        
    }
    
    public double findMedian() {
        int n = list.size();
        if(n == 0) return 0;
        if(n%2 == 1) return list.get(n/2);
        return (double)((list.get(n/2) + list.get(n/2 - 1)))/2;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */