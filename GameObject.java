package game;

import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

public abstract class GameObject {


    protected ID id;
    protected double x;
    protected double y;
    protected double velX;
    protected double velY;

    public GameObject(ID id, double x, double y) {  
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    // public abstract void accountForCollision(GameObject obj);
    public abstract Rectangle2D getBounds();
    public abstract void setHealth(int damage);

    public boolean collidedWith(GameObject obj) {
        return this.getBounds().intersects(obj.getBounds());
    }

    public ID getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY= velY;
    }
}