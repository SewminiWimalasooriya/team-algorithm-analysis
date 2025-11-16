
public class Member4_QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;
        return i + 1;
    }

    public static void runAndPrint(int size) {
        java.util.Random rnd = new java.util.Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(1_000_000);
        }
        int[] copy = java.util.Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        quickSort(copy);
        long end = System.nanoTime();

        double ms = (end - start) / 1_000_000.0;
        System.out.printf("%d | %.3f\n", size, ms);
    }

    public static void main(String[] args) {
        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        int[] sizes = {100, 500, 1000};
        for (int s : sizes) {
            runAndPrint(s);
        }
    }
}
