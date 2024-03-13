package com.mygdx.game;

import java.util.ArrayList;
import java.util.HashMap;

public class Entity {
    HashMap<String, Component> components;

    public void addComponent(Component component){
        components.put(component.getClass().getName(), component);
    }

    public boolean hasComponent(String componentName){
        return components.containsKey(componentName);
    }

    public Component getComponent(String componentName){
        return components.get(componentName);
    }

    //    ComponentPosition position;
    //    ComponentPlayerController playerController;
    //    ComponentCollision collision;
    //    ComponentSprite sprite;

    Entity() {
        this.components = new HashMap<>();
    }

//    public void SetPositionComponent(ComponentPosition component) { position = component; }
//    public ComponentPosition GetPositionComponent() { return position; }
//
//    public void SetCollisionComponent(ComponentCollision component) { collision = component; }
//    public ComponentCollision GetCollisionComponent() { return collision; }
//
//    public void SetPlayerControllerComponent(ComponentPlayerController component) { playerController = component; }
//    public ComponentPlayerController GetPlayerControllerComponent() { return playerController; }
//
//    public void SetSpriteComponent(ComponentSprite component) { sprite = component; }
//    public ComponentSprite GetSpriteComponent() { return sprite; }

}