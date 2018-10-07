package base.bulletDirection;

import base.player.PlayerBullet;
import base.Vector2D;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class StraightBullet extends PlayerBullet {
    public StraightBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/player-bullets/a/3.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        this.position.addThis(0, -1);
    }
}
