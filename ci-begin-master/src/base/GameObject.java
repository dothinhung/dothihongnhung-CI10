package base;

import base.enemy.Enemy;
import base.physics.Physics;
import base.player.Player;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static Enemy createEnemy() {
        Enemy newEnemy = new Enemy();
        gameObjects.add(newEnemy);
        return newEnemy;
    }

    public static <E extends GameObject> E create(Class<E> childClass) {
        try {
            GameObject newGameObject = childClass.newInstance();
            newGameObjects.add(newGameObject);
            return (E) newGameObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static <E extends GameObject> E recycle(Class<E> childclass) {
        //Kiểm tra có gameobject thỏa mã y/c (isActive = false && go instanceof childclass )không
        //- có thì dùng lại
        //-Không có thì tạo mới
        //2. Trả về gameobject
        for (GameObject go : gameObjects) {
            if (!go.isActive && go.getClass().isAssignableFrom(childclass)) {
                go.isActive = true;
                return (E) go;
            }
        }
        return create(childclass);

    }

    // kiểm tra 1 object truyền vào có va chạm vs bất kì object nào trong game hay k
    public static <E extends GameObject> E interesct(Class<E> childClass, Physics physics) {

        for (GameObject go : gameObjects) {
            if (go instanceof Player) {
//                System.out.println(go.isActive && childClass.isAssignableFrom(go.getClass())
//                        && go instanceof Physics);
            }
            if (go.isActive && childClass.isAssignableFrom(go.getClass())
                    && go instanceof Physics) {
                Physics physicsGo = (Physics) go;
                boolean intersected = physics.getBoxCollider().intersect(physicsGo, (GameObject) physics);
                if (intersected) {
                    return (E) physicsGo;
                }
            }
        }
        return null;
    }


    public static void runAll() {
//        for(GameObject go : gameObjects) {
//            go.run();
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject go = gameObjects.get(i);
            if (go.isActive) {
                go.run();
            }
        }
    }

    public static void addNewAll() {
        gameObjects.addAll(newGameObjects);
    }

    public static void renderAll(Graphics g) {
//        for(GameObject go : gameObjects){
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject go = gameObjects.get(i);
            if (go.isActive) {
                go.render(g);
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }


    public Renderer renderer;
    public Vector2D position;
    public boolean isActive;

    public GameObject() {
        this.isActive = true;
    }

    public GameObject(BufferedImage image) {
        this.isActive = true;
        this.position = new Vector2D(0, 0);
    }

    public void run() { //chạy game logic

    }

    public void destroy() {
        this.isActive = false;
    }

    public void render(Graphics g) { //chạy game hiển thị
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }
}
