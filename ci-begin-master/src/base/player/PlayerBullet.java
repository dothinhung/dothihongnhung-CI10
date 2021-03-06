package base.player;

import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.enemy.Enemy;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider collider;
    public ArrayList<BufferedImage> images;

    public PlayerBullet(){
        super();
        images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new AnimationRenderer(images);
//        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X, Settings.START_PLAYER_POSITION_Y);

        ArrayList<BufferedImage> images = SpriteUtils.loadimages("assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png");
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0,0);
        this.collider = new BoxCollider(24,24);
    }


    public void move(int moveY){
        this.position.addThis(0,moveY);
    }


  @Override
    public void run() {
        Enemy enemy = GameObject.interesct(Enemy.class,this);
        if (enemy != null){
            enemy.destroy();
            this.destroy();
            return;
        }
        if(this.position.y < 0){
            this.destroy();
            return;

        }
//        super.run();
//        this.position.y -= 10;
//        this.position.addThis(0,-3);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}