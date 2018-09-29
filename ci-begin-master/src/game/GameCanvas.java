package game;

import base.Background;
import base.Enemy;
import base.Player;
import base.PlayerBullet;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;


    //tạo araylist lưu enamies
    public static ArrayList<Enemy> enemies;
    public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();

        // homework
        enemies = new ArrayList<Enemy>();
        playerBullets = new ArrayList<PlayerBullet>();
    }

    public void run() {
        background.run();
        player.run();
    }

    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        for(Enemy enemy : enemies){
            enemy.render(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
