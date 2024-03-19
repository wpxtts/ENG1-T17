package com.mygdx.game.components;

/**
 * ComponentVelocity represents a component that determines the velocity of an object.
 */
public class ComponentVelocity extends Component {

    // The speed in the x-direction
    private float xSpeed;

    // The speed in the y-direction
    private float ySpeed;

    /**
     * Constructs a ComponentVelocity with zero initial speed.
     */
    public ComponentVelocity() {
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    /**
     * Retrieves the speed in the x-direction.
     * @return The speed in the x-direction
     */
    public float getXSpeed() {
        return xSpeed;
    }

    /**
     * Sets the speed in the x-direction.
     * @param xSpeed The speed in the x-direction to set
     */
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Retrieves the speed in the y-direction.
     * @return The speed in the y-direction
     */
    public float getYSpeed() {
        return ySpeed;
    }

    /**
     * Sets the speed in the y-direction.
     * @param ySpeed The speed in the y-direction to set
     */
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
}
