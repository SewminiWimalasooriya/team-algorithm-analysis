
public class TeamRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        String[] algNames = {"Linear Search", "Binary Search", "Bubble Sort", "Quick Sort"};

// results[algIndex][sizeIndex]
        double[][] results = new double[algNames.length][sizes.length];

        for (int si = 0; si < sizes.length; si++) {
            int size = sizes[si];
            java.util.Random rnd = new java.util.Random(42 + size); // reproducible per size
            int[] base = new int[size];
            for (int i = 0; i < size; i++) {
                base[i] = rnd.nextInt(1_000_000);
            }

// Linear Search: search for last element (present)
            int[] arrForLinear = java.util.Arrays.copyOf(base, base.length);
            int keyLinear = arrForLinear[size - 1];
            long t0 = System.nanoTime();
            Member1_LinearSearch.linearSearch(arrForLinear, keyLinear);
            long t1 = System.nanoTime();
            results[0][si] = (t1 - t0) / 1_000_000.0;

// Binary Search: sort first, then search for last element of the original base
            int[] arrForBinary = java.util.Arrays.copyOf(base, base.length);
            java.util.Arrays.sort(arrForBinary);
            int keyBinary = java.util.Arrays.copyOf(base, base.length)[size - 1];
            long t2 = System.nanoTime();
            Member2_BinarySearch.binarySearch(arrForBinary, keyBinary);
            long t3 = System.nanoTime();
            results[1][si] = (t3 - t2) / 1_000_000.0;

// Bubble Sort: sort a copy
            int[] arrForBubble = java.util.Arrays.copyOf(base, base.length);
            long t4 = System.nanoTime();
            Member3_BubbleSort.bubbleSort(arrForBubble);
            long t5 = System.nanoTime();
            results[2][si] = (t5 - t4) / 1_000_000.0;

// Quick Sort: sort a copy
            int[] arrForQuick = java.util.Arrays.copyOf(base, base.length);
            long t6 = System.nanoTime();
            Member4_QuickSort.quickSort(arrForQuick);
            long t7 = System.nanoTime();
            results[3][si] = (t7 - t6) / 1_000_000.0;
        }

// Print consolidated table
        System.out.println("Consolidated Timing Results (ms)");
        System.out.print("Algorithm ");
        for (int s : sizes) {
            System.out.printf(" | %6d", s);
        }
        System.out.println();
        System.out.println("---------------------------------------------------");

        for (int ai = 0; ai < algNames.length; ai++) {
            System.out.printf("%-13s", algNames[ai]);
            for (int si = 0; si < sizes.length; si++) {
                System.out.printf(" | %6.3f", results[ai][si]);
            }
            System.out.println();
        }
    }
}
