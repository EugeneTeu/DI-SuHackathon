package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class BossEnemy extends GameObject{
    private ID id;
    private double x, y, velX, velY;
    private Random r  = new Random();
    private Handler handler;
    private int timer = 100;
    // private boolean leftD, rightD = false;
    private int health = 50;

    public BossEnemy (ID id, double x, double y, Handler handler){
        super(id,x,y);
        this.handler = handler;

        velX=0;
        velY = 2;
    }

    public void tick(){
        
        x += velX;
        y += velY;

        if(timer <= 0){ 
            velY = 0;
        }
         int spawn = r.nextInt(3);
         if(spawn == 0){
            handler.addObject(new BossEnemyBullet(ID.BossEnemyBullet, this.getX(),this.getY(), handler));
        }
        checkDeath();
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillOval((int) getX(), (int) getY(), 50, 50);
    }
    
    public Rectangle getBounds(){
        return new Rectangle( (int) this.getX() , (int) this.getY() , 50,50);
    }

    public void setHealth(int damage){
            health -= damage;            
    }

    public void checkDeath(){
        if (health <= 0){
            HUD.score += 100000;
            handler.removeObject(this);
        }
    }
}