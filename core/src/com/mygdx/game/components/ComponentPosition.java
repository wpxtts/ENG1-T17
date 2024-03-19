package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;

/**
 * ComponentPosition represents a component that determines the size and position of an object.
 */
public class ComponentPosition extends Component {

    // Variables determining the position and size of the object
    private double x;
    private double y;
    private double height;
    private double width;

    /**
     * Constructs a ComponentPosition with the specified position and size parameters.
     * @param x The x-coordinate of the position
     * @param y The y-coordinate of the position
     * @param height The height of the object
     * @param width The width of the object
     */
    public ComponentPosition(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Retrieves the x-coordinate of the position, scaled to the screen width.
     * @return The scaled x-coordinate
     */
    public double getX() {
        return x * Gdx.graphics.getWidth();
    }

    /**
     * Retrieves the raw x-coordinate of the position.
     * @return The raw x-coordinate
     */
    public double getRawX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the position.
     * @param x The x-coordinate to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Retrieves the y-coordinate of the position, scaled to the screen height.
     * @return The scaled y-coordinate
     */
    public double getY() {
        return y * Gdx.graphics.getHeight();
    }

    /**
     * Retrieves the raw y-coordinate of the position.
     * @return The raw y-coordinate
     */
    public double getRawY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the position.
     * @param y The y-coordinate to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Retrieves the height of the object, scaled to the screen height.
     * @return The scaled height
     */
    public double getHeight() {
        return height * Gdx.graphics.getHeight();
    }

    /**
     * Retrieves the raw height of the object.
     * @return The raw height
     */
    public double getRawHeight() {
        return height;
    }

    /**
     * Sets the height of the object.
     * @param height The height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Retrieves the width of the object, scaled to the screen width.
     * @return The scaled width
     */
    public double getWidth() {
        return width * Gdx.graphics.getWidth();
    }

    /**
     * Retrieves the raw width of the object.
     * @return The raw width
     */
    public double getRawWidth() {
        return width;
    }

    /**
     * Sets the width of the object.
     * @param width The width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
}
