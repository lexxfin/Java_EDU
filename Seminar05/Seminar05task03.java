//Реализовать алгоритм пирамидальной сортировки (HeapSort). (Можно использовать массивы)
package Seminar05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Seminar05task03 {
    public static void main(String[] args) {
        ThreadLocalRandom randint = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        int[] arr = new int[arraySize];
        System.out.println("Сгенерированный массив:");
        createArray(arr, randint, arraySize);
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println("\nОтсортированный массив: ");
        System.out.println(Arrays.toString(arr));
    }

    private static void createArray(int[] array, ThreadLocalRandom rand, int size) {
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(0, 1000);
        }
    }

    private static void heapSort(int[] array) {
        int arraySize = array.length - 1;
        for (int i = 0; i < arraySize; i++) {
            if (2 * i + 2 < arraySize) {
                if (array[i] > array[2 * i + 1] && i % 2 == 0) {
                    int temp = array[i];
                    array[i] = array[2 * i + 1];
                    array[2 * i + 1] = temp;
                } else if (array[i] > array[2 * i + 2] && i % 2 != 0) {
                    int temp = array[i];
                    array[i] = array[2 * i + 2];
                    array[2 * i + 2] = temp;
                }
            }
        }
        int max;
        int maxi = 0;
        for (int i = arraySize; i > 0; i--) {
            max = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxi = j;
                }
            }
            if (max > array[i]) {
                int temp = array[i];
                array[i] = array[maxi];
                array[maxi] = temp;
            }
        }
    }
}
