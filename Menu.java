package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Menu extends MouseAdapter {
	private int width = 150;
	private int height = 80;
	private int rectx;
	private Rectangle start;
	private Rectangle help;
	private Rectangle quit;
	private Rectangle back;
	//private Rectangle title;
	

	public Menu() {
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		mouseOver(x, y);
	}

	public void tick() {

	}

	public void mouseOver(int x, int y){
		if (start.contains((double) x, (double) y)) {
			Game.gameState = STATE.START;
		} else if (help.contains((double) x, (double) y)) {
			Game.gameState = STATE.HELP;
		} else if (back.contains((double) x, (double) y)) {
			Game.gameState = STATE.MENU;
		} else if (quit.contains((double) x, (double) y)) {
			System.exit(0);
		}
	}

	public void render(Graphics g) {

		rectx = Window.frame.getWidth() / 2 - width / 2;
		//title = new Rectangle(rectx , 100 , width, height);
		help = new Rectangle(rectx, 300, width, height);
		back = new Rectangle(rectx, 200, width, height);
		start = new Rectangle(rectx, 200, 0, 0);
		quit = new Rectangle(rectx, 400, 0, 0);

		Graphics2D g2d = (Graphics2D) g;
		
		if (Game.gameState == STATE.MENU) {
			start.setSize(width, height);
			quit.setSize(width, height);

			Font font1 = new Font("monaco", 1, 60);
			g.setFont(font1);
			g.drawString("BALANCING ACT", 360,  140);
			Font font2 = new Font("arial", 1, 30);
			g.setFont(font2);
			g2d.draw(start);
			g.drawString("PLAY", (int) (start.getX() + start.getWidth()/2 - 35) , (int) (start.getY() + start.getHeight()/2) + 10) ;
			g2d.draw(help);
			g.drawString("HELP", (int) (help.getX() + help.getWidth()/2 - 35) , (int) (help.getY() + help.getHeight()/2) + 10) ;
			g2d.draw(quit);
			g.drawString("QUIT",  (int) (quit.getX() + quit.getWidth()/2 - 35) , (int)(quit.getY() + quit.getHeight()/2) + 10);
		} else if (Game.gameState == STATE.HELP) {
			Font font1 = new Font("monaco", 1, 60);
			g.setFont(font1);
			g.drawString("BALANCING ACT", 360,  140);

			Font font2 = new Font("arial", 1, 30);
			g.setFont(font2);
			start.setSize(0,0);
			quit.setSize(0,0);
			g2d.draw(back);
			g.drawString("BACK", (int) (back.getX() + back.getWidth()/2 - 35) , (int) (back.getY() + back.getHeight()/2) + 10) ;
			g.drawString("Use WASD Keys to move. Kill Enemies by shooting at them.",(int) (help.getX() + (help.getWidth()/2 ) - 400) , (int) (help.getY() + help.getHeight()/2) + 10);
			g.drawString("Look out for different tiers of enemies. There are 3 in total.",(int) (help.getX() + (help.getWidth()/2 ) - 400) , (int) (help.getY() + help.getHeight()/2) + 50);
			g.drawString("Power ups will be spawned at certain intervals. They grant u additional shields ",(int) (help.getX() + (help.getWidth()/2 ) - 550) , (int) (help.getY() + help.getHeight()/2) + 90);
		} else if (Game.gameState == STATE.GAMEOVER){
			Font font1 = new Font("monaco", 1, 60);
			g.setFont(font1);
			g.drawString("GAME OVER NOOB", 360,  140);

			Font font2 = new Font("arial", 1, 30);
			g.setFont(font2);
			start.setSize(width, height);
			help.setSize(0, 0);
			quit.setSize(width, height);
			g2d.draw(start);
			g.drawString("PLAY", (int) (start.getX() + start.getWidth()/2 - 35) , (int) (start.getY() + start.getHeight()/2 + 10));
			g2d.draw(quit);
			g.drawString("QUIT",  (int) (quit.getX() + quit.getWidth()/2 - 35) , (int)(quit.getY() + quit.getHeight()/2 + 10));

			Font font3 = new Font("arial", 1, 10);
			g.setFont(font3);
			g.drawString("...again", (int) (start.getX() + start.getWidth()/2 - 25) , (int) (start.getY() + start.getHeight()/2 + 20));
		}
	}
}