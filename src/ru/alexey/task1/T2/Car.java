package ru.alexey.task1.T2;

public abstract class Car implements Stopable, Moveable {
    private Engine engine;
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");
    }

    protected Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

