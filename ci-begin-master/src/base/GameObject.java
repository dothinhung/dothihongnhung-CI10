package base;

import base.renderer.Renderer;

import java.awt.*;

public class GameObject {
    Renderer renderer;
    public Vector2D position;


    public GameObject() {}

    public void run() { //chạy game logic

    }

    public void render(Graphics g) { //chạy game hiển thị
        if(this.renderer != null) {
            this.renderer.render(g,this);
        }
    }
}
