package game;

import java.util.Random;

public class Spawn{
	
	private Handler handler;
	private HUD hud;
	private boolean PlayerSpawn = true;
	private Random r = new Random();
	private boolean firstW = true;
	private boolean secondW = true;
	private boolean thirdW = true;
	private boolean fourthW = true;
	

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	// handler.addObject(new Player(ID.Player, (double) 40, (double) 40, handler));
	// handler.addObject(new BossEnemy(ID.BossEnemy, (double) 500, (double) -50, handler));

	public void tick() {
		
		if(PlayerSpawn){
			handler.addObject(new Player( ID.Player, (double) 145, (double) 145, handler));
			PlayerSpawn = false;
		}
		//else if(score == 30){
		// 	Random r = new Random();
		// 	handler.addObject(new PowerUp(ID.ShieldPowerUp, (double) r.nextInt(Window.frame.getWidth()), (double) r.nextInt(Window.frame.getHeight())));
		// }
		// // else if (score % 40 == 0){
		// // 		r = new Random();
		// // 	handler.addObject(new LightEnemy(ID.LightEnemy,(double) r.nextInt(Window.frame.getWidth()), (double) r.nextInt(Window.frame.getHeight()), handler));
		// // }
		// else if(score == 20){
		// 	Random q = new Random();
		// 	//handler.addObject(new BossEnemy(ID.BossEnemy,(double) r.nextInt(Window.frame.getWidth()), (double) r.nextInt(Window.frame.getHeight()), handler));
		// 	handler.addObject(new TankEnemy(ID.TankEnemy,(double) q.nextInt(Window.frame.getWidth()), (double) q.nextInt(Window.frame.getHeight()), handler) );

	 	if(hud.getLevel() == 1){
			 if(firstW){
			for(int i = 0 ; i < 16; i++){
				handler.addObject(new LightEnemy(ID.LightEnemy
				,(double) r.nextInt(Window.frame.getWidth())
				, (double) r.nextInt(Window.frame.getHeight()), handler));
			}
			firstW = false;
		}}

		if(hud.getLevel() == 3){
			if(secondW){
			for(int i = 0 ; i < 4; i++){
				handler.addObject(new TankEnemy(ID.TankEnemy
				,(double) r.nextInt(Window.frame.getWidth())
				, (double) r.nextInt(Window.frame.getHeight()), handler));}
			for(int i = 0; i < 12; i++){
				handler.addObject(new LightEnemy(ID.LightEnemy
				,(double) r.nextInt(Window.frame.getWidth())
				, (double) r.nextInt(Window.frame.getHeight()), handler)); 

			}
			secondW =false;
		}
		}
		// if(score == 120){
		// 	Random r = new Random();
		// 	handler.addObject(new PowerUp(ID.ShieldPowerUp,
		// 	 (double) r.nextInt(Window.frame.getWidth()),
		// 	  (double) r.nextInt(Window.frame.getHeight())));
		// }

		if(hud.getLevel() == 8 ){
			if(thirdW){
			for(int i = 0 ; i < 5; i++){
				handler.addObject(new TankEnemy(ID.TankEnemy
				,(double) r.nextInt(Window.frame.getWidth())
				, (double) r.nextInt(Window.frame.getHeight()), handler));
				}
			for(int i = 0 ; i < 6; i++){
				handler.addObject(new LightEnemy(ID.LightEnemy
				,(double) r.nextInt(Window.frame.getWidth())
				, (double) r.nextInt(Window.frame.getHeight()), handler)); 
				}
				thirdW = false;
			}
			}

			// if(score == 300){
			// 	Random r = new Random();
			// 	handler.addObject(new PowerUp(ID.ShieldPowerUp,
			// 	 (double) r.nextInt(Window.frame.getWidth()),
			// 	  (double) r.nextInt(Window.frame.getHeight())));
			// }
			if(hud.getLevel() == 9){
				if(fourthW){
				for(int i = 0 ; i < 15; i++){
					handler.addObject(new LightEnemy(ID.LightEnemy
					,(double) r.nextInt(Window.frame.getWidth())
					, (double) r.nextInt(Window.frame.getHeight()), handler)); 
					}
				fourthW = false;
				}
			}
		}
		
	}
	


