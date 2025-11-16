
public class Member1_LinearSearch {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
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
        int key = arr[size - 1]; // target present

        long start = System.nanoTime();
        int idx = linearSearch(arr, key);
        long end = System.nanoTime();

        double ms = (end - start) / 1_000_000.0;
        System.out.printf("%d | %.3f\n", size, ms);
    }

    public static void main(String[] args) {
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");
        int[] sizes = {100, 500, 1000};
        for (int s : sizes) {
            runAndPrint(s);
        }
    }
}
