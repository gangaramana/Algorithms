package merge_sort;

//
public class MergeSort {
    public static void main(String[] args) {
        int[] A = new int[]{9, 8, 7, 6,5,4,3,2,1};
        MergeSort sort = new MergeSort();
         sort.mergeSort(A);
        for (int p : A) {
            System.out.print("  "+ p);
        }
    }

    public void  mergeSort(int[] a) {
        mergeSort_helper(a, 0, a.length);

    }

    public void mergeSort_helper(int[] b, int start, int finish) {
        int mid = (start + finish) / 2;
        if (finish - start < 2) {
            return;
        }

        mergeSort_helper(b, start, mid);
        mergeSort_helper(b, mid + 1, finish);
//        int[] demo = new int[finish];
        int i = start, j = mid+1, k = 0, middle = mid;
        int[] intermediate = new int[finish+1];
//        i = 0;
//        j = mid;
        while (i <= middle && j <= finish) {
            if (b[i] < b[j]) {
                intermediate[k++] = b[i++];

            } else {
                intermediate[k++] = b[j++];
            }
        }
        while (i < middle) {
            intermediate[k++] = b[i++];
        }
        while (j <= finish) {
            intermediate[k++] = b[j++];
        }

//        System.arraycopy(b, i, b, start + k, mid - i);

//        System.arraycopy(intermediate, 0, b, start, k);
        for (i = start, j = 0; i < finish; i++, j++) {
            b[i] = intermediate[j];
        }
        return;
    }
}
