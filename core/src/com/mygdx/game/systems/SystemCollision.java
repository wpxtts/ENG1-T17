package com.mygdx.game.systems;

import com.mygdx.game.GameScreen;
import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.entities.Tracker;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * SystemCollision is responsible for managing collision detection and resolution in the game.
 */
public class SystemCollision {

    /**
     * Constructs a SystemCollision object.
     */
    public SystemCollision() {}

    /**
     * Updates the collision system with the current state of the game entities.
     * @param entities The list of entities in the game
     */
    public void update(HashMap<String, Entity> entities) {

        // Create empty collisionObjects list to be filled
        // with all entities that could be collided with.
        ArrayList<Entity> collisionObjects = new ArrayList<>();

        // To store player entity.
        Entity player = null;

        // Finds collision object entities and player entity.
        for (Entity entity : entities.values()) {
            if (entity.hasComponent(ComponentCollision.class)) {
                collisionObjects.add(entity);
            }
        }
        player = entities.get("Player");

        // If the entity is the player, check its collision with all objects.
        if (player != null) {
            for (Entity collisionObject : collisionObjects) {
                AABBCollision(collisionObject, player, entities);
            }
        }
    }

    /**
     * Handles axis-aligned bounding box (AABB) collision detection and resolution between two entities.
     * @param collisionObject The entity representing the collision object
     * @param playerEntity The entity representing the player
     */
    void AABBCollision(Entity collisionObject, Entity playerEntity, HashMap<String,Entity>entities) {

        ComponentPosition collisionPosition = (ComponentPosition) collisionObject.getComponent(ComponentPosition.class);
        ComponentPosition playerPosition = (ComponentPosition) playerEntity.getComponent(ComponentPosition.class);

        // These are the four edges of the collision object.
        double collisionLeft = collisionPosition.getRawX();
        double collisionRight = collisionPosition.getRawX() + collisionPosition.getRawWidth();
        double collisionTop = collisionPosition.getRawY() + collisionPosition.getRawHeight();
        double collisionBottom = collisionPosition.getRawY();

        // These are the four edges of the player.
        double playerLeft = playerPosition.getRawX();
        double playerRight = playerPosition.getRawX() + playerPosition.getRawWidth();
        double playerTop = playerPosition.getRawY() + playerPosition.getRawHeight();
        double playerBottom = playerPosition.getRawY();

        // These gap values are positive if they overlap, meaning if all of them
        // are positive there is a collision, and the smallest value indicates the
        // direction to push the player in to correct the collision.
        double leftGap = playerRight - collisionLeft;
        double rightGap = collisionRight - playerLeft;
        double topGap = collisionTop - playerBottom;
        double bottomGap = playerTop - collisionBottom;

        // Checks if all values are positive, which indicates a collision.
        if (leftGap > 0 && rightGap > 0 && topGap > 0 && bottomGap > 0) {

            // Finds the direction with the shortest value
            double leftRightMin = Math.min(leftGap, rightGap);
            double topBottomMin = Math.min(topGap, bottomGap);
            double directionValue = Math.min(leftRightMin, topBottomMin);

            // Moves the player, so it's no longer colliding with the
            // object in the shortest direction.
            if (directionValue == leftGap) {
                playerPosition.setX(collisionLeft - playerPosition.getRawWidth());
            } else if (directionValue == rightGap) {
                playerPosition.setX(collisionRight);
            } else if (directionValue == topGap) {
                playerPosition.setY(collisionTop);
            } else if (directionValue == bottomGap) {
                playerPosition.setY(collisionBottom - playerPosition.getRawHeight());
            }
        }

        // To check if object is within interaction distance we do a similar check
        // but with a slightly wider margin.
        if (leftGap + 0.015 > 0 && rightGap + 0.015 > 0 && topGap + 0.015 > 0 && bottomGap + 0.015 > 0) {
            // If object is interactable then we do an InteractionCheck
            ComponentCollision collisionComponent = (ComponentCollision) collisionObject.getComponent(ComponentCollision.class);
            if (collisionComponent.getInteractable()) {
                InteractionCheck(entities,collisionObject);
            }
        }
    }

    /**
     * Checks if the player entity is interacting with the given collision object entity.
     * @param collisionObject The entity representing the collision object
     */
    void InteractionCheck(HashMap<String,Entity> entities, Entity collisionObject) {
        // Check if space is pressed, and if so complete collisionEffect.
        if(collisionObject.hasComponent(ComponentInput.class) && collisionObject.hasComponent(ComponentCollisionEffect.class)){
            ComponentInput inputComponent = (ComponentInput) collisionObject.getComponent(ComponentInput.class);
            if (inputComponent.getKeysPressed().contains("SPACE")) {
                ComponentCollisionEffect collisionEffectComponent = (ComponentCollisionEffect) collisionObject.getComponent(ComponentCollisionEffect.class);
                CollisionEffectProvider collisionEffect = collisionEffectComponent.getCollisionEffectProvider();
                collisionEffect.collisionEffect(entities);
            }
        }
    }
}
