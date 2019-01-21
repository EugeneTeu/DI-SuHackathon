package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class LightEnemy extends GameObject {
   
    Handler handler;
    // Inherited fields
    /*
    private ID id;
    private double x;
    private double y;
    private double velX;
    private double velY;
    */
    
    public LightEnemy(ID id, double x, double y , Handler handler) {
        super(id, x, y);
        this.handler = handler;

        velX = Game.randomnized(5) * (Game.randomnized(1) >= 0.5 ? 1 : -1);
        velY = Game.randomnized(5) * (Game.randomnized(1) >= 0.5 ? 1 : -1);

        Random random = new Random();
        if (random.nextBoolean()){
            if (random.nextInt(Window.frame.getWidth()) < Window.frame.getWidth() / 2){
                this.x = 0;
            } else {
                this.x = Window.frame.getWidth() - 20;
            }
        } else {
            if (random.nextInt(Window.frame.getHeight()) < Window.frame.getHeight() / 2){
                this.y = 0;
            } else {
                this.y = Window.frame.getHeight() - 20;
            }
        }
    }

    public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 40);
	}
    
    
    public void tick () {
        x += velX;
        y += velY;

        // if(y <= 0 || y >= Window.frame.getHeight() - 32) {velY *=  -1;}
        // if(x <= 0 || x >= Window.frame.getWidth() - 32) {velX *=  -1;}
        

        if(y >= Window.frame.getHeight() || y < 0 ){
            handler.removeObject(this);
        }else if( x >= Window.frame.getWidth() || x < 0 ){
            handler.removeObject(this);

        }


    }
    public void setHealth(int damage){
        
    };
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, 20, 20);

    }

	// public void accountForCollision(GameObject obj) {
	// 	HUD.health -= 20;
	// }
}