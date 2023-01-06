//Пусть дан произвольный список целых чисел, удалить из него четные числа
package Seminar03;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Seminar03task02 {
    public static void main(String[] args) {
        ThreadLocalRandom randint = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(randint.nextInt(0, 100));
        }
        System.out.printf("Исходный массив -> %s\n", arr);
        arr.removeIf(num -> num % 2 == 0);
        System.out.printf("Массив без четных чисел -> %s", arr);
    }
}
