package com.mygdx.gachibattle.updater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.gachibattle.elements.visual.VisualElement;

import java.util.ArrayList;
import java.util.List;

public class Render implements Updater {
    public OrthographicCamera camera;
    public SpriteBatch batch;
    public static Render INSTANCE = new Render();
    public List<VisualElement> visualElementList;

    private Render() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 0.25f;
        camera.update();
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        visualElementList = new ArrayList<>();
    }

    @Override
    public void update() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        for (VisualElement element : visualElementList) {
            batch.draw(element.value, element.position.getPosition().x, element.position.getPosition().y);
        }
        batch.end();
    }
}
