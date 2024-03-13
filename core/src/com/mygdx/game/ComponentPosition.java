package com.mygdx.game;

public class ComponentPosition extends Component{

    // Contains all the variables which determine the size
    // and position of an object..

    float x;
    float y;
    float height;
    float width;

    ComponentPosition(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x = x;
    }

    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y = y;
    }

    public float getHeight(){
        return height;
    }
    public void setHeight(float height){
        this.height = height;
    }

    public float getWidth(){
        return width;
    }
    public void setWidth(float width){
        this.width = width;
    }
}
