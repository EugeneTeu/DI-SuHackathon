package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemyArm extends GameObject {
    
    private int timer = 100;
    private int timer2 = 50; 
    private Random r  = new Random() ;
    private Handler handler;
    private int health = 40;
    private double leftBound, rightBound;
    
    // Inherited fields
    /*
    private ID id;
    private double x;
    private double y;
    private double velX;
    private double velY;
    */
    
    public BossEnemyArm(ID id, double x, double y, double leftBound, double rightBound, Handler handler) {
        super(id, x, y);
        this.handler = handler;
        this.leftBound = leftBound;
        this.rightBound = rightBound;

        velX = 0;
        velY = 2;
    }

    public Rectangle  getBounds() {
		return new Rectangle( (int) getX() , (int) getY() , 64,64);
    }
    
    public void tick () {

        x += velX;
        y += velY;

        if(timer <= 0){ 
            velY = 0;
        }else{
            timer--;
        }
        if(timer <=0){timer2--;}
        if(timer2 <=0) {

         if(velX == 0) velX = (double) 5;
         int spawn = r.nextInt(10);
         if(spawn == 0){
            handler.addObject(new BossEnemyBullet(ID.BossEnemyBullet, this.getX(),this.getY(), handler));
         }

        }
        if(x <= 0 + leftBound || x >= Window.frame.getWidth() - rightBound) velX *=  -1;
        checkDeath();
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) getX(), (int) getY(), 64, 64);
    }

    public void setHealth(int damage) {
        health -= damage;
    }

    public void checkDeath(){
        if (health <= 0){
            HUD.score += 1000;
            handler.removeObject(this);
        }
    }

	// public void accountForCollision(GameObject obj) {
		
	// }
}