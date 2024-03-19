package com.mygdx.game.entities;

import com.mygdx.game.components.Component;

import java.util.HashMap;

/**
 * Entity represents a game entity with components.
 */
public class Entity {

    // Mapping of component class names to components
    HashMap<String, Component> components;

    /**
     * Constructs an Entity with an empty component map.
     */
    public Entity() {
        this.components = new HashMap<>();
    }

    /**
     * Adds a component to the entity.
     * @param component The component to add
     */
    public void addComponent(Component component) {
        components.put(component.getClass().getName(), component);
    }

    /**
     * Checks if the entity has a component of the specified class.
     * @param componentClass The class of the component to check for
     * @return true if the entity has the component, false otherwise
     */
    public boolean hasComponent(Class<?> componentClass) {
        return components.containsKey(componentClass.getName());
    }

    /**
     * Retrieves the component of the specified class.
     * @param componentClass The class of the component to retrieve
     * @return The component of the specified class, or null if not found
     */
    public Component getComponent(Class<?> componentClass) {
        return components.get(componentClass.getName());
    }
}
