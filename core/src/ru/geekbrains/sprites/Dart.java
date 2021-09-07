package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class Dart extends Sprite {

    private static final float SPEED = 0.01f;
    private Vector2 currentAimPos = new Vector2();
    private Vector2 distanceToAim = new Vector2();
    private Vector2 speedVector = new Vector2();
    private Vector2 tmp = new Vector2();
    private Vector2 centerToRight;
    private boolean isNeedToMove = false;

    public Dart(Texture region) {
        super(new TextureRegion(region));
        this.setHeight(0.04f);
        this.setWidth(0.09f);
        centerToRight = this.pos.cpy().add(this.getRight(), this.pos.y);
    }

    public void moveToAim(Aim aimSprite) {
        isNeedToMove = true;
        currentAimPos = aimSprite.pos.cpy();
        distanceToAim = currentAimPos.cpy().sub(this.pos);
        speedVector.set(distanceToAim).setLength(SPEED);
        this.setAngle(distanceToAim.angleDeg());
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (isNeedToMove) {
            tmp.set(currentAimPos);
            if (tmp.sub(this.pos).len() - centerToRight.len() > SPEED) {
                this.pos.add(speedVector);
            } else {
                this.pos.add(tmp.setLength(tmp.len() - centerToRight.len()));
                isNeedToMove = false;
            }
        }
    }
}
