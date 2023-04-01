package com.mygdx.catgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture catTexture, rockTexture, platformTexture;
	private Cat cat;
	private Rock rock;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		catTexture = new Texture("cat-walk-right-1.png");
		rockTexture = new Texture("rock.png");
		platformTexture = new Texture("platform.png");
		cat = new Cat(120,245, 3);
		rock = new Rock(600, 250);
	}

	@Override
	public void render () {
		if (!cat.isAlive) {
			return;
		}
		ScreenUtils.clear(0.6f, 0.6f, 0.6f, 1);
		update();
		batch.begin();
		batch.draw(platformTexture, 0, 245);
		batch.draw(catTexture, cat.x, cat.y);
		batch.draw(rockTexture, rock.x, rock.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		catTexture.dispose();
		rockTexture.dispose();
		platformTexture.dispose();
	}

	public void update() {
		cat.update();
		rock.update(cat.speedX);
		if (Math.abs(cat.x+50-rock.x-20)<20 &&
				Math.abs(cat.y+10-rock.y-20)<20) {
			cat.isAlive = false;
		}
	}

	public void restart() {
	}
}
