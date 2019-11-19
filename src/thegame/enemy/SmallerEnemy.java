package thegame.enemy;

import javafx.scene.image.Image;
import thegame.Config;

import java.util.Collection;

public class SmallerEnemy extends Enemy {
    public SmallerEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile271.png");
        this.speed = Config.SMALLER_ENEMY_SPEED;
        this.reward = Config.SMALLER_ENEMY_REWARD;
        this.armor = Config.SMALLER_ENEMY_ARMOR;
        this.healthy = Config.SMALLER_ENEMY_HEALTH;
    }
}
