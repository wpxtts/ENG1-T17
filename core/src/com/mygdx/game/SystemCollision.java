package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class SystemCollision {

    SystemCollision() {}

    public void Update(Entity[] entities) {

        ArrayList<Entity> collisionObjects = new ArrayList<Entity>();
        Entity player = null;

        // Finds collision object entities and player entity.
        for (int i = 0; i < entities.length; i++) {

            Entity entity = entities[i];
            ComponentCollision collision = entity.GetCollisionComponent();
            ComponentPlayerController playerController = entity.GetPlayerControllerComponent();

            if (collision != null) {
                collisionObjects.add(entity);
            }

            else if (playerController != null) {
                player = entity;
            }
        }

        // If the entity is the player, check its collision with all objects.
        for (int i = 0; i < collisionObjects.size(); i++) {
            Entity collisionObject = collisionObjects.get(i);
            AABBCollision(collisionObject, player);
        }

    }

    boolean AABBCollision(Entity collisionObject, Entity playerEntity) {

        ComponentPosition collision = collisionObject.GetPositionComponent();
        ComponentPosition player = playerEntity.GetPositionComponent();

        // These are the four edges of the collision object.
        float collisionLeft = collision.x - collision.width / 2;
        float collisionRight = collision.x + collision.width / 2;
        float collisionTop = collision.y + collision.height / 2;
        float collisionBottom = collision.y - collision.height / 2;

        // These are the four edges of the player.
        float playerLeft = player.x - player.width / 2;
        float playerRight = player.x + player.width / 2;
        float playerTop = player.y + player.height / 2;
        float playerBottom = player.y - player.height / 2;

        // These gap values are positive if they overlap, meaning if all of them
        // are positive there is a collision, and the smallest value indicates the
        // direction to push the player in to correct the collision.
        float leftGap =  playerRight - collisionLeft;
        float rightGap = collisionRight - playerLeft;
        float topGap = collisionTop - playerBottom;
        float bottomGap = playerTop - collisionBottom;

        // Checks if all values are positive, which indicates a collision.
        if (leftGap > 0 && rightGap > 0 && topGap > 0 && bottomGap > 0) {

            if (collisionObject.GetCollisionComponent().interactable) {
                InteractionCheck();
            }

            else {
                // Finds the direction with the shortest value
                float leftRightMin = Math.min(leftGap, rightGap);
                float topBottomMin = Math.min(topGap, bottomGap);
                float directionValue = Math.min(leftRightMin, topBottomMin);

                // Moves the player so it's no longer colliding with the
                // object in the shortest direction.
                if (directionValue == leftGap) {
                    player.x = collisionLeft - player.width / 2;
                } else if (directionValue == rightGap) {
                    player.x = collisionRight + player.width / 2;
                } else if (directionValue == topGap) {
                    player.y = collisionTop + player.height / 2;
                } else if (directionValue == bottomGap) {
                    player.y = collisionBottom - player.height / 2;
                }
            }

        }

        return false;
    }

    void InteractionCheck() {

        // Add in here whatever happens, will need to change collision component and
        // probably have a switch case

    }
}
