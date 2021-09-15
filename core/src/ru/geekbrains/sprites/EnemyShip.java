package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.base.BaseShip;

public class EnemyShip extends BaseShip {

    private static final Sound ENEMY_SHIP_SHOOT_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/bullet.wav"));
    private static final String ENEMY_SHIP_BULLET_ATLAS_REGION = "bulletEnemy";

    public EnemyShip(TextureAtlas atlas, BulletPool bulletPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.shootSound = ENEMY_SHIP_SHOOT_SOUND;
        this.bulletRegion = atlas.findRegion(ENEMY_SHIP_BULLET_ATLAS_REGION);
        this.bulletSpeed = new Vector2();
        this.bulletPos = new Vector2();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        this.bulletPos.set(pos.x, pos.y - getHalfHeight());
        this.pos.sub(0.0f, this.shipSpeed);
    }

    public void setupShip(
            TextureRegion[] regions,
            float shipHeight,
            float shipSpeed,
            int shipHealth,
            float bulletHeight,
            int bulletDamage,
            Vector2 bulletSpeed,
            float shootDelay
    ) {
        this.regions = regions;
        this.shipHeight = shipHeight;
        this.shipSpeed = shipSpeed;
        this.shipHealth = shipHealth;
        this.bulletHeight = bulletHeight;
        this.bulletSpeed.set(bulletSpeed);
        this.bulletDamage = bulletDamage;
        this.shootDelay = shootDelay;
        setHeightProportion(shipHeight);
    }
}
