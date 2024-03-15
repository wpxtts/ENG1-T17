package com.mygdx.game.entities;

import com.mygdx.game.components.Component;

import java.util.HashMap;

public class Entity {
    HashMap<String, Component> components;

    public void addComponent(Component component){
        components.put(component.getClass().getName(), component);
    }

    public boolean hasComponent(Class<?> componentClass){
        return components.containsKey(componentClass.getName());
    }

    public Component getComponent(Class<?> componentClass){
        return components.get(componentClass.getName());
    }

    public Entity() {
        this.components = new HashMap<>();
    }

}