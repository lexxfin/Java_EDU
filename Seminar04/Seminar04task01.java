//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
package Seminar04;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Seminar04task01 {
    public static void main(String[] args) {
        ThreadLocalRandom randint = ThreadLocalRandom.current();
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(randint.nextInt(0, 10));
        }
        System.out.printf("Исходный массив -> %s\n", arr);
        reverseArray(arr);
        System.out.printf("Перевернутый массив -> %s\n", arr);
    }

    private static void reverseArray(LinkedList<Integer> arr) {
        for (int i = 0; i < (arr.size() + 1) / 2; i++) {
            int temp = arr.get(i);
            arr.set(i, arr.get(arr.size() - 1 - i));
            arr.set(arr.size() - 1 - i, temp);
        }
    }
}
