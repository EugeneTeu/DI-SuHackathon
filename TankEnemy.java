package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class TankEnemy extends GameObject {
    

    // Inherited fields
    /*
    private ID id;
    private double x;
    private double y;
    private double velX;
    private double velY;
    */
    private GameObject player;
    private Handler handler;
    private int health = 20;

    public TankEnemy(ID id, double x, double y, Handler handler) {
        super(id, x, y);
        this.handler = handler;
            
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

        for( int i =0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) {
                 player = handler.object.get(i);}
		}
		
		velX =  2;
		velY = 2; 
    }

    public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 30, 30);
	}
    public void tick () {
        x += velX;
        y += velY;

        float diffX = (float) (x - player.getX() - 16);
		float diffY = (float)  (y - player.getY() - 16);
		float distance = (float) Math.sqrt( (x - player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		//perpendicular distance
		
		velX =  ((-1/distance) * diffX * 2) ;
		velY =  ((-1/distance) * diffY * 2);

		// if(y <= 0 || y >= Game.HEIGHT - 32) {velY *=  -1;}
		// if(x <= 0 || x >= Game.WIDTH - 32) {velX *=  -1;}
		


    }

    public void render(Graphics g) {
        g.setColor(Color.green);
		g.fillOval( (int) x, (int) y, 30, 30);

		g.setColor(Color.blue);
        
    }

    public int getHealth(){
        return health;
    }

    @Override
    public void setHealth(int damage){
        health -= damage;
        checkDeath();
    }

    public void checkDeath(){
        if (health <= 0){
            handler.removeObject(this);
            HUD.score += 5;
        }
    }

	// public void accountForCollision(GameObject obj) {
	// 	HUD.health -= 50;
	// }
}