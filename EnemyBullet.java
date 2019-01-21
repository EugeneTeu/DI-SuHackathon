package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBullet extends GameObject {
	
    private Handler handler;
    private Random r = new Random() ;
	
	public EnemyBullet(ID id, double x , double y , Handler handler) {
		super(id,x,y);
        this.handler = handler;
        
        velX = (r.nextInt(5 - -5) + -5);
        velY = 2;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
        y += velY;
        
        if(y >= Window.frame.getHeight() ){
            handler.removeObject(this);
        }
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red,16,16, 0.05f,handler));
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.pink);
		g.drawOval((int)x, (int) y, 10, 10);
		//g.setColor(Color.blue);
		//g2d.draw(getBounds());
		
	}
	public void setHealth(int damage) {};
	
	public Rectangle getBounds() {
		return new Rectangle( (int)x, (int)y,10,10);
	}

}