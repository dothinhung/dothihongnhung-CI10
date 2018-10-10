package base.enemy;

import base.*;
import base.action.*;
import base.counter.FrameCounter;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;
    Action action;
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
        this.defineAction();

    }

    void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action actionLeft = new Action() {
            @Override
            public void run(GameObject master) {
                if(position.x>9) {
                    position.addThis(-6, 5);

                }
                this.isDone=true;
            }

            @Override
            public void reset() {
                this.isDone=false;

            }
        };



        ActionParallel actionParallel = new ActionParallel(actionLeft, actionFire);

        ActionSequence actionSequence = new ActionSequence(actionWait,actionParallel);

        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);


        this.action = actionRepeat;

    }

    public void fire(){

        EnemyBullet bullet2 = GameObject.recycle(EnemyBullet.class);

        bullet2.velocity.set(0,1);

        bullet2.position.set(this.position.x, this.position.y +5);


    }

    @Override
    public void run() {
        this.action.run(this);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}