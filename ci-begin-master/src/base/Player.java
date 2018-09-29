package base;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    public Player() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));


        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.SCREEN_PLAYER_POSITION_X, Settings.SCREEN_PLAYER_POSITION_Y);

    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress) {
            this.move(0, -1);
        }else if(KeyEventPress.isDownPress){
            this.move(0,1);
        }else if(KeyEventPress.isRightPress){
            this.move(1,0);
        }else if(KeyEventPress.isLeftPress){
            this.move(-1,0);
        }
    }

    public void move(int translateX, int translateY) {
        this.position.addThis(translateX,translateY);
//        this.x = this.x + translateX;
//        this.y = this.y + translateY;
        //vector.add(x,y)
        //vector.subtract(x,y)
        //vector.scale(number)
    }
}
