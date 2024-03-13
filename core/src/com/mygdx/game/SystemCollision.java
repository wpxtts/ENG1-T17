package com.mygdx.game;

import java.util.ArrayList;

public class SystemCollision {

    SystemCollision() {}

    public void Update(Entity[] entities) {

        ArrayList<Entity> collisionObjects = new ArrayList<Entity>();
        Entity player = null;

        // Finds collision object entities and player entity.
        for (Entity entity : entities) {

            if(entity.hasComponent(ComponentCollision.class)){
                collisionObjects.add(entity);

            }
            if(entity.hasComponent(ComponentPlayerController.class)){
                player = entity;
            }

//            ComponentCollision collision = entity.GetCollisionComponent();
//            ComponentPlayerController playerController = entity.GetPlayerControllerComponent();
//
//            if (collision != null) {
//                collisionObjects.add(entity);
//            } else if (playerController != null) {
//                player = entity;
//            }
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
        float collisionLeft = collisionPosition.x - collisionPosition.width / 2;
        float collisionRight = collisionPosition.x + collisionPosition.width / 2;
        float collisionTop = collisionPosition.y + collisionPosition.height / 2;
        float collisionBottom = collisionPosition.y - collisionPosition.height / 2;

        // These are the four edges of the player.
        float playerLeft = playerPosition.x - playerPosition.width / 2;
        float playerRight = playerPosition.x + playerPosition.width / 2;
        float playerTop = playerPosition.y + playerPosition.height / 2;
        float playerBottom = playerPosition.y - playerPosition.height / 2;

        // These gap values are positive if they overlap, meaning if all of them
        // are positive there is a collision, and the smallest value indicates the
        // direction to push the player in to correct the collision.
        float leftGap =  playerRight - collisionLeft;
        float rightGap = collisionRight - playerLeft;
        float topGap = collisionTop - playerBottom;
        float bottomGap = playerTop - collisionBottom;

        // Checks if all values are positive, which indicates a collision.
        if (leftGap > 0 && rightGap > 0 && topGap > 0 && bottomGap > 0) {

            if (((ComponentCollision) collisionObject.getComponent(ComponentCollision.class)).interactable) {
                InteractionCheck();
            }

            else {
                // Finds the direction with the shortest value
                float leftRightMin = Math.min(leftGap, rightGap);
                float topBottomMin = Math.min(topGap, bottomGap);
                float directionValue = Math.min(leftRightMin, topBottomMin);

                // Moves the player, so it's no longer colliding with the
                // object in the shortest direction.
                if (directionValue == leftGap) {
                    playerPosition.x = collisionLeft - playerPosition.width / 2;
                } else if (directionValue == rightGap) {
                    playerPosition.x = collisionRight + playerPosition.width / 2;
                } else if (directionValue == topGap) {
                    playerPosition.y = collisionTop + playerPosition.height / 2;
                } else if (directionValue == bottomGap) {
                    playerPosition.y = collisionBottom - playerPosition.height / 2;
                }
            }

        }

    }

    void InteractionCheck() {

        // Add in here whatever happens, will need to change collision component and
        // probably have a switch case

        System.out.println("Check");

    }
}
