package base;

import base.bulletDirection.LeftBullet;
import base.bulletDirection.RightBullet;
import base.bulletDirection.StraightBullet;
import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics{
    boolean isValidFire;
    FrameCounter fireCounter;
    BoxCollider collider;
    int hp;
    public Player() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadimages("assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png");


        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.SCREEN_PLAYER_POSITION_X, Settings.SCREEN_PLAYER_POSITION_Y);
//        this.isValidFire = true;
        this.fireCounter = new FrameCounter(20);
        this.collider = new BoxCollider(32,48);
        this.hp = 20;
    }

    @Override
    public void run() {
        boolean fireCounterRun = this.fireCounter.run();

        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }
        if(KeyEventPress.isDownPress){
            this.move(0,1);
        }
        if(KeyEventPress.isRightPress){
            this.move(1,0);
        }
        if(KeyEventPress.isLeftPress){
            this.move(-1,0);
        }
        if(KeyEventPress.isFirePress && fireCounterRun){
            this.fire();
        }
    }

    public void fire(){
//        PlayerBullet bullet = new PlayerBullet();
//        GameCanvas.playerBullets.add(bullet);
        PlayerBullet bullet = GameObject.recycle(StraightBullet.class);
        PlayerBullet bullet1 = GameObject.recycle(LeftBullet.class);
        PlayerBullet bullet2 = GameObject.recycle(RightBullet.class);

        bullet.position.set(this.position.x, this.position.y);
        bullet1.position.set(this.position.x, this.position.y);
        bullet2.position.set(this.position.x, this.position.y);

        /*
        *
        */


        this.fireCounter.reset();
    }

    public void move(int translateX, int translateY) {

        this.position.addThis(translateX,translateY);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if(this.hp <= 0){
//            this.isActive = false;
            this.destroy();
            hp = 0;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
