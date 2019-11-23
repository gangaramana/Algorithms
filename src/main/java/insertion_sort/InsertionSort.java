package insertion_sort;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] x = sort.insertionSort(new int[]{9,8,7,6,5,4,3,2,1});
        for (int i : x) {
            System.out.print(i + "    ");
        }
    }


    public int[] insertionSort(int[] a) {
        int k = 0;
        int unsortedLength = a.length, temp = 0;
        for (int i = 1; i < unsortedLength; i++) {
            temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                k++;
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else if (a[j] < temp) {
                    a[j + 1] = temp;
                    break;
                }
                if (j == 0) {
//                else {
                    a[j] = temp;


                }
            }
        }
        System.out.println("K   " + k);
        return a;
    }
}
