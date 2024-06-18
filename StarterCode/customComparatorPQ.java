Comparator<Map.Entry<Integer, Integer>> customComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> s1, Map.Entry<Integer, Integer> s2) {
                return s1.getValue() - s2.getValue();
            }
        };

PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(customComparator);


Comparator<String> customStr = new Comparator<String>(){
    @Override
    public int compare(String s1, String s2){
        return s1.length - s2.length();
    }
};

PriorityQueue<String> pq = new PriorityQueue<>(customStr);




// CONVERT List to []

  return res.stream().mapToInt(Integer::intValue).toArray();

  result.stream().mapToInt(Integer::intValue).toArray();