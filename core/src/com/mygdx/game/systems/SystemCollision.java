package com.mygdx.game.systems;

import com.mygdx.game.components.*;
import com.mygdx.game.entities.Entity;
import com.mygdx.game.serviceProviders.CollisionEffectProvider;

import java.util.ArrayList;

/**
 * System in charge of managing collisions
 */
public class SystemCollision {

    public SystemCollision() {}

    public void update(ArrayList<Entity> entities) {

        // Create empty collisionObjects list to be filled
        // with all entities that could be collided with.
        ArrayList<Entity> collisionObjects = new ArrayList<Entity>();

        // To store player entity.
        Entity player = null;

        // Finds collision object entities and player entity.
        for (Entity entity : entities) {

            if(entity.hasComponent(ComponentCollision.class)){
                collisionObjects.add(entity);

            }
            if(entity.hasComponent(ComponentPlayerFlag.class)){
                player = entity;
            }

        }

        // If the entity is the player, check its collision with all objects.
        for (Entity collisionObject : collisionObjects) {
            AABBCollision(collisionObject, player);
        }

    }

    void AABBCollision(Entity collisionObject, Entity playerEntity) {

        ComponentPosition collisionPosition = (ComponentPosition) collisionObject.getComponent(ComponentPosition.class);

        ComponentPosition playerPosition = (ComponentPosition) playerEntity.getComponent(ComponentPosition.class);

        // These are the four edges of the collision object.
        float collisionLeft = collisionPosition.getX() - collisionPosition.getWidth() / 2;
        float collisionRight = collisionPosition.getX() + collisionPosition.getWidth() / 2;
        float collisionTop = collisionPosition.getY() + collisionPosition.getHeight() / 2;
        float collisionBottom = collisionPosition.getY() - collisionPosition.getHeight() / 2;

        // These are the four edges of the player.
        float playerLeft = playerPosition.getX() - playerPosition.getWidth() / 2;
        float playerRight = playerPosition.getX() + playerPosition.getWidth() / 2;
        float playerTop = playerPosition.getY() + playerPosition.getHeight() / 2;
        float playerBottom = playerPosition.getY() - playerPosition.getHeight() / 2;

        // These gap values are positive if they overlap, meaning if all of them
        // are positive there is a collision, and the smallest value indicates the
        // direction to push the player in to correct the collision.
        float leftGap =  playerRight - collisionLeft;
        float rightGap = collisionRight - playerLeft;
        float topGap = collisionTop - playerBottom;
        float bottomGap = playerTop - collisionBottom;

        // Checks if all values are positive, which indicates a collision.
        if (leftGap > 0 && rightGap > 0 && topGap > 0 && bottomGap > 0) {

            // Finds the direction with the shortest value
            float leftRightMin = Math.min(leftGap, rightGap);
            float topBottomMin = Math.min(topGap, bottomGap);
            float directionValue = Math.min(leftRightMin, topBottomMin);

            // Moves the player, so it's no longer colliding with the
            // object in the shortest direction.
            if (directionValue == leftGap) {
                playerPosition.setX(collisionLeft - playerPosition.getWidth()/2);
            } else if (directionValue == rightGap) {
                playerPosition.setX(collisionRight + playerPosition.getWidth()/2);
            } else if (directionValue == topGap) {
                playerPosition.setY(collisionTop + playerPosition.getHeight() / 2);
            } else if (directionValue == bottomGap) {
                playerPosition.setY(collisionBottom - playerPosition.getHeight() / 2);
            }


        }

        // To check if object is within interaction distant we do a similar check
        // but with a slightly wider margin.
        if (leftGap+10 > 0 && rightGap+10 > 0 && topGap+10 > 0 && bottomGap+10 > 0) {
            // If object is interactable then we do an InteractionCheck
            if (((ComponentCollision) collisionObject.getComponent(ComponentCollision.class))
                    .getInteractable()) {
                InteractionCheck(collisionObject);
            }
        }
    }

    void InteractionCheck(Entity collisionObject) {
        // Check if space is pressed, and if so complete collisionEffect.
        ArrayList<String> keysPressed = ((ComponentInput) collisionObject.getComponent(ComponentInput.class)).getKeysPressed();
        if(keysPressed.contains("SPACE")){
            ComponentCollisionEffect collisionEffectComponent = (ComponentCollisionEffect)
                    collisionObject.getComponent(ComponentCollisionEffect.class);
            CollisionEffectProvider collisionEffect = collisionEffectComponent.getCollisionEffectProvider();
            collisionEffect.collisionEffect();
        }
    }
}