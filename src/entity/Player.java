package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){

        try{

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Foka_tyl1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/foka_tyl2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/Foka1_przod.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/Foka2_przod.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/foka_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/foka_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/foka_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/foka_right2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }else if(keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }else if (keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }else if (keyH.upLeftPressed == true){
            x -= speed;
            y -= speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}