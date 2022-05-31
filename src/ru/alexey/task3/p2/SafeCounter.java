package ru.alexey.task3.p2;
/* 
19.05.2022: Alexey created this file inside the package: ru.alexey.task3.p2 
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCounter {
    private static int count = 0;
    private Lock lock = new ReentrantLock();

    public void inc(){
        this.lock.lock();
        System.out.println(count++);
        this.lock.unlock();
    }
}
