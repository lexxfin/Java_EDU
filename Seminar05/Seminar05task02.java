//Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
package Seminar05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Seminar05task02 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> db = new ArrayList<>();
        HashMap<String, Integer> dbData = new HashMap<>();
        getFromFile(dbData, db);
        System.out.println("Исходный список: ");
        System.out.println(db);
        System.out.println("\nКоличество повторяющихся имён в файле: ");
        printDuplicates(dbData);
        LinkedHashMap<String, Integer> sortedData = new LinkedHashMap<>();
        sortedDB(dbData, sortedData);
        System.out.println("\nОтсортированное количество повторяющихся имён в файле: ");
        printDuplicates(sortedData);
    }

    private static void getFromFile(HashMap<String, Integer> data, ArrayList<String> original) throws FileNotFoundException {
        File reader = new File("Seminar05/list.txt");
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] temp = input.split(" ");
            original.add(input);
            if (data.containsKey(temp[0])) {
                data.put(temp[0], data.get(temp[0]) + 1);
            } else {
                data.put(temp[0], 1);
            }
        }
    }

    private static void printDuplicates(HashMap<String, Integer> data) {
        Set<Map.Entry<String, Integer>> entries = data.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("%10s %s %d\n", entry.getKey(), ":", entry.getValue());
        }
    }

    private static void sortedDB(HashMap<String, Integer> data, LinkedHashMap<String, Integer> sorted) {
        String maxKey = "";
        int maxValue = 0;
        while (data.size() > 0) {
            Set<Map.Entry<String, Integer>> entries = data.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }
            sorted.put(maxKey, maxValue);
            data.remove(maxKey);
            maxKey = "";
            maxValue = 0;
        }
    }
}
