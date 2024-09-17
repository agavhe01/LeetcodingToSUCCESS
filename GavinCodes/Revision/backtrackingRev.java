public class backtrackingRev{

    public List<List<String>> result;

    public int[] arr;

    public backtrackingRev(int[] arr){
        this.arr = arr;
    }

    public allSubArraysCaller(){
        result = new ArrayList<>();

        allSubArrays(0, arr, new ArrayList<Integer>());
        return result;

    }

    public allSubArrays(int index, int[] arr, List<Integer> curr){
        
    }




    public static void main(String[] args){

    }
}