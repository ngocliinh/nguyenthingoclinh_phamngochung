package thegame.enemy;

import javafx.scene.image.Image;
import thegame.Config;

public class TankerEnemy extends Enemy {
    public TankerEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile269.png");
        this.gunImg = new Image("file:image/towerDefense_tile292.png");
        this.speed = Config.TANKER_ENEMY_SPEED;
        this.healthy = Config.TANKER_ENEMY_HEALTH;
        this.reward = Config.TANKER_ENEMY_REWARD;
        this.armor = Config.TANKER_ENEMY_ARMOR;
    }
}
