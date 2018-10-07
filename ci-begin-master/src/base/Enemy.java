package base;

import base.EnemyBullet;
import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics{
    FrameCounter fireCounter;
    BoxCollider collider;
    public Enemy(){
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadimages("assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png");
        this.renderer = new AnimationRenderer(images,2);
        this.position = new Vector2D(300,100);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(28,28);
    }

    public void fire(){
//        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
//        EnemyBullet bullet1 = GameObject.recycle(EnemyBullet.class);
        EnemyBullet bullet2 = GameObject.recycle(EnemyBullet.class);



//        bullet.velocity.set(1,0);
//        bullet1.velocity.set(1,-1);
        bullet2.velocity.set(0,1);

//        bullet.position.set(this.position.x, this.position.y);
//        bullet1.position.set(this.position.x, this.position.y);
        bullet2.position.set(this.position.x, this.position.y);


        this.fireCounter.reset();

    }

    @Override
    public void run() {
//        this.position.y ++;
        boolean fireCounterRun = this.fireCounter.run();
        if(fireCounterRun){
            this.fire();
            this.fireCounter.reset();
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}