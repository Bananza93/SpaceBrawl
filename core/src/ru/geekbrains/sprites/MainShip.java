package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseShip;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.pool.ExplosionPool;

public class MainShip extends BaseShip {

    private static final float SHIP_HEIGHT = 0.1f;
    private static final float SHIP_Y_PADDING = 0.05f;
    private static final float SHIP_SPEED = 0.0075f;
    private static final int SHIP_INIT_HEALTH = 100;
    private static final float SHOOT_DELAY = 0.35f;
    private static final float BULLET_HEIGHT = 0.01f;
    private static final Vector2 BULLET_SPEED = new Vector2(0, 0.5f);
    private static final int BULLET_DAMAGE = 1;
    private final Sound SHOOT_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/laser.wav"));

    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;

    public MainShip(TextureAtlas atlas, BulletPool bulletPool, ExplosionPool explosionPool) {
        super(atlas.findRegion("main_ship"), 1, 2, 2);
        this.shipHeight = SHIP_HEIGHT;
        this.shipSpeed = SHIP_SPEED;
        this.shipHealth = SHIP_INIT_HEALTH;
        this.bulletPool = bulletPool;
        this.bulletRegion = atlas.findRegion("bulletMainShip");
        this.bulletHeight = BULLET_HEIGHT;
        this.bulletSpeed = BULLET_SPEED;
        this.bulletDamage = BULLET_DAMAGE;
        this.shootDelay = SHOOT_DELAY;
        this.timeSinceLastShot = SHOOT_DELAY;
        this.shootSound = SHOOT_SOUND;
        this.bulletPos = new Vector2();
        this.explosionPool = explosionPool;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + SHIP_Y_PADDING);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        bulletPos.set(pos.x, pos.y + getHalfHeight());
        if (isMovingLeft && !isMovingRight) goLeft();
        if (isMovingRight && !isMovingLeft) goRight();
    }

    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            isMovingLeft = true;
        } else if (keycode == Input.Keys.RIGHT) {
            isMovingRight = true;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            isMovingLeft = false;
        } else if (keycode == Input.Keys.RIGHT) {
            isMovingRight = false;
        }
        return false;
    }

    private void goLeft() {
        if (this.getLeft() - worldBounds.getLeft() > this.shipSpeed) {
            this.pos.sub(this.shipSpeed, 0f);
        }
    }

    private void goRight() {
        if (worldBounds.getRight() - this.getRight() > this.shipSpeed) {
            this.pos.add(this.shipSpeed, 0f);
        }
    }

    public boolean isCollision(Rect rect) {
        return !(
                rect.getRight() < getLeft()
                        || rect.getLeft() > getRight()
                        || rect.getBottom() > pos.y
                        || rect.getTop() < getBottom()
        );
    }
}
