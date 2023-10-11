package ru.gb.sidin;

/**
 * Start point class of the App
 */
public class Main {
    public static void main(String[] args) {
        App app = new App("./notes.txt");
        app.start();
    }
}
