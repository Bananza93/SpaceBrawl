package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Dart extends Sprite {


    public Dart(Texture region) {
        super(new TextureRegion(region));
        //this.setLeft(-0.28f);
        //this.setBottom(-0.25f);
        this.setHeight(0.04f);
        this.setWidth(0.09f);
    }

    @Override
    public void resize(Rect worldBounds) {
        //this.pos.set(new Vector2(-0.5f, -0.5f));
        //setHeightProportion(worldBounds.getHeight());
    }

    @Override
    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) (regions[frame].getRegionHeight());
        setWidth(height * aspect);
    }
}
