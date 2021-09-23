package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.base.BaseShip;
import ru.geekbrains.pool.ExplosionPool;

public class EnemyShip extends BaseShip {

    private final Sound SHOOT_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/bullet.wav"));
    private static final String BULLET_ATLAS_REGION = "bulletEnemy";

    public EnemyShip(TextureAtlas atlas, BulletPool bulletPool, ExplosionPool explosionPool, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.shootSound = SHOOT_SOUND;
        this.bulletRegion = atlas.findRegion(BULLET_ATLAS_REGION);
        this.bulletSpeed = new Vector2();
        this.bulletPos = new Vector2();
        this.explosionPool = explosionPool;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        this.bulletPos.set(pos.x, pos.y - getHalfHeight());
        float speed = this.ableToShoot ? this.shipSpeed : this.shipSpeed * 2;
        this.pos.sub(0.0f, speed);
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
        this.timeSinceLastShot = shootDelay;
        setHeightProportion(shipHeight);
    }

    @Override
    public void destroy() {
        super.destroy();
        this.ableToShoot = false;
    }

    public boolean isCollision(Rect rect) {
        return !(
                rect.getRight() < getLeft()
                        || rect.getLeft() > getRight()
                        || rect.getBottom() > getTop()
                        || rect.getTop() < pos.y
        );
    }
}
