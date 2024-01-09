public class Searching {

    public static void main(String[] args) {

        int numbers[] = {1, 3, 8, 12, 21, 66, 71}; // re-structure this array before passing it down to binarySearch
        int target = 6; // change the target value if you feel like
        int result = binarySearch(numbers, target); // change the function if required
        if (result != -1)
            System.out.println("The target element: "+ target + " was found at: " + result); // if the element is present in the array
        else
            System.out.println("The target element: "+target+" was not found in the given array!"); // if the element is not present in the array

    }

    public static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2; // divide the array into 2 piece
            if (arr[mid] == target) {
                return mid + 1; // if the target element is present at the center
            } else if (arr[mid] > target) {
                right = mid - 1; // if the target value is less than middle value
            } else {
                left = mid + 1; // if the target value is greater than middle value
            }
        }
        return -1; // return -1 if the element is not found
    }

    public static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) { // traverse through the array to search for the element
            if (arr[i] == target) {
                return i + 1; // return the index of the element if found
            }
        }
        return -1; // return -1 if the element is not found
    }
}