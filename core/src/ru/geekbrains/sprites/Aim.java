package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Aim extends Sprite {

    //private static final int AIM_WIDTH = 160;
    //private static final int AIM_HEIGHT = 160;

    public Aim(Texture region) {
        super(new TextureRegion(region));
        //regions[0].setRegionHeight(AIM_HEIGHT);
        //regions[0].setRegionWidth(AIM_WIDTH);
        this.setLeft(-0.28f);
        this.setBottom(-0.25f);
        this.setHeight(0.1f);
        this.setWidth(0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        //this.pos.set(new Vector2(-0.28f, -0.25f));
        //setHeightProportion(worldBounds.getHeight());
    }

    @Override
    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) (regions[frame].getRegionHeight());
        setWidth(height * aspect);
    }


}
