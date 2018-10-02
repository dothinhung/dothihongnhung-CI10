package game;

import base.*;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;


    public GameCanvas() {
        this.background = GameObject.create(Background.class);
        this.player = GameObject.create(Player.class);

        Enemy enemy = GameObject.create(Enemy.class);
    }

    public void run() {
       GameObject.runAll();
    }

    public void render(Graphics g) {
        GameObject.renderAll(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
