package Recursion;

public class Recursion {

    // Factorial method
    public static int fact(int n){
        if (n < 0){
            return -1;
        }else if(n == 0){
            return 1;
        }
        return n * fact(n - 1);
    }

    /** Returns the sum of the first n integers of the given array.*/
    public static int linerSum(int[] data, int n){
        if (n == 0){
            return 0;
        }
        return linerSum(data, n-1) + data[n-1];
    }


    public static double power(double x, int n){
        if (n == 0)
            return 1;
        else
            return x * power(x , n-1);
    }

    //Returns the sum of subarray data[low] through data[high] inclusive.
    public static int binarySum(int[ ] data, int low, int high) {
        if (low > high) // zero elements in subarray
            return 0;
        else if (low == high) // one element in subarray
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }

    public static long fibonacciBad(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacciBad(n-2) + fibonacciBad(n-1);
    }

    public static long[ ] fibonacciGood(int n) {
        if (n <= 1) {
            long[ ] answer = {n, 0};
            return answer;
        } else {
            long[ ] temp = fibonacciGood(n - 1); // returns {Fn−1, Fn−2}
            long[ ] answer = {temp[0] + temp[1], temp[0]}; // we want {Fn, Fn−1}
            return answer;
        }
    }


    public static int binarySearchRecursion(int [] array, int target, int start , int end){
        int middle = (start + end)/2;
        if (end < start){
            return -1;
        }
        if (target == array[middle]){
            return middle;
        }else if (target < array[middle]){
            return binarySearchRecursion(array,target,start,middle-1);
        }else if (target > array[middle]){
            return binarySearchRecursion(array,target,middle+1,end);
        }
        return -1;
    }
    //Binary Search without Recursion
    public static int binarySearchIterative(int[ ] data, int target) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return mid;
            else if (target < data[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }


    public static void reverseArray(int[] array, int low, int high){
        if (low < high){
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            reverseArray(array,low + 1,high - 1);
        }
    }

    //without Recursion
    /** Reverses the contents of the given array. */
    public static void reverseIterative(int[ ] data) {
        int low = 0, high = data.length - 1;
        while (low < high) { // swap data[low] and data[high]
            int temp = data[low];
            data[low++] = data[high]; // post-increment of low
            data[high--] = temp; // post-decrement of high
        }
    }

    public static void main(String[] args) {

    }

}