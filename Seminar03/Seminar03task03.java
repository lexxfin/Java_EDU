//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка
package Seminar03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Seminar03task03 {
    public static void main(String[] args) {
        ThreadLocalRandom randint = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(randint.nextInt(0, 50));
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.printf("Исходный массив -> %s\n", arr);
        System.out.printf("Минимум -> %s\nМаксимум -> %s\nСреднее -> %s",
                Collections.min(arr), Collections.max(arr), (double) sum / size);
    }
}
