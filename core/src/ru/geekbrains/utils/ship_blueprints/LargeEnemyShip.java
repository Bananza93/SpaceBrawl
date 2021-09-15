package ru.geekbrains.utils.ship_blueprints;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprites.EnemyShip;
import ru.geekbrains.utils.Regions;

public class LargeEnemyShip {
    private static final float SHIP_HEIGHT = 0.2f;
    private static final String SHIP_ATLAS_REGION = "enemy2";
    private static final float SHIP_SPEED = 0.002f;
    private static final int SHIP_INIT_HEALTH = 10;
    private static final float SHOOT_DELAY = 1.2f;
    private static final float BULLET_HEIGHT = 0.02f;
    private static final Vector2 BULLET_SPEED = new Vector2(0, -0.25f);
    private static final int BULLET_DAMAGE = 10;


    private LargeEnemyShip() {
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
