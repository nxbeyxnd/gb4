package ru.alexey.task3.p2;
/* 
19.05.2022: Alexey created this file inside the package: ru.alexey.task3.p2 
*/

public class Main {
    public static void main(String[] args) {
        SafeCounter safeCounter = new SafeCounter();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                safeCounter.inc();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                safeCounter.inc();
            }
        });

        t1.start();
        t2.start();
    }
}
