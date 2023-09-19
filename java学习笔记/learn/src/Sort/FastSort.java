package Sort;

public class FastSort {
    public static void main(String[] args) {
        int[] arr = {3,5,1,8,52,15,7};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void quickSort(int[] arr, int i, int j){
        if(i >= j)
            return;
        int baseNum = arr[i];
        int start = i, end = j;
        while(start != end){
            while(arr[start] <= baseNum && start < end)
                start++;
            while (arr[end] >= baseNum && end > start)
                end--;
            if(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(arr[i] > arr[start]){
            arr[i] = arr[start];
            arr[start] = baseNum;
        }
        quickSort(arr, i, start-1);
        quickSort(arr, start+1, j);
    }
}
