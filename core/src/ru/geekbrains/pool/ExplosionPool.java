package ru.geekbrains.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprites.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private final TextureAtlas atlas;

    public ExplosionPool(TextureAtlas atlas) {
        this.atlas = atlas;
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(atlas);
    }
}
