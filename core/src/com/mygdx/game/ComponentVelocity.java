package com.mygdx.game;

public class ComponentVelocity extends Component{
    float xSpeed;
    float ySpeed;
    ComponentVelocity(){
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    public float getXSpeed(){
        return xSpeed;
    }
    public void setXSpeed(float xSpeed){
        this.xSpeed = xSpeed;
    }

    public float getYSpeed(){
        return ySpeed;
    }
    public void setYSpeed(float ySpeed){
        this.ySpeed = ySpeed;
    }
}
