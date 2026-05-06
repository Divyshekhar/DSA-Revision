
class strings {
    private void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        int n = arr.length;
        reverse(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            StringBuilder word = new StringBuilder();
            while (i < n && arr[i] != ' ') {
                word.append(arr[i]);
                i++;
            }
            word.reverse();
            if (word.length() > 0) {
                ans.append(" ").append(word);
            }
        }
        return ans.toString().trim();

    }

    public static void main(String[] args) {

    }
}
