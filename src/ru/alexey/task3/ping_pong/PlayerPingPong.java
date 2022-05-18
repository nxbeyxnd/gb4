package ru.alexey.task3.ping_pong;
/* 
17.05.2022: Alexey created this file inside the package: ru.alexey.task3 
*/

public class PlayerPingPong implements Runnable {
    private String name;

    public PlayerPingPong(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Ball ball = Ball.getInstance();
        while (!ball.isOver()) {
            if (!ball.getCurrentPlayer().equals(name)) {
                ball.kick(name);

            }
        }
    }
}

