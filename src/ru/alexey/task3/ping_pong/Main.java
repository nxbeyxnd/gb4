package ru.alexey.task3.ping_pong;
/* 
17.05.2022: Alexey created this file inside the package: ru.alexey.task3 
*/

public class Main {
    public static void main(String[] args) {
        Thread pingThread = new Thread(new PlayerPingPong("ping"));
        Thread pongThread = new Thread(new PlayerPingPong("pong"));

        pingThread.start();
        pongThread.start();

    }
}
