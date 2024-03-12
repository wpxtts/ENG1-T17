package com.mygdx.game;

public class Entity {

    ComponentPlayerController playerController;
    ComponentCollision collision;

    Entity() {}

    public void SetCollisionComponent(ComponentCollision component) { collision = component; }
    public ComponentCollision GetCollisionComponent() { return collision; }

    public void SetPlayerControllerComponent(ComponentPlayerController component) { playerController = component; }
    public ComponentPlayerController GetPlayerControllerComponent() { return playerController; }

}