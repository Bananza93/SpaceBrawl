package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class BaseShip extends Sprite {

    public BaseShip(TextureRegion[][] regions) {
        super(regions);
    }

    public void hitHandling(int damage) {

    }

}
