package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PowerUp extends GameObject{

    //int[] arrX = {20,25,30,35,40};
    //int[] arrY = {20,25,30,35,40};
    
     // Inherited fields
    /*
    private ID id;
    private double x;
    private double y;
    private double velX;
    private double velY;
    */

    PowerUp(ID id, double x, double y) {
        super(id, x, y);
        
    }
    public void tick(){

    }

    public Rectangle  getBounds() {
		return new Rectangle( (int) this.getX(), (int) this.getY(), 10,10);
	}

    public void render(Graphics g){
        g.setColor(Color.cyan);
        g.fillOval( (int) this.getX() , (int) this.getY(), 10, 10);
        g.drawString("POWER UP", (int) this.getX() - 28, (int) this.getY() + 30);

        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(getBounds());

    }

    public void setHealth(int damage){};
    
    public void accountForCollision(GameObject obj){
        //
        
    }



}