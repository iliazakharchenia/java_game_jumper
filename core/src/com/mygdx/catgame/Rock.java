package com.mygdx.catgame;

import java.util.Random;

public class Rock {
    public boolean isAlive = true;
    public int y;
    public int x;

    private Random random = new Random();

    public void update(double speedX) {
        this.x -= speedX;
        if (this.x < -50) {
            this.x = random.nextInt(500) + 850;
        }
    }

    public Rock(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
