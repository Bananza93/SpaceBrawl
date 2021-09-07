package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;

public class Aim extends Sprite {

    public Aim(Texture region) {
        super(new TextureRegion(region));
        this.setHeight(0.1f);
        this.setWidth(0.1f);
    }

}
