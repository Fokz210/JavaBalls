package com.ioannco;

import javax.vecmath.Vector4f;
import java.awt.*;

/**
 * Interface for all game objects
 */
public interface GameObject {
    /**
     * Updates the game object
     *
     * @param deltaTime time since last update
     */
    public void update(double deltaTime);

    /**
     * Draws the game object
     * @param g context to draw on
     */
    public void render(Graphics g);

    /**
     * checks if the game object is colliding with walls
     * @param screenBounds screen bounds
     */
    default void checkWallCollisions(Vector4f screenBounds) {};
}
