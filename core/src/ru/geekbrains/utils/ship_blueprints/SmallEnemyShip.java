package ru.geekbrains.utils.ship_blueprints;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprites.EnemyShip;
import ru.geekbrains.utils.Regions;

public class SmallEnemyShip {
    private static final float SHIP_HEIGHT = 0.1f;
    private static final String SHIP_ATLAS_REGION = "enemy0";
    private static final float SHIP_SPEED = 0.004f;
    private static final int SHIP_INIT_HEALTH = 3;
    private static final float SHOOT_DELAY = 0.8f;
    private static final float BULLET_HEIGHT = 0.01f;
    private static final Vector2 BULLET_SPEED = new Vector2(0, -0.45f);
    private static final int BULLET_DAMAGE = 1;


    private SmallEnemyShip() {
    }

    public static void transform(EnemyShip ship, TextureAtlas atlas) {
        ship.setupShip(
                Regions.split(atlas.findRegion(SHIP_ATLAS_REGION), 1, 2, 2),
                SHIP_HEIGHT,
                SHIP_SPEED,
                SHIP_INIT_HEALTH,
                BULLET_HEIGHT,
                BULLET_DAMAGE,
                BULLET_SPEED,
                SHOOT_DELAY
        );
    }
}
