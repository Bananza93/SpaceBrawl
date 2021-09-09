package ru.geekbrains.sprites;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.BaseShip;
import ru.geekbrains.math.Rect;

public class MainShip extends BaseShip {

    private final float HEIGHT = 0.15f;
    private final float INIT_Y_PADDING = 0.05f;
    private final float SPEED = 0.005f;
    private boolean isMovingForward = false;
    private boolean isMovingBackward = false;
    private boolean isMovingLeft = false;
    private boolean isMovingRight = false;
    private Rect worldBounds;

    public MainShip(TextureRegion region) {
        super(region.split(region.getRegionWidth() / 2, region.getRegionHeight()));
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(HEIGHT);
        setLeft(0f - halfWidth);
        setBottom(worldBounds.getBottom() + INIT_Y_PADDING);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if (isMovingForward && !isMovingBackward) goForward();
        if (isMovingBackward && !isMovingForward) goBackward();
        if (isMovingLeft && !isMovingRight) goLeft();
        if (isMovingRight && !isMovingLeft) goRight();
    }

    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            isMovingForward = true;
        } else if (keycode == Input.Keys.DOWN) {
            isMovingBackward = true;
        } else if (keycode == Input.Keys.LEFT) {
            isMovingLeft = true;
        } else if (keycode == Input.Keys.RIGHT) {
            isMovingRight = true;
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP) {
            isMovingForward = false;
        } else if (keycode == Input.Keys.DOWN) {
            isMovingBackward = false;
        } else if (keycode == Input.Keys.LEFT) {
            isMovingLeft = false;
        } else if (keycode == Input.Keys.RIGHT) {
            isMovingRight = false;
        }
        return false;
    }

    private void goRight() {
        if (worldBounds.getRight() - this.getRight() > SPEED) {
            this.pos.add(SPEED, 0f);
        }
    }

    private void goLeft() {
        if (this.getLeft() - worldBounds.getLeft() > SPEED) {
            this.pos.sub(SPEED, 0f);
        }
    }

    private void goBackward() {
        if (this.getBottom() - worldBounds.getBottom() > SPEED) {
            this.pos.sub(0f, SPEED);
        }
    }

    private void goForward() {
        if (worldBounds.getTop() - this.getTop() > SPEED) {
            this.pos.add(0f, SPEED);
        }
    }

}
