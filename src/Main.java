public class Main {

    public static void iterativeBinarySearch(int[] A, int x) {

        int i = 0; // left
        int j = A.length - 1; // right

        do {
            int m = (i+j)/2;

            if (A[m] == x) {
                return;
            } else if (A[m] < x) {
                i = m + 1;
            } else if (A[m] > x) {
                j = m - 1;
            } else {
                return;
            }
        } while (i <= j);
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
            return 0;
        }
    }



    public static void main(String[] args) {

        int[] A = new int[1_000_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }

        iterativeBinarySearch(A, 987654);

        recursiveBinarySearch(A, 0, A.length -1, 987654);
    }
}
