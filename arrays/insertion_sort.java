class InsertionSort{
    public void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i<n; i++){
            int element = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > element){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
    }
    public static void main(String[] args) {
        
    }
}