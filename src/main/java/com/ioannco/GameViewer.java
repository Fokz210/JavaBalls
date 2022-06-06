package com.ioannco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Renderer class
 */
public class GameViewer extends JPanel implements ActionListener {
    ArrayList<GameObject> renderables = new ArrayList<>();
    Timer timer;

    JFrame frame;

    /**
     * Constructor
     *
     * @param renderDelay delay between frames in milliseconds
     * @param width       width of the window
     * @param height      height of the window
     */
    public GameViewer(int renderDelay, int width, int height) {
        frame = new JFrame("Hello world!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.add(this);

        timer = new Timer(renderDelay, this);

    }

    /**
     * paints all game objects
     *
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (GameObject renderable : renderables) {
            renderable.render(g);
        }
    }

    /**
     * Updates panel
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Adds game object to the render list
     * @param renderable game object to add
     */
    public void add(GameObject renderable) {
        renderables.add(renderable);
    }

    /**
     * Removes game object from the render list
     * @param renderable game object to remove
     */
    public void remove(GameObject renderable) {
        renderables.remove(renderable);
    }

    /**
     * Starts the renderer
     */
    public void start() {
        timer.start();
    }

    public void close() {
        timer.stop();
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}
