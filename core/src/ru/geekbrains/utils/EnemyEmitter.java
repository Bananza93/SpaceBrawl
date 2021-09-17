package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.EnemyPool;
import ru.geekbrains.sprites.EnemyShip;
import ru.geekbrains.sprites.enemy_ship_blueprints.LargeEnemyShip;
import ru.geekbrains.sprites.enemy_ship_blueprints.MediumEnemyShip;
import ru.geekbrains.sprites.enemy_ship_blueprints.SmallEnemyShip;

public class EnemyEmitter {

    private static final float GENERATE_INTERVAL = 4f;
    private static final float SIDE_INDENT = 0.01f;

    private final Rect worldBounds;
    private float generateTimer;
    private final EnemyPool enemyPool;
    private final TextureAtlas atlas;

    public EnemyEmitter(TextureAtlas atlas, EnemyPool enemyPool, Rect worldBounds) {
        this.atlas = atlas;
        this.enemyPool = enemyPool;
        this.worldBounds = worldBounds;
    }

    public void generate(float delta) {
        generateTimer += delta;
        if (generateTimer >= GENERATE_INTERVAL) {
            generateTimer = 0f;
            EnemyShip enemyShip = enemyPool.obtain();
            float type = (float) Math.random();
            if (type <= 0.65f) {
                SmallEnemyShip.transform(enemyShip, atlas);
            } else if (type <= 0.9f) {
                MediumEnemyShip.transform(enemyShip, atlas);
            } else {
                LargeEnemyShip.transform(enemyShip, atlas);
            }
            enemyShip.pos.x = MathUtils.random(
                    worldBounds.getLeft() + enemyShip.getHalfWidth() + SIDE_INDENT,
                    worldBounds.getRight() - enemyShip.getHalfWidth() - SIDE_INDENT
            );
            enemyShip.setBottom(worldBounds.getTop());
        }
    }
}
