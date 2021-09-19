package ru.geekbrains.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Explosion extends Sprite {

    private static final float ANIMATE_INTERVAL = 0.015f;
    private final Sound EXPLOSION_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));

    private float animateTimer;

    public Explosion(TextureAtlas atlas) {
        super(atlas.findRegion("explosion"), 9, 9, 74);
    }

    public void set(Vector2 pos, float height) {
        this.pos.set(pos);
        setHeightProportion(height);
        EXPLOSION_SOUND.play();
    }

    @Override
    public void update(float delta) {
        animateTimer += delta;
        if (animateTimer >= ANIMATE_INTERVAL) {
            animateTimer = 0f;
            if (++frame == regions.length) {
                destroy();
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        frame = 0;
    }
}
