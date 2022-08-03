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
        spriteCounter++;
        if (spriteCounter > 10){
            if(spriteNumber == 1){
                spriteNumber =2;
            }else if(spriteNumber == 2){
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNumber ==1){
                    image = up1;
                }
                if(spriteNumber == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = down1;
                }
                if (spriteNumber == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber ==1) {
                    image = left1;
                }
                if (spriteNumber == 2){
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber ==1) {
                    image = right1;
                }
                if (spriteNumber == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
