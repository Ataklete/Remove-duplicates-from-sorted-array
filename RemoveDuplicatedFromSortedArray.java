public class RemoveDuplicatedFromSortedArray {
    // This program removes duplicates from a sorted array
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        // removeDuplicates() returns new size of array
        n = removeDuplicates1(arr, n);

        // Print updated array
        for (int i = 0; i < arr.length; i++) {
            if (i < n) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.print("null ");
            }
        }
    }

    static int removeDuplicates1(int arr[], int n) {
        if (n == 0 || n == 1)
            return n;

        int writeIndex = 1;

        for (int readIndex = 1; readIndex < n; readIndex++) {
            if (arr[readIndex] != arr[writeIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static int removeDuplicates(int arr[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // Create a temporary array to store unique elements
        int[] temp = new int[n];
        int j = 0;

        // Traverse the sorted array
        for (int i = 0; i < n - 1; i++) {
            // If current element is not equal to next element, store it
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }

        // Store the last element as it is always unique
        temp[j++] = arr[n - 1];

        // Copy the unique elements back to the original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }

        return j; // Return the new size of the array
    }
}
