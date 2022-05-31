package ru.alexey.task3.ping_pong;
/* 
17.05.2022: Alexey created this file inside the package: ru.alexey.task3 
*/

public class Ball {
    private static final Ball instance = new Ball();
    private String currentPlayer = "";
    int plays = 0;

    public synchronized void kick(String name) {
        plays++;
        currentPlayer = name;
        System.out.println(name);
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    static Ball getInstance() {
        return instance;
    }

    boolean isOver() {
        return plays >= 10;
    }
}
