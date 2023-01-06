// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя.
// (Подобную задачу решали на семинаре. Здесь так же нужно создать класс, который будет реализовывать указанные методы)
package Seminar04;

import java.util.LinkedList;

public class Seminar04task02 {

    LinkedList<Integer> arr = new LinkedList<>();

    public void enqueue(int newItem) {
        arr.add(newItem);
    }

    public int dequeue() {
        int firstItem = arr.get(0);
        arr.remove(0);
        return firstItem;
    }

    public int first() {
        return arr.get(0);
    }

}

