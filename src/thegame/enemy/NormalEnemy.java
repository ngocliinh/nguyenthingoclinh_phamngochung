package thegame.enemy;

import javafx.scene.image.Image;
import thegame.Config;
import thegame.tile.Tower;

import java.awt.*;

public class NormalEnemy extends Enemy {


    public NormalEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        img = new Image("file:image/towerDefense_tile270.png");
        this.speed =  Config.NORMAL_ENEMY_SPEED;
        this.healthy = Config.NORMAL_ENEMY_HEALTH;
        this.reward = Config.NORMAL_ENEMY_REWARD;
        this.armor = Config.NORMAL_ENEMY_ARMOR;
    }

    public void setHealthy(Tower tower) {
        healthy-= tower.demage;
    }

    public double getHealthy(){
        return healthy;
    }
}
