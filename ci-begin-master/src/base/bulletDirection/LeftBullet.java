package base.bulletDirection;

import base.player.PlayerBullet;
import base.Vector2D;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class LeftBullet extends PlayerBullet {
    public LeftBullet() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0, 0);
    }

    @Override
    public void run() {
        this.position.addThis(-3, -3);
    }
}
