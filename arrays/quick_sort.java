
class arrays {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = low + (high - low) / 2;
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < arr[pivot]);
            do {
                j--;
            } while (arr[j] > arr[pivot]);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        int p = partition(arr, low, high);
        quickSort(arr, low, p);
        quickSort(arr, p + 1, high);
    }

    public static void main(String[] args) {

    }
}
