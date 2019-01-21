package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class HUD {

        private Handler handler;
        public int level = 0;
        public static int score = 0 ;
        public static int HEALTH = 200;
        public static int SHIELD = 0;
        public static boolean haveShield = false;
        private Random r = new Random();
        private boolean spawnP = true;
        private boolean spawnB = true;
        private boolean spawnS = true;
        private boolean spawnBB = true;

        public HUD(Handler handler){
                this.handler = handler;
        }

        public void tick(){
               score++;
               if( score >= 200 ){
                        score = 0;
                        level += 1;
                }
                if(level  == 3 ){
                        spawnPowerUp();
                }
                if(level == 6){
                        spawnBoss();
                        spawnB = false;
                }
                if(level == 12){
                        spawnBossB();
                        spawnBB = false;
                }
                if(level == 14){
                        spawnSpecialStage();
                }
                spawnS = false;
        }

        public void spawnPowerUp(){
                if(spawnP){
                for(int i = 0; i < 4; i++){
                handler.addObject(new PowerUp(ID.ShieldPowerUp, (double) r.nextInt(Window.frame.getWidth()), (double) r.nextInt(Window.frame.getHeight())));
                 }
                spawnP = false;
        }}
        public void spawnBoss(){
                if(spawnB){
                handler.addObject(new BossEnemyArm(ID.BossEnemyArm, (double) 10.0, (double) 0.0, 5, 187, handler));
                handler.addObject(new BossEnemyArm(ID.BossEnemyArm, (double) 151, (double) 0.0, 123, 0, handler));
                spawnB = false;
        }}

        public void spawnBossB(){
                if(spawnBB){
        handler.addObject(new BossEnemy(ID.BossEnemy, (double) Window.frame.getWidth() / 2.0 , 5.0 , handler));
        spawnBB = false;
}}

        public void spawnSpecialStage(){
                if(spawnS){
		for(int i = 0; i < 20; i++){
                        handler.addObject(new LightEnemy(ID.LightEnemy
                        ,(double) r.nextInt(Window.frame.getWidth())
                        , (double) r.nextInt(Window.frame.getHeight()), handler)); 
                        handler.addObject(new TankEnemy(ID.TankEnemy
                        ,(double) r.nextInt(Window.frame.getWidth())
                        , (double) r.nextInt(Window.frame.getHeight()), handler));
                }
                for(int i = 0; i < 3; i++){
                        handler.addObject(new BossEnemy(ID.BossEnemy, (double) 64, (double) 0.0, handler));
                }
        }}
    

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("Health ", 10, 24);
        g.setColor(Color.magenta);
        g.drawRect(10, 30, 200, 20);
        g.setColor(Color.green);
        g.fillRect(10,30,HEALTH,20);
        
        g.setColor(Color.white);
        g.drawString("Level: " + level, 10, 64);

        if(haveShield){
                // System.out.printf("%d", SHIELD);
                g.setColor(Color.blue);
                g.fillRect(10, 30, SHIELD, 20);
        }



    }   
   
        public void score(int score) {
                HUD.score = score;
        }

        public int getScore() {
                return score;
        }
        
        public void setLevel(int level){
              this.level = level;
        }

        public int getLevel(){
                return level;
        }
}