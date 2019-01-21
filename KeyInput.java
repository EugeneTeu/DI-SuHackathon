package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		for(int i = 0; i < keyDown.length; i++) {
			keyDown[i] = false;
		}
		//boolean[] automatically initialised to false
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0;  i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
					 if(key == KeyEvent.VK_W) {
						 tempObject.setVelY(-5);
						 keyDown[0] = true;
						 }
					 if(key == KeyEvent.VK_S) {
						 tempObject.setVelY(+5);
						 keyDown[1] = true;
						 }
					 if(key == KeyEvent.VK_A) {
						 tempObject.setVelX(-5);
						 keyDown[2] = true;}
					 if(key == KeyEvent.VK_D) {
						 tempObject.setVelX(5);
						 keyDown[3] = true;}
					 }
			
			
			
//			else if(tempObject.getID() == ID.Player2) {
//				//key events for player 2
//				
//				if(key == KeyEvent.VK_UP) {tempObject.setvelY(-5);}
//				 if(key == KeyEvent.VK_DOWN) {tempObject.setvelY(+5);}
//				 if(key == KeyEvent.VK_LEFT) {tempObject.setvelX(-5);}
//				 if(key == KeyEvent.VK_RIGHT) {tempObject.setvelX(5);}
//			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0;  i < handler.object.size(); i ++) {
			GameObject tempObject = handler.object.get(i);
			
			
			if(tempObject.getId() == ID.Player) {
				//key events for player 1
					 if(key == KeyEvent.VK_W) {keyDown[0] = false;
					 //tempObject.setvelY(0);}
					 }
					 if(key == KeyEvent.VK_S) {keyDown[1] = false;
					 //tempObject.setvelY(0);}
					 }
					 if(key == KeyEvent.VK_A) {keyDown[2] = false;
					 //tempObject.setvelX(0);}
					 }
					 if(key == KeyEvent.VK_D) {keyDown[3] = false; 
					 //tempObject.setvelX(0);}
					 }
					 
					 //vertical movement
					 if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
					 // horizontal movement
					 if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
					 }
			
			
			
//			else if(tempObject.getID() == ID.Player2) {
//				//key events for player 2
//				
//				if(key == KeyEvent.VK_UP) {tempObject.setvelY(0);}
//				 if(key == KeyEvent.VK_DOWN) {tempObject.setvelY(0);}
//				 if(key == KeyEvent.VK_LEFT) {tempObject.setvelX(0);}
//				 if(key == KeyEvent.VK_RIGHT) {tempObject.setvelX(0);}
//				 }
			
			
			
		}
		if(key == KeyEvent.VK_ESCAPE) { System.exit(1);}
		
	}


}