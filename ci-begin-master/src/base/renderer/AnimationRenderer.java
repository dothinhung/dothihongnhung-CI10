package base.renderer;

import base.GameObject;
import base.counter.FrameCounter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {

    ArrayList<BufferedImage> images;
    int currentImage = 0;
    FrameCounter frameCount;

    public AnimationRenderer(ArrayList<BufferedImage> images){
        this.images = images;
        this.frameCount = new FrameCounter(5);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images, int frameCount){
        this.images = images;
        this.frameCount = new FrameCounter(5);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if(images.size() > 0){
            g.drawImage(images.get(currentImage),
                    (int)master.position.x,
                    (int)master.position.y,
                    null);
            if(this.frameCount.run()){
                currentImage++;
                if(currentImage >= images.size() - 1){
                    currentImage =0;
            }
            this.frameCount.reset();
            }
        }
    }
}
