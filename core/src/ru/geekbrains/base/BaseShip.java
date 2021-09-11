package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class BaseShip extends Sprite {

    public BaseShip(TextureRegion region, int rows, int columns, int frames) {
        super(region.split(region.getRegionWidth() / columns, region.getRegionHeight() / rows), frames);
    }

    public void hitHandling(int damage) {

    }

}
