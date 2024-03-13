package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class SystemCollision {

    // Predefined radius for color change
    private static final float IN_RANGE = 150; // Adjust this radius as needed

    SystemCollision() {}

    public void Update(Entity[] entities) {

        // Note the player controller is initialised as null, meaning the code will break if there
        // is no player entity.
        ArrayList<ComponentCollision> collisionObjects = new ArrayList<ComponentCollision>();
        ComponentPlayerController player = null;

        // Finds all the collidable objects and the player.
        for (int i = 0; i < entities.length; i++) {

            ComponentCollision collision = entities[i].GetCollisionComponent();
            ComponentPlayerController playerController = entities[i].GetPlayerControllerComponent();

            if (collision != null) {
                collisionObjects.add(collision);
            } else if (playerController != null) {
                player = playerController;
            }
        }

        // Determines what needs to be done for each collision.
        for (int i = 0; i < collisionObjects.size(); i++) {
            ComponentCollision collision = collisionObjects.get(i);
            CollisionCorrection(collision, player);
        }
    }

    void CollisionCorrection(ComponentCollision collision, ComponentPlayerController player) {

        // Calculate distance between player and collision object
        Point2D.Float playerCenter = new Point2D.Float(player.x + player.width / 2, player.y + player.height / 2);
        Point2D.Float collisionCenter = new Point2D.Float(collision.x + collision.width / 2, collision.y + collision.height / 2);
        float distance = (float) playerCenter.distance(collisionCenter);

        // Check if player is within the predefined radius of the collision object
        if (distance <= IN_RANGE) {
            // Change the color of the player's block (for demonstration purpose, changing to green)
            player.color = Color.GREEN;

        } else {
            // Reset the color to default (for demonstration purpose, changing back to red)
            player.color = Color.RED;
        }

        // Rest of collision correction code remains unchanged
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
}
