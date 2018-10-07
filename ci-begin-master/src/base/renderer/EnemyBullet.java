package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    Vector2D velocity;
    BoxCollider collider;
    ArrayList<BufferedImage> images;
    public EnemyBullet(){
        super();
//        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
        ArrayList<BufferedImage> images = SpriteUtils.loadimages(
                "assets/images/enemies/bullets/blue.png",
                "assets/images/enemies/bullets/cyan.png",
                "assets/images/enemies/bullets/green.png",
                "assets/images/enemies/bullets/pink.png",
                "assets/images/enemies/bullets/red.png",
                "assets/images/enemies/bullets/white.png",
                "assets/images/enemies/bullets/yellow.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0,0);
        this.velocity = new Vector2D(0,0);
        this.collider = new BoxCollider(16,16);
    }

    @Override
    public void run() {
//        Player player = GameObject.intersect(Player.class, this);
        Player player = GameObject .interesct(Player.class, this);

        if(player != null){
            System.out.println("GAME OVER");
            this.destroy();

            player.destroy();

            return;
        }
        if(this.position.y > Settings.SCREEN_HEIGHT){
            this.destroy();
            return;
        }
        this.position.addThis(velocity.x, velocity.y);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return  this.collider;
    }
}