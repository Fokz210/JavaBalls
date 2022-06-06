package com.ioannco;

import javax.vecmath.Vector2f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4f;
import java.awt.*;

/**
 * Ball game object
 */
public class Ball implements GameObject {
    private float radius;
    private Vector2f position;
    private Vector2f velocity;
    private Color color;

    /**
     * velocity getter
     * @return velocity
     */
    public Vector2f getVelocity() {
        return velocity;
    }

    /**
     * velocity setter
     * @param velocity new velocity
     */
    public void setVelocity(Vector2f velocity) {
        this.velocity = velocity;
    }

    /**
     * getter for the position
     * @return position
     */
    public Vector2f getPosition() {
        return position;
    }

    /**
     * setter for the position
     * @param position new position
     */
    public void setPosition(Vector2f position) {
        this.position = position;
    }

    /**
     * getter for the color
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * setter for the color
     * @param color new color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * getter for the radius
     * @return radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * setter for the radius
     * @param radius    new radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * Constructor
     *
     * @param position position of the ball
     * @param velocity velocity of the ball
     * @param color color of the ball
     * @param radius radius of the ball
     */
    public Ball(Vector2f position, Vector2f velocity, Color color, double radius) {
        this.position = position;
        this.velocity = velocity;
        this.color = color;
        this.radius = (float) radius;
    }

    /**
     * Updates the ball
     *
     * @param deltaTime time since last update
     */
    @Override
    public void update(double deltaTime) {
        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;
    }

    /**
     * Draws the ball
     *
     * @param g context to draw on
     */
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (position.x - radius), (int) (position.y - radius), (int) radius * 2, (int) radius * 2);
    }

    /**
     * Checks if the ball is colliding with walls and updates the velocity accordingly
     *
     * @param screenBounds screen bounds
     */
    @Override
    public void checkWallCollisions(Vector4f screenBounds) {
        if (position.x - radius < screenBounds.x) {
            position.x = radius;
            velocity.x = -velocity.x;
        } else if (position.x + radius > screenBounds.z) {
            position.x = screenBounds.z - radius;
            velocity.x = -velocity.x;
        }
        if (position.y - radius < screenBounds.y) {
            position.y = radius;
            velocity.y = -velocity.y;
        } else if (position.y + radius > screenBounds.w) {
            position.y = screenBounds.w - radius;
            velocity.y = -velocity.y;
        }
    }

}
