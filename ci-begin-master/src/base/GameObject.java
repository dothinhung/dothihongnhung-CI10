package base;

import base.renderer.Renderer;
import game.GameCanvas;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static Enemy createEnemy(){
        Enemy newEnemy = new Enemy();
        gameObjects.add(newEnemy);
        return newEnemy;
    }

    public static <E extends GameObject> E create(Class<E> childClass){
        try{
            GameObject newGameObject = childClass.newInstance();
            newGameObjects.add(newGameObject);
            return (E) newGameObject;
        }catch (Exception e){
            return null;
        }
    }

    public static void runAll(){
        for(GameObject go : gameObjects) {
            go.run();
        }
    }

    public static void addNewAll(){
        gameObjects.addAll(newGameObjects);
    }

    public static void renderAll(Graphics g){
        for(GameObject go : gameObjects){
            go.render(g);
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }


    public Renderer renderer;
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
