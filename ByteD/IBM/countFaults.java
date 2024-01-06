public static int countFaults(int n, List<String> logs) {
    // Write your code here
    
        Map<String, Integer> mp = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            String key = "s" + String.valueOf(i);
            //System.out.println(key);
            mp.put(key, 0);
        }
        
        int result = 0;
        
        for(String log:logs){
            String[] parts = log.split(" ");
            String serverId = parts[0];
            String status = parts[1];
            
            //System.out.println("Server:" + serverId + " Status:" + status);

            if(status.equals("success")){ 
                 mp.put(serverId, 0);
            }
            
            
            
            if(status.equals("error")){ 
                System.out.println("Server:" + serverId + " Status:" + status);
                Integer oldCount = mp.getOrDefault(serverId, 0);
                System.out.println("Old Count: " + oldCount);
                mp.put(serverId, oldCount + 1);
            }       
        }
        
       
        
        for(String key : mp.keySet()){
            Integer count = mp.getOrDefault(key, 0);
            if (count == 3){ result++;  }
        }
        
        return result;

    } // end funciton