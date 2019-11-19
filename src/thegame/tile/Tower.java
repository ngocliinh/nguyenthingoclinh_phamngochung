package thegame.tile;

import javafx.scene.canvas.GraphicsContext;
import thegame.Config;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import thegame.GameEntities;
import thegame.enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;

public class Tower extends GameTile {
    public double speed;
    public double range;
    public double demage;
    public int kind;
    public Enemy enemy = null;
    public Image imgT;
    public Image gunImageT;


    public Tower(){}

    public Tower(double posX, double posY) {
        super(posX, posY);
    }
    // không đặt tháp trên đường
    public boolean checkArea() {
        if(this.posX > 10 * Config.SIZE && this.posY > 7*Config.SIZE) return false;
        else {
            if((posX > 32 && posX < 160) && (posY > 224)) return false;

            if((posX > 160 && posX < 288) && (posY > 32 && posY < 352)) return false;

            if((posX > 288 && posX < 480) && (posY > 32 && posY < 160)) return false;

            if((posX > 352 && posX < 480) && (posY > 160) && (posY < 416)) return false;

            if((posX > 480 ) && (posY > 288 && posY < 416)) return false;

            return true;
        }
    }

    public void drawTower(GraphicsContext graphicsContext, double posX, double posY) {
        graphicsContext.drawImage(gunImageT, posX, posY);
        graphicsContext.drawImage(imgT, posX, posY);
    }
    // tính kc đến địch
    public double distance(Enemy enemy) {
        double dX = this.posX - enemy.getPosX();
        double dY = this.posY - enemy.getPosY();
        return Math.sqrt(dX*dX + dY*dY);
    }

}
