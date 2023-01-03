import java.util.Arrays;

//Реализовать алгоритм сортировки слиянием
public class seminar_03_task_01 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 20, 13, 4, 3, 9, 2, 5};
        System.out.print("Исходный массив -> ");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, arr.length);
        System.out.print("Отсортированный массив слиянием -> ");
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }

    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) src[k++] = left[i++];
            else src[k++] = right[j++];
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }
}

