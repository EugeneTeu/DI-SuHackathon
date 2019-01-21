package game;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class InvisibleObject extends GameObject {

    InvisibleObject(ID id, double x, double y) {
        super(id, x, y);
    }

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public Rectangle2D getBounds() {
		return null;
	}

	@Override
	public void setHealth(int damage){

	}
	
}