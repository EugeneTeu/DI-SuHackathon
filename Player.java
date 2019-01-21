package game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Player extends GameObject {

    private Handler handler;
    private int counter = 5;
    // Inherited fields
    /*
    private ID id;
    private double x;
    private double y;
    private double velX;
    private double velY;
    */

    public Player(ID id, double x, double y, Handler handler) {
        super(id, x, y);
        this.handler = handler;    
    }

    public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 40);
	}
    
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, (double) 0, (double) (Window.frame.getWidth() - 84));

        y = Game.clamp(y, (double) 0, (double)  ( Window.frame.getHeight() - 84)) ;

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject obj = handler.object.get(i);
            checkForCollision(obj, i);
        }
        if(counter >= 5){
            handler.addObject(new FriendlyBullet(ID.FriendlyBullet, getBounds().getCenterX(),getBounds().getCenterY(), getVelX(), getVelY(), handler));
            counter = 0;
        }
        counter++;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) x, (int) y, 32, 40);
    }
    
    @Override
    public void setHealth(int damage){}

    private void checkForCollision(GameObject obj, int i) {
        if (this.getBounds().intersects(obj.getBounds())) {
            if (obj.getId() == ID.LightEnemy) {
                handler.removeObject(obj);
                if(HUD.SHIELD <= 0 ){
                    HUD.HEALTH -= 20;
                    if (HUD.HEALTH <= 0){
                        Game.gameState = STATE.GAMEOVER;
                        handler.object.clear();
                    }
                }else{
                    HUD.SHIELD -= 20;
                        if (HUD.SHIELD <= 0 ) {
                            HUD.SHIELD = 0;
                            HUD.haveShield = false;
                        }
                }
                //handler.object.set(i, new InvisibleObject(ID.InvisibleObject, 0, 0));
            }
            else if (obj.getId() == ID.TankEnemy) {
                handler.removeObject(obj);
                if(HUD.SHIELD <= 0 ){
                    HUD.HEALTH -= 5;
                    if (HUD.HEALTH <= 0){
                       Game.gameState = STATE.GAMEOVER;
                       handler.object.clear();
                    }
                }else{
                    HUD.SHIELD -= 5;
                    if (HUD.SHIELD <= 0 ) {
                        HUD.SHIELD = 0;
                        HUD.haveShield = false;
                    }
                }
                //handler.object.set(i, new InvisibleObject(ID.InvisibleObject, 0, 0));
            }
            else if (obj.getId() == ID.BossEnemy) {
                if(HUD.SHIELD <= 0 ){
                    HUD.HEALTH -= 100;
                    if (HUD.HEALTH <= 0){
                        Game.gameState = STATE.GAMEOVER;
                        handler.object.clear();
                    }
                }else{
                    HUD.SHIELD -= 100;
                    if (HUD.SHIELD <= 0 ) {
                        HUD.SHIELD = 0;
                        HUD.haveShield = false;
                    }
                }
            }else if (obj.getId() == ID.BossEnemyArm) {
                if(HUD.SHIELD <= 0 ){
                    HUD.HEALTH -= 100;
                    if (HUD.HEALTH <= 0){
                        Game.gameState = STATE.GAMEOVER;
                        handler.object.clear();
                    }
                }else{
                    HUD.SHIELD -= 100;
                    if (HUD.SHIELD <= 0 ) {
                        HUD.SHIELD = 0;
                        HUD.haveShield = false;
                    }
                }
            }
            else if (obj.getId() == ID.BossEnemyBullet){
                handler.removeObject(obj);
                if(HUD.SHIELD <= 0 ){
                    HUD.HEALTH -= 5;
                    if (HUD.HEALTH <= 0){
                        Game.gameState = STATE.GAMEOVER;
                        handler.object.clear();
                    }
                }else{
                    HUD.SHIELD -= 5;
                    if (HUD.SHIELD <= 0 ) {
                        HUD.SHIELD = 0;
                        HUD.haveShield = false;
                    }
                }
            } 
            else if  (obj.getId() == ID.ShieldPowerUp){
                handler.removeObject(obj);
                if (HUD.SHIELD >= 100) {
                    HUD.SHIELD = 200;
                } else {
                    HUD.SHIELD += 100;
                }
                HUD.haveShield = true;
            }
        }
    }
}