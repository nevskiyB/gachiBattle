package com.mygdx.gachibattle.updater.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gachibattle.entity.utils.components.view.ViewComponent;

import java.util.ArrayList;
import java.util.List;

public class Render {
    public OrthographicCamera camera;
    public final SpriteBatch batch;
    public static Render INSTANCE = new Render();
    public List<ViewComponent> visualElementList;

    private Render() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 0.25f;
        camera.update();
        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        visualElementList = new ArrayList<>();
    }
}
