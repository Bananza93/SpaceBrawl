package ru.geekbrains.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;
import ru.geekbrains.sprites.Bullet;
import ru.geekbrains.sprites.Explosion;

public abstract class BaseShip extends Sprite {

    private static final float DAMAGE_ANIMATE_INTERVAL = 0.1f;

    protected float shipHeight;
    protected float shipSpeed;
    protected int shipHealth;

    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;
    protected Sound shootSound;
    protected Vector2 bulletSpeed;
    protected Vector2 bulletPos;
    protected float bulletHeight;
    protected int bulletDamage;

    protected float shootDelay;
    protected float timeSinceLastShot;

    protected ExplosionPool explosionPool;
    private float damageAnimateTimer = DAMAGE_ANIMATE_INTERVAL;

    protected Rect worldBounds;

    protected boolean ableToShoot;

    public BaseShip() {
    }

    public BaseShip(TextureRegion region, int rows, int columns, int frames) {
        super(region, rows, columns, frames);
        this.ableToShoot = false;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(shipHeight);
    }

    @Override
    public void update(float delta) {
        if (this.getBottom() > worldBounds.getBottom() && this.getTop() < worldBounds.getTop()) {
            ableToShoot = true;
            if ((timeSinceLastShot += delta) >= shootDelay) {
                timeSinceLastShot -= shootDelay;
                shoot();
            }
        } else {
            ableToShoot = false;
        }

        damageAnimateTimer += delta;
        if (damageAnimateTimer >= DAMAGE_ANIMATE_INTERVAL) {
            frame = 0;
        }
    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletSpeed, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    public void damage(int damage) {
        shipHealth -= damage;
        if (shipHealth <= 0) {
            shipHealth = 0;
            destroy();
        }
        frame = 1;
        damageAnimateTimer = 0f;
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    private void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(pos, getHeight());
    }

    public int getShipHealth() {
        return shipHealth;
    }
}
