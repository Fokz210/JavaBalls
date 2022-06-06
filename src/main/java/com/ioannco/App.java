package com.ioannco;

import javax.swing.*;

/**
 * Main app class
 */
public class App {
    public static void main(String[] args) {
        Engine engine = new Engine(1, 2, 800, 600);
        engine.start();
    }
}
