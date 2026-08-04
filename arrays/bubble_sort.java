class BubbleSort{
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped = false;
        for(int i = 0; i<n; i++){
            swapped = true;
            for(int j = 0; j<n-1; j++){ // optimization -> n-1-i (as the elements that are swapped are i and hence i elements are correctly placed so it can be ignored)
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        
    }
}