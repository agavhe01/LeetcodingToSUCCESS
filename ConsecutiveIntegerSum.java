class ConsecutiveIntegerSum {
    public int consecutiveNumbersSum(int n) {
        int ans=0;

        int N = n;
        
        for(int k=1;k*k<2*N;k++){
            
            if((N-k*(k-1)/2)%k==0) ans++;
        }
        return ans;
        
    }
}