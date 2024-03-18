package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;

public class ComponentPosition extends Component{

    // Contains all the variables which determine the size
    // and position of an object..

    double x;
    double y;
    double height;
    double width;

    public ComponentPosition(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getX(){
        return x* Gdx.graphics.getWidth();
    }
    public double getRawX(){return x;}
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return y*Gdx.graphics.getHeight();
    }
    public double getRawY(){return y;}
    public void setY(double y){
        this.y = y;
    }

    public double getHeight(){
        return height*Gdx.graphics.getHeight();
    }
    public double getRawHeight(){return height;}
    public void setHeight(double height){
        this.height = height;
    }

    public double getWidth(){
        return width*Gdx.graphics.getWidth();
    }
    public double getRawWidth(){return width;};
    public void setWidth(double width){
        this.width = width;
    }
}
