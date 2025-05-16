public class Main {

    public static int iterativeBinarySearch(int[] A, int x) {
        int i = 0;
        int j = A.length - 1;

        do {
            int m = (i + j) / 2;
            if (A[m] == x) {
                return m;
            } else if (A[m] < x) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        } while (i <= j);
        // Return -1 if the element is not found
        return -1;
    }


    public static int recursiveBinarySearch(int[] A, int i, int j, int x) {
        int m = (i + j) / 2;

        if (x == A[m]) {
            return m;
        } else if (x > A[m] && m < j) {
            return recursiveBinarySearch(A, m + 1, j, x);
        } else if (x < A[m] && i < m) {
            return recursiveBinarySearch(A, i, m - 1, x);
        } else {
            return -1;
        }
    }

    // Method to check whether an array is sorted in ascending order
    public static boolean arraySorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false; // pair out of order (descending)
            }
        }
        return true; // array is sorted
    }


    public static void main(String[] args) {

        // USED FOR TESTING***
        // Create an array up to a million numbers (or desired number) sorted by ascending order.
        //int[] A = new int[1000000];
        //for (int i = 0; i < A.length; i++) {
        //    A[i] = i;
        //}

        // Sorted Array example.
        int[] A = {1, 2, 3, 4, 5};

        // Unsorted Array example.
        int[] B = {5, 2, 9, 1, 3};

        // Checks if array is sorted before calculating average runtime in seconds.
        if (arraySorted(A)) {

            System.out.println("This array is sorted."); // Sorted Array (ascending)

            // Test runs and target number for each algorithm to find.
            int target = 5;
            int tests = 10;
            long totalIterativeTime = 0;
            long totalRecursiveTime = 0;

            // Runtime tester
            // Used ChatGPT to suggest ways to measure runtime and run multiple tests for the algorithms.
            // It suggested to use nanoTime and a for loop to perform multiple tests.
            for (int i = 0; i < tests; i++) {
                // Iterative
                long startIterative = System.nanoTime(); // Start Timer
                iterativeBinarySearch(A, target);
                long endIterative = System.nanoTime(); // End Timer
                totalIterativeTime += (endIterative - startIterative);

                // Recursive
                long startRecursive = System.nanoTime(); // Start Timer
                recursiveBinarySearch(A, 0, A.length - 1, target);
                long endRecursive = System.nanoTime(); // End Timer
                totalRecursiveTime += (endRecursive - startRecursive);
            }

            // Convert to seconds
            double avgIterativeSec = (totalIterativeTime / (double) tests) / 1000000000.0;
            double avgRecursiveSec = (totalRecursiveTime / (double) tests) / 1000000000.0;

            System.out.printf("Average Iterative Runtime = %.9f seconds%n", avgIterativeSec);
            System.out.printf("Average Recursive Runtime = %.9f seconds%n", avgRecursiveSec);

        } else {
            System.out.println("This array is not sorted in ascending order.");
        }
    }
}
