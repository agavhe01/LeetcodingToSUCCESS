/*

480. Sliding Window Median

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.

*/

class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {

        List<Integer> theList = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            
            Integer num = Integer.valueOf(nums[i]);
            theList.add(num);
        }

        int n = theList.size();

        double[]returnList = new double[n];
        int pointer = 0;


        for(int i = k; i <= n; i++){
            double theVal = findMedian(theList.subList(pointer, i));
            returnList[pointer] = theVal;
            pointer++;
        }


        return returnList;


        
    }

    public double findMedian(List<Integer> list) {
        System.out.println(list);
        int n = list.size();
        if(n == 0) return 0;
        //if(n%2 == 1) return (Integer)list.get(n/2).doubleValue();
        if (n%2 == 1){
            Integer num = list.get(n/2);
            System.out.println(num.doubleValue());
            return num.doubleValue();
        }
        double num1 = (double)list.get(n/2);
        double num2 = (double)list.get(n/2 - 1);
        System.out.println(num1 + num2 / 2);
        return num1 + num2 / 2;

        //return (double)((list.get(n/2) + list.get(n/2 - 1)))/2;
        
    }
}