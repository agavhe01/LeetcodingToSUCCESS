  public static long candies(int n, List<Integer> arr) {
        List<Integer> candies = new ArrayList<Integer>();
        
        //initialize array
        for(int i = 0; i < arr.size(); i++){
            candies.add(0);    
        }
        
        candies.set(0, 1);
        
        for(int i = 1; i < arr.size(); i++){
            candies.set(i, 1);
            
            if (arr.get(i) > arr.get(i - 1)){
                candies.set(i, candies.get(i - 1) + 1);
            }
        }
            
        int maxVal = 0;
        for(int i = arr.size() - 1; i > 0; i--){
            if(arr.get(i) < arr.get(i - 1)){
                maxVal = Math.max(candies.get(i - 1), candies.get(i) + 1);
                candies.set(i - 1, maxVal);
            }
        }
            
        int sum = 0;
        for(int i = 0; i < candies.size(); i++){
            sum += candies.get(i);
        }
    return sum;
 
    }