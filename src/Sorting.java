public class Sorting {
    public static void main(String[] args) {
        int[] numbers = {88, 73, 31, 22, 11, 7, 1}; // change the array elements if required
        System.out.println("\nBefore Sorting the array elements are \n");
        display(numbers); // displaying the array elements before sorting
        mergeSort(numbers, 0, numbers.length - 1); // calling the sort function to sort the elements
        System.out.println("\nAfter Sorting the array elements are \n");
        display(numbers);// displaying the array elements after sorting
    }

    //    ---------------------------- Bubble Sort ----------------------------

    public static void bubbleSort(int arr[]) { // time complexity is n^2
        int temp; // temp variable to hold the variable
        for (int i = 0; i < arr.length; i++) { // position of i is always before j and hence length-1
            for (int j = 0; j < arr.length - i - 1; j++) {  // position of j is always ahead of i and hence length
                if (arr[j + 1] < arr[j]) { // if the jth position has lesser value than ith position then swap
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //    ---------------------------- Selection Sort ----------------------------

    public static void selectionSort(int arr[]) { // time complexity is n^2
        int temp, pivot; // need 2 temporary variable to perform swap and pivot
        for (int i = 0; i < arr.length - 1; i++) {
            pivot = i; // assign pivot index every loop
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pivot] > arr[j]) // if there's an element which is less than pivot element
                    pivot = j;
            }
            temp = arr[pivot]; // swap the pivot element with the selected index
            arr[pivot] = arr[i];
            arr[i] = temp;
        }
    }

    //    ---------------------------- Insertion Sort ----------------------------

    public static void insertionSort(int arr[]) {
        int j, key; // initialising the temp variables
        for (int i = 1; i < arr.length; i++) { // here, i is ahead of j
            key = arr[i]; // key is the value which we need to place in the sorted section of the array
            j = i - 1; // j is behind i
            while (j >= 0 && arr[j] > key) { // check condition if j>=0 and keep switching the values until jth value is greater than key value
                arr[j + 1] = arr[j]; // copying element
                j--; // moving left each step
            }
            arr[j + 1] = key; // placing the key at the right place once found
        }
    }

    //    ---------------------------- Quick Sort Sort ----------------------------

    public static void quickSort(int arr[], int l, int h) {
        if (l < h) { // check if both low and high are placed in the same index, base condition of recursion
            int parti = partition(arr, l, h); // run partition logic and get the breaking point
            quickSort(arr, l, parti - 1); // break the left side of the array
            quickSort(arr, parti + 1, h); // break the right side of the array
        }
    }

    public static int partition(int arr[], int l, int h) {
        int pivot = arr[h]; // pivot element
        int i = l - 1; // i starting a step behind the array

        for (int j = l; j < h; j++) { // j index moving from low to high
            if (arr[j] < pivot) { // move i if arr[j] < pivot
                i++;
                swap(arr, i, j); // swap i and j values
            }
        }
        swap(arr, i + 1, h); // swap i+1 and pivot so that pivot goes to it's right place
        return i + 1; // return break index
    }

    //    ---------------------------- Merge Sort ----------------------------

    public static void mergeSort(int[] arr, int l, int r) {
        int mid;  // to find the median
        if (l < r) {
            mid = (l + r) / 2; // find the middle index of the array
            mergeSort(arr, l, mid); // divide the left sub-array
            mergeSort(arr, mid + 1, r); // divide the right sub-array
            merge(arr, l, mid, r); // merge both the sub-array
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1)
            arr[k++] = L[i++];

        // Copy remaining elements of R[] if any
        while (j < n2)
            arr[k++] = R[j++];

    }

    //    ---------------------------- Common Functions ----------------------------

    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
