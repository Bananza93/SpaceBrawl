package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Aim extends Sprite {

    public Aim(Texture region) {
        super(new TextureRegion(region));
        this.setLeft(-0.28f);
        this.setBottom(-0.25f);
        this.setHeight(0.1f);
        this.setWidth(0.1f);
    }
}
