package game;

import java.awt.Graphics;
import java.io.InputStream;
import java.awt.Color;
import com.fazecast.jSerialComm.*;
import java.io.IOException;

public class SerialInput {

    private Handler handler;
    private SerialPort comPort;
    // private boolean[] keyDown = new boolean[4];
    private InputStream input;
    private Graphics g;

    SerialInput(Handler handler, Graphics g) {
        this.g = g;
        this.handler = handler;
        comPort = SerialPort.getCommPorts()[1];
        comPort.openPort();
        // comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        input = comPort.getInputStream();
        // waitForCalibration();
    }

    // public void waitForCalibration() {
    //     try {
    //         while ((char)input.read() != 'E') {
    //         }
    //     }
    //     catch (IOException e) {

    //     }
    //     g.setColor(Color.white);
    //     g.drawString("CALIBRATION DONE", 200, 200);
    // }

    public void tick() {
        try {
            for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                if (tempObject.getId() == ID.Player) {
                    if ((char)input.read() == 'L') {
                        tempObject.setVelX(-5);
                        tempObject.setVelY(0);
                        // keyDown[2] = true;
                    }
                    else if ((char)input.read() == 'R') {
                        tempObject.setVelX(5);
                        tempObject.setVelY(0);
                        // keyDown[3] = true;                        
                    }
                    else if ((char)input.read() == 'F') {
                        tempObject.setVelX(0);
                        tempObject.setVelY(-5);
                        // keyDown[0] = true;
                    }
                    else if ((char)input.read() == 'B') {
                        tempObject.setVelX(0);
                        tempObject.setVelY(5);
                        // keyDown[1] = true;                        
                    }                    
                }
            }
        }
        catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    public void close() {
        comPort.closePort();
    }
}