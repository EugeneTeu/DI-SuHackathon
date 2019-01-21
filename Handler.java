package game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
            tempObject.tick();
            //accountForCollision();
        }
    }

    // private void accountForCollision() {
    //     for (int i = 0; i < object.size(); i++) {
    //         GameObject tempObject = object.get(i);
    //         if (object.getId() == ID.Player) {
    //             for (GameObject tempObj : object) {
    //                 if (tempObj.collidedWith(obj)) {
    //                     //tempObj.accountForCollision(obj);
    //                     if (tempObj.getId() == ID.LightEnemy) {
    //                         object.remove(tempObj);
    //                     }
    //                 }
    //                 else {
    //                     // DO NOTHING
    //                 }
    //             }
    //         }
    //     }
    // }

    public void render(Graphics g) {
        for (GameObject obj : object) {
            obj.render(g);
        }
    }

    public void clearEnemy() {
        for (int i = 0; i < object.size(); i++) {
              GameObject tempObject = object.get(i);

              if(tempObject.getId() == ID.Player){
                  object.clear();
                  addObject(new Player(ID.Player, tempObject.getX(), tempObject.getY(), this));
              }
              }
    }

    public void addObject(GameObject obj) {
        object.add(obj);
    }

    public void removeObject(GameObject obj) {
        object.remove(obj);
    }
}