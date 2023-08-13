package com.mygdx.gachibattle.loader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureLoader {
    public static TextureRegion[] getFrames(String atlasPath, int frameCols, int frameRows) {
        Texture walkSheet = new Texture(Gdx.files.internal(atlasPath));
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / frameCols,
                walkSheet.getHeight() / frameRows);
        TextureRegion[] frames = new TextureRegion[frameCols * frameRows];

        int index = 0;
        for (int i = 0; i < frameRows; i++) {
            for (int j = 0; j < frameCols; j++) {
                frames[index++] = tmp[i][j];
            }
        }

        return frames;
    }
}
