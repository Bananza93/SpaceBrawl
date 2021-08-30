package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture menuBackground;

    private static final int AIM_WIDTH = 160;
    private static final int AIM_HEIGHT = 160;
    private Texture aim;
    private Sprite aimSprite;
    private Vector2 aimCenterPos;

    private static final int DART_WIDTH = 140;
    private static final int DART_HEIGHT = 80;
    private Texture dart;
    private Sprite dartSprite;
    private Vector2 dartCenterPos;
    private Vector2 dartSpeed;

    private boolean isTapped;

    @Override
    public void show() {
        super.show();
        menuBackground = new Texture("menu_background.jpg");

        aim = new Texture("aim.png");
        aimSprite = new Sprite(aim);
        aimCenterPos = new Vector2(AIM_WIDTH / 2.0f, AIM_HEIGHT / 2.0f);
        aimSprite.setSize(AIM_WIDTH, AIM_HEIGHT);
        aimSprite.setOrigin(aimCenterPos.x, aimCenterPos.y);

        dart = new Texture("dart.png");
        dartSprite = new Sprite(dart);
        dartCenterPos = new Vector2(DART_WIDTH, DART_HEIGHT / 2.0f);
        dartSpeed = new Vector2(20.0f, 20.0f);
        dartSprite.setSize(DART_WIDTH, DART_HEIGHT);
        dartSprite.setOrigin(dartCenterPos.x, dartCenterPos.y);

        isTapped = false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        float imageRatioH = (float) Gdx.graphics.getHeight() / menuBackground.getHeight();
        float imageRatioW = (float) Gdx.graphics.getWidth() / menuBackground.getWidth();
        int scaledHeight = (int) (menuBackground.getHeight() * imageRatioH);
        int scaledWidth = (int) (menuBackground.getWidth() * imageRatioW);
        batch.getProjectionMatrix().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.begin();
        batch.draw(menuBackground, 0, 0, scaledWidth, scaledHeight);
        aimSprite.setPosition(aimCenterPos.x - AIM_WIDTH / 2.0f, aimCenterPos.y - AIM_HEIGHT / 2.0f);
        aimSprite.draw(batch);
        dartSprite.setPosition(dartCenterPos.x - DART_WIDTH, dartCenterPos.y - DART_HEIGHT / 2.0f);
        dartSprite.draw(batch);
        if (isTapped) {
            float distX = aimCenterPos.x - dartCenterPos.x;
            float distY = aimCenterPos.y - dartCenterPos.y;
            float distLen = (float) Math.sqrt(distX * distX + distY * distY);
            float stepByX = distX / distLen;
            float stepByY = distY / distLen;
            float expectedDistX = stepByX * dartSpeed.x;
            float expectedDistY = stepByY * dartSpeed.y;
            float expectedDist = (float) Math.sqrt(expectedDistX * expectedDistX + expectedDistY * expectedDistY);
            if (distLen < expectedDist) {
                dartCenterPos.set(dartCenterPos.x + distX, dartCenterPos.y + distY);
                isTapped = false;
            } else {
                dartCenterPos.set(dartCenterPos.x + expectedDistX, dartCenterPos.y + expectedDistY);
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        menuBackground.dispose();
        dart.dispose();
        aim.dispose();
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        aimCenterPos.set(screenX, Gdx.graphics.getHeight() - screenY);
        dartSprite.setRotation(aimCenterPos.cpy().sub(dartCenterPos.x, dartCenterPos.y).angleDeg());
        isTapped = true;
        return false;
    }
}
