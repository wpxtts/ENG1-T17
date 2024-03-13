package com.mygdx.game;

public class Entity {

    ComponentPosition position;
    ComponentPlayerController playerController;
    ComponentCollision collision;
    ComponentSprite sprite;

    Entity() {}

    public void SetPositionComponent(ComponentPosition component) { position = component; }
    public ComponentPosition GetPositionComponent() { return position; }

    public void SetCollisionComponent(ComponentCollision component) { collision = component; }
    public ComponentCollision GetCollisionComponent() { return collision; }

    public void SetPlayerControllerComponent(ComponentPlayerController component) { playerController = component; }
    public ComponentPlayerController GetPlayerControllerComponent() { return playerController; }

    public void SetSpriteComponent(ComponentSprite component) { sprite = component; }
    public ComponentSprite GetSpriteComponent() { return sprite; }

}