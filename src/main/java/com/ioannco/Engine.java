package com.ioannco;

import javax.swing.*;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector4f;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Engine class
 */
public class Engine implements ActionListener, KeyListener {

    private final GameViewer viewer;
    private final Ball ball;
    private final Timer ticker;
    private final Vector4f screenBounds;
    private float metersToPixels = 0.1f;

    /**
     * Constructor
     * @param physicsDelay physics delay in milliseconds
     * @param renderDelay render delay in milliseconds
     */
    Engine (int physicsDelay, int renderDelay, int width, int height) {
        viewer = new GameViewer(renderDelay, width, height);
        ball = new Ball(new Vector2f(100, 100), new Vector2f(100, 50), Color.BLUE, 50);
        viewer.add(ball);
        ticker = new Timer(physicsDelay, this);
        viewer.addKeyListener(this);

        screenBounds = new Vector4f(0, 0, width, height);
    }

    /**
     * Starts engine
     */
    public void start() {
        ticker.start();
        viewer.start();
    }

    /**
     * Updates the engine
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ball.checkWallCollisions(screenBounds);
        ball.update(ticker.getDelay() * metersToPixels);
    }

    /**
     * Sets the scale of the game in meters to pixels
     *
     * @param metersToPixels scale in meters to pixels
     */
    void setMetersToPixels(float metersToPixels) {
        this.metersToPixels = metersToPixels;
    }

    /**
     * Gets the scale of the game in meters to pixels
     */
    float getMetersToPixels() {
        return metersToPixels;
    }

    /**
     *  Key typed event handler
     *
     * @param e event
     */
    @Override
    public void keyTyped(KeyEvent e) {
        /* none */
    }

    /**
     * Key pressed event handler
     * @param e event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        /* none */
    }

    /**
     * Key released event handler
     * @param e event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            viewer.close();
        }
    }
}
