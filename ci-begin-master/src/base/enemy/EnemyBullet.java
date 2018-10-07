package base.enemy;

import base.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    Vector2D velocity;
    BoxCollider collider;
    ArrayList<BufferedImage> images;
    int damage;
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
        this.position = new Vector2D(0,0); //vị trí
        this.velocity = new Vector2D(0,0);
        this.collider = new BoxCollider(16,16);
        this.damage = 4;
    }

    @Override
    public void run() {
//        Player player = GameObject.intersect(Player.class, this);
        Player player = GameObject.interesct(Player.class, this);

        if(player != null){
//            System.out.println("GAME OVER");
            player.takeDamage(this.damage);
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

    public void takeDamage(int damage){
        this.damage = damage;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return  this.collider;
    }
}