package ru.geekbrains.pool;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprites.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final TextureAtlas atlas;
    private final BulletPool bulletPool;
    private final ExplosionPool explosionPool;
    private final Rect worldBounds;

    public EnemyPool(TextureAtlas atlas, BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.atlas = atlas;
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.explosionPool = explosionPool;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(atlas, bulletPool, explosionPool, worldBounds);
    }
}
