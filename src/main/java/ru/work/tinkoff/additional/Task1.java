package ru.work.tinkoff.additional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.lang.String.format;

public class Task1 {

    private List<Integer> myList = new CopyOnWriteArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) {
        new Task1().test();
    }

    synchronized public Integer getRandomDigit() {
        while (myList.size() == 0) {
        }
        Integer i = this.myList.remove(new Random().nextInt(this.myList.size()));
        System.out.println("out " + i + " size = " + myList.size());
        return i;
    }

    public void test() {
        for (int i = 0; i < 1000; i++) {
            new ThreadTest("thread", i).start();
        }
    }

    class ThreadTest extends Thread {

        private String name;
        private Integer number;

        ThreadTest(String name, Integer number) {
            this.name = name;
            this.number = number;
        }

        void get() {
            int i = getRandomDigit();
            System.out.println(format("%s - %d\n", this.name + number, i));
            myList.add(i);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
            }
            get();
        }
    }
}
