public class SequentialSearch2 {
    private static int sequentialSearch(int arr[], int target){
        int i = 0;
        while( i < arr.length){
            if (arr[i] == target){
                return i+1;
            }
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,10,2,6,3,7};
        int target = 6;
        System.out.println(sequentialSearch(arr, target));
    }    
}
