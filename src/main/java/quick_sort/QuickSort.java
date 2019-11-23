package quick_sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = new int[]{9,8,7,4,5,6,3,2,1,1,5,8,9,6,5,7};
        QuickSort sort = new QuickSort();
        sort.quickSort(A, 0, A.length - 1);
        System.out.println();
        for (int p : A) {

            System.out.print("  " + p);
        }
    }


    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            System.out.println(pi);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }


    }

    public int partition(int[] b, int l, int h) {
        int pivot = b[l];
        int pivotIndex = l;
        l++;
        while (l <= h) {
            while (l<b.length && pivot >= b[l]) {
                l++;
            }
            while (pivot <= b[h]&&h>pivotIndex) {
                h--;
            }
            if (l < h) {
                int x = b[l];
                b[l] = b[h];
                b[h] = x;
            }

        }
        if (l >= h) {
            b[pivotIndex] = b[h];
            b[h] = pivot;
        }
        return h;

    }
}
