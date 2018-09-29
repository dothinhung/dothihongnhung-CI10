package base.renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Renderer {
    public abstract void render(Graphics g, GameObject master); //những hàm trừu tượng thì không có thân hàm abstract


}
