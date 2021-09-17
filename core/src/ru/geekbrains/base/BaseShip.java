package ru.geekbrains.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.sprites.Bullet;

public abstract class BaseShip extends Sprite {

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

    protected Rect worldBounds;

    protected boolean ableToShoot;

    public BaseShip() {
    }

    public BaseShip(TextureRegion region, int rows, int columns, int frames) {
        super(region.split(region.getRegionWidth() / columns, region.getRegionHeight() / rows), frames);
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

    }

    private void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletSpeed, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }

    public void hitHandling(int damage) {

    }

}
