package base.bulletDirection;

import base.PlayerBullet;
import base.Vector2D;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class RightBullet extends PlayerBullet {

//    Vector2D velocity;
    public RightBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0, 0);
//        this.velocity = new Vector2D(0,0);
    }

    @Override
    public void run() {
        this.position.addThis(2, -2);
    }

}
