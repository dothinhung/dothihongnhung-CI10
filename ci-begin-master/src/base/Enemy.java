package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public Enemy(){

        ArrayList<BufferedImage> images = SpriteUtils.loadimages("assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png");
        this.renderer = new AnimationRenderer(images,2);
        position = new Vector2D(200,300);
    }


    @Override
    public void run() {
        this.position.y ++;
    }
}