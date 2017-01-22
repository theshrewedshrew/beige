package com.region.screens;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.region.tween.SpriteAccessor;

/**
 * Created by Taylor on 1/21/2017.
 */
public class Splash implements Screen{

    private Sprite titleScreen;
    private SpriteBatch batch;
    private TweenManager tweenManager;
    @Override
    public void show() {
        batch = new SpriteBatch();

        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());

        Texture splashTexture = new Texture("core/assets/imgs/Layers.png");
        titleScreen = new Sprite(splashTexture);
        titleScreen.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Tween.set(titleScreen, SpriteAccessor.ALPHA).target(0).start(tweenManager);
        Tween.to(titleScreen, SpriteAccessor.ALPHA, 4).target(1).start(tweenManager);
        Tween.to(titleScreen, SpriteAccessor.ALPHA, 4).target(0).delay(15).start(tweenManager);

    }

    @Override
    public void render(float delta) {
        // delta is time between frames

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        tweenManager.update(delta);

        batch.begin();
        titleScreen.draw(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        dispose();
    }


}
