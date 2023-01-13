package Seminar06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Laptop {
    ArrayList<String[]> laptops = new ArrayList<>();
    String[] fields = {"Brand", "Model", "Display", "CPU", "GPU", "RAM", "SSD", "OS", "Color", "Price"};

    public void readDB() throws FileNotFoundException {
        File file = new File("Seminar06/db.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] temp = scanner.nextLine().split(" / ");
            laptops.add(temp);
        }
    }

    public void printDB(ArrayList<String[]> forPrint) {
        int c = 1;
        for (String[] laptop : forPrint) {
            System.out.printf("#%d\n", c);
            for (int i = 0; i < laptop.length; i++) {
                System.out.printf("%s: %s\n", fields[i], laptop[i]);
            }
            System.out.println();
            c++;
        }
    }

    public void printFields() {
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%d: %s\n", i + 1, fields[i]);
        }
    }

    public ArrayList<String> findParameters(int index) {
        ArrayList<String> result = new ArrayList<>();
        Set<String> tempSet = new HashSet<>();
        for (String[] laptop : laptops) {
            tempSet.add(laptop[index]);
        }
        for (String item : tempSet) {
            result.add(item);
        }
        return result;
    }

    public void printSet(ArrayList<String> set, int index) {
        int c = 1;
        System.out.printf("%s:\n", fields[index]);
        for (String i : set) {
            System.out.printf("%d: %s\n", c, i);
            c++;
        }
    }

    public ArrayList<String[]> findFiltered(int index, String searchStr) {
        ArrayList<String[]> result = new ArrayList<>();
        for (String[] laptop : laptops) {
            if (laptop[index].equals(searchStr)) {
                result.add(laptop);
            }
        }
        return result;
    }
}
