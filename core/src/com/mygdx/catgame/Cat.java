package com.mygdx.catgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Cat {
    public boolean inJump = false;
    public boolean isAlive = true;
    public int y;
    public int x;
    public int startY;
    public double speedX = 0;
    public double speedY = 0;

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !inJump) {
            speedY = +8.5;
            inJump = true;
        }
        if (inJump) {
            speedY -= 0.2;
            y += speedY;
        }
        if (y-startY <= 0) {
            inJump = false;
        }
    }

    public Cat(int x, int y, double speedX) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.startY = y;
    }
}
