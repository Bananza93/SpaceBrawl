package ru.geekbrains.screen;

import com.badlogic.gdx.graphics.Texture;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprites.Aim;
import ru.geekbrains.sprites.Dart;
import ru.geekbrains.sprites.MenuBackground;

public class MenuScreen extends BaseScreen {

    private Texture menuBackground;
    private MenuBackground menuBackgroundSprite;

    private Texture aim;
    private Aim aimSprite;

    private Texture dart;
    private Dart dartSprite;

    @Override
    public void show() {
        super.show();
        menuBackground = new Texture("menu_background.jpg");
        menuBackgroundSprite = new MenuBackground(menuBackground);

        aim = new Texture("aim.png");
        aimSprite = new Aim(aim);

        dart = new Texture("dart.png");
        dartSprite = new Dart(dart);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw();
    }

    private void draw() {
        batch.begin();
        menuBackgroundSprite.draw(batch);
        aimSprite.draw(batch);
        dartSprite.draw(batch);
        batch.end();
    }

    @Override
    public boolean resize(Rect worldBounds) {
        super.resize(worldBounds);
        menuBackgroundSprite.resize(worldBounds);
        aimSprite.resize(worldBounds);
        dartSprite.resize(worldBounds);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        aimSprite.pos.set(getTouch());
        dartSprite.moveToAim(aimSprite);
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
        menuBackground.dispose();
        dart.dispose();
        aim.dispose();
    }
}
