
public class Member2_BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == key) {
                return mid; 
            }else if (arr[mid] < key) {
                low = mid + 1; 
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void runAndPrint(int size) {
        java.util.Random rnd = new java.util.Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(1_000_000);
        }
        java.util.Arrays.sort(arr); // required: sort first
        int key = arr[size - 1]; // present

        long start = System.nanoTime();
        int idx = binarySearch(arr, key);
        long end = System.nanoTime();

        double ms = (end - start) / 1_000_000.0;
        System.out.printf("%d | %.3f\n", size, ms);
    }

    public static void main(String[] args) {
        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        int[] sizes = {100, 500, 1000};
        for (int s : sizes) {
            runAndPrint(s);
        }
    }
}
