package game;

import base.KeyEventPress;
import base.Settings;
import game.GameCanvas;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {
        //setup window
        this.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListtener();
        //init game
        this.canvas = new GameCanvas();
        this.add(canvas);

        this.setVisible(true);
    }

    private void setupEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }else if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isDownPress = true;
                }else if(e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isRightPress = true;
                }else if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }else if(e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isDownPress = false;
                }else if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isRightPress = false;
                }else if(e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }
            }
        });
    }

    //vòng lặp game suốt quá trình game chạy
    void gameLoop() {
        long delay = 1000 / 60;
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                canvas.run();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
