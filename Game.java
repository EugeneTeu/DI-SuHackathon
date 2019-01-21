package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6789265162794446317L;
	
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Random r;
	private HUD hud;
	public static STATE gameState = STATE.MENU;
	private Spawn spawn;
	private Menu menu;
	private SerialInput serialInput;
	private Graphics g;
	
	public Game() {
		
		handler = new Handler();
		hud = new HUD(handler);
		r = new Random();
		serialInput = new SerialInput(handler, g);
		spawn = new Spawn(handler, hud);
		menu = new Menu();
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window(this);

	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				try {
					render();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames =0;
			}
			
		}
		serialInput.close();
		stop();
	}

			
		
	private void tick() {
		handler.tick();
		if(gameState == STATE.MENU){

		} else if (gameState == STATE.START){
			hud.tick();
			spawn.tick();
			serialInput.tick();
		} else if (gameState == STATE.GAMEOVER){

		}
	}
	private void render() throws IOException {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		g.setColor(Color.black); 
		g.fillRect(0, 0, Window.frame.getWidth(), Window.frame.getHeight());

		handler.render(g);

		if(gameState == STATE.MENU || gameState == STATE.HELP){
			g.setColor(Color.black);
			g.drawString("MENU", 200,500);
			g.setColor(Color.white);
			menu.render(g);
		} else if (gameState == STATE.START){
			hud.render(g);
		} else if (gameState == STATE.GAMEOVER){
			g.setColor(Color.white);
			menu.render(g);
		}
		
		// File s = "C:/Users/eugeneteu/Desktop/martinhenz.jpg";
		// Path  s = new Path();
		// BufferedImage image = ImageIO.read(new File("/Users/eugeneteu/Desktop/martinhenz.jpg"));
		
		// Graphics2D g2d = (Graphics2D) g;
		// g2d.drawImage( image,WIDTH / 2,HEIGHT / 2 ,null);
		g.dispose();
		bs.show();
	}

	public static double clamp(double var, double min, double max) {
		if (var > max) {
			return max;
		} 
		else if (var < min) {
			return min;
		} 
		else {
			return var;
		}
	}
//	public static float clamp2(float x, float vel,float WIDTH) {
//		return  x = ( x + vel + WIDTH ) % WIDTH;
//	}
	
public static double randomnized(double velocity){
	Random random = new Random();
	return random.nextDouble() * velocity;

}
	public static void main(String args[]) throws IOException {
		new Game();
		
	}
}


	