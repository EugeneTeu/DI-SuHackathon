package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class FriendlyBullet extends GameObject{
    private Handler handler;
    private double velX, velY;

    public FriendlyBullet(ID id, double x, double y, double velX, double velY, Handler handler){
        super(id, x, y);
        this.handler = handler;
        if(velX == 0 && velY == 0) {
            this.velX = velX;
            this.velY = -9;
        } else if (velX == 0){
            this.velX = velX;
            this.velY = velY < 0 ? -9 : 9;
        } else {
            this.velX = velX < 0 ? -9 : 9;
            this.velY = velY;
        }
    }

    // public void accountForCollision(GameObject obj){
    //     for(int i = 0; i < handler.object.size(); i++){

    //     }
    // }

    public void tick(){
        x += velX;
        y += velY;

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject obj = handler.object.get(i);
            checkForCollision(obj, i);
        }

        if(y >= Window.frame.getHeight() || y <= 0 ){
            handler.removeObject(this);
        }else if( x >= Window.frame.getWidth() || x <= 0 ){
            handler.removeObject(this);

        }

    }

    public void render(Graphics g){
        g.setColor(Color.blue);
        g.drawOval((int) getX(), (int) getY(), 2, 2);
    }

    public Rectangle  getBounds() {
		return new Rectangle( (int) getX(), (int) getY(), 2, 2);
    }

    public void setHealth(int damage){

    }

    private void checkForCollision(GameObject obj, int i) {
        if (this.getBounds().intersects(obj.getBounds())) {
            if (obj.getId() == ID.LightEnemy) {
                handler.removeObject(obj);
                handler.removeObject(this);
                HUD.score += 2;
            }else if (obj.getId() == ID.TankEnemy) {
                // deplete enemy hp
                obj.setHealth(4);
                handler.removeObject(this);
            }else if (obj.getId() == ID.BossEnemyArm) {
                // deplete enemy hp
                obj.setHealth(4);
                handler.removeObject(this);
                HUD.score += 2;
            } else if (obj.getId() == ID.BossEnemy) {
                // deplete enemy hp
                obj.setHealth(4);
                handler.removeObject(this);
            }
            else if (obj.getId() == ID.BossEnemyBullet){
                handler.removeObject(obj);
                handler.removeObject(this);
            }
        }
    }
}