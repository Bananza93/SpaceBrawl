package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprites.Aim;
import ru.geekbrains.sprites.Dart;
import ru.geekbrains.sprites.MenuBackground;

public class MenuScreen extends BaseScreen {

    private Texture menuBackground;
    private MenuBackground menuBackgroundSprite;

//    private static final int AIM_WIDTH = 160;
//    private static final int AIM_HEIGHT = 160;
    private Texture aim;
    private Aim aimSprite;
//    private Sprite aimSprite;
//    private Vector2 aimCenterPos;
//
//    private static final int DART_WIDTH = 140;
//    private static final int DART_HEIGHT = 80;
    private Texture dart;
    private Dart dartSprite;
//    private Sprite dartSprite;
//    private Vector2 dartCenterPos;
//    private Vector2 dartSpeed;
//
//    private Vector2 distToAimVec;
//    private Vector2 distToAimCurrentStepVec;
//    private boolean isTapped;

    @Override
    public void show() {
        super.show();
        menuBackground = new Texture("menu_background.jpg");
        menuBackgroundSprite = new MenuBackground(menuBackground);

        aim = new Texture("aim.png");
        aimSprite = new Aim(aim);
//        aimSprite = new Sprite(aim);
//        aimCenterPos = new Vector2(AIM_WIDTH / 2.0f, AIM_HEIGHT / 2.0f);
//        aimSprite.setSize(AIM_WIDTH, AIM_HEIGHT);
//        aimSprite.setOriginCenter();
//
        dart = new Texture("dart.png");
        dartSprite = new Dart(dart);
//        dartSprite = new Sprite(dart);
//        dartCenterPos = new Vector2(DART_WIDTH, DART_HEIGHT / 2.0f);
//        dartSpeed = new Vector2(20.0f, 20.0f);
//        dartSprite.setSize(DART_WIDTH, DART_HEIGHT);
//        dartSprite.setOrigin(dartCenterPos.x, dartCenterPos.y);
//
//        distToAimCurrentStepVec = new Vector2(0,0);
//
//        isTapped = false;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        menuBackgroundSprite.resize(worldBounds);
        aimSprite.resize(worldBounds);
        dartSprite.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        menuBackground.dispose();
//        dart.dispose();
//        aim.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        aimSprite.pos.set(getTouch());
//        aimCenterPos.set(screenX, Gdx.graphics.getHeight() - screenY);
//        distToAimVec = new Vector2(aimCenterPos.cpy().sub(dartCenterPos));
//        dartSprite.setRotation(aimCenterPos.cpy().sub(dartCenterPos).angleDeg());
//        isTapped = true;
        return false;
    }

    private void draw() {
        batch.begin();
        menuBackgroundSprite.draw(batch);
        aimSprite.draw(batch);
        dartSprite.draw(batch);
        //        aimSprite.setPosition(aimCenterPos.x - AIM_WIDTH / 2.0f, aimCenterPos.y - AIM_HEIGHT / 2.0f);
//        aimSprite.draw(batch);
//        dartSprite.setPosition(dartCenterPos.x - DART_WIDTH, dartCenterPos.y - DART_HEIGHT / 2.0f);
//        dartSprite.draw(batch);
//        if (isTapped) {
//            float stepByX = distToAimVec.x / distToAimVec.len();
//            float stepByY = distToAimVec.y / distToAimVec.len();
//            distToAimCurrentStepVec.set(stepByX * dartSpeed.x, stepByY * dartSpeed.y);
//            if (distToAimVec.len2() < distToAimCurrentStepVec.len2()) {
//                dartCenterPos.add(distToAimVec);
//                isTapped = false;
//            } else {
//                dartCenterPos.add(distToAimCurrentStepVec);
//                distToAimVec.sub(distToAimCurrentStepVec);
//            }
//        }
        batch.end();
    }
}
