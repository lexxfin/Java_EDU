// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
// отвечающие фильтру. Критерии фильтрации можно хранить в Map.

// Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также
// в Map. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
package Seminar06;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) throws FileNotFoundException {
        Laptop laptop = new Laptop();
        laptop.readDB();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            int choice = menu(scanner);
            System.out.println();
            switch (choice) {
                case 1 -> laptop.printDB(laptop.laptops);
                case 2 -> filtration(laptop, scanner);
                case 0 -> {
                    flag = false;
                    System.out.println("До новых встреч!");
                }
            }
        }
    }

    private static int menu(Scanner scanner) {
        System.out.println("Выберите пункт меню:");
        System.out.print("""
                1. Показать доступные ноутбуки
                2. Поиск ноутбука по заданным параметрам
                0. Выход
                : """);
        return scanner.nextInt();
    }

    private static void filtration(Laptop laptop, Scanner scanner) {
        System.out.println("По каким параметрам ищем: ");
        laptop.printFields();
        System.out.print(": ");
        int choose = scanner.nextInt() - 1;
        System.out.println();
        ArrayList<String> resultSearch = laptop.findParameters(choose);
        laptop.printSet(resultSearch, choose);
        System.out.print(": ");
        String chooseParam = resultSearch.get(scanner.nextInt() - 1);
        System.out.println();
        ArrayList<String[]> result = laptop.findFiltered(choose, chooseParam);
        laptop.printDB(result);
    }
}

