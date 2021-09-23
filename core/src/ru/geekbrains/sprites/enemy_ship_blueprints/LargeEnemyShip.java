package ru.geekbrains.sprites.enemy_ship_blueprints;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprites.EnemyShip;
import ru.geekbrains.utils.Regions;

public class LargeEnemyShip {

    private static final float SHIP_HEIGHT = 0.2f;
    private static final String SHIP_ATLAS_REGION = "enemy2";
    private static final float SHIP_SPEED = 0.001f;
    private static final int SHIP_INIT_HEALTH = 10;
    private static final float SHOOT_DELAY = 2.0f;
    private static final float BULLET_HEIGHT = 0.04f;
    private static final Vector2 BULLET_SPEED = new Vector2(0, -0.45f);
    private static final int BULLET_DAMAGE = 10;


    private LargeEnemyShip() {
    }

    public static void transform(EnemyShip ship, TextureAtlas atlas, int level) {
        ship.setupShip(
                Regions.split(atlas.findRegion(SHIP_ATLAS_REGION), 1, 2, 2),
                SHIP_HEIGHT,
                SHIP_SPEED,
                SHIP_INIT_HEALTH,
                BULLET_HEIGHT,
                BULLET_DAMAGE * level,
                BULLET_SPEED,
                SHOOT_DELAY
        );
    }
}
