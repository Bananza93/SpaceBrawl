package ru.geekbrains.sprites.enemy_ship_blueprints;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprites.EnemyShip;
import ru.geekbrains.utils.Regions;

public class MediumEnemyShip {

    private static final float SHIP_HEIGHT = 0.15f;
    private static final String SHIP_ATLAS_REGION = "enemy1";
    private static final float SHIP_SPEED = 0.002f;
    private static final int SHIP_INIT_HEALTH = 5;
    private static final float SHOOT_DELAY = 1.5f;
    private static final float BULLET_HEIGHT = 0.02f;
    private static final Vector2 BULLET_SPEED = new Vector2(0, -0.45f);
    private static final int BULLET_DAMAGE = 5;


    private MediumEnemyShip() {
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
