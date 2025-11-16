
public class Member3_BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void runAndPrint(int size) {
        java.util.Random rnd = new java.util.Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(1_000_000);
        }
        int[] copy = java.util.Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        bubbleSort(copy);
        long end = System.nanoTime();

        double ms = (end - start) / 1_000_000.0;
        System.out.printf("%d | %.3f\n", size, ms);
    }

    public static void main(String[] args) {
        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        int[] sizes = { 100, 500, 1000 };
        for (int s : sizes) {
            runAndPrint(s);
        }
    }
}
