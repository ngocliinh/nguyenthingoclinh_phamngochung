package thegame.enemy;

import javafx.scene.image.Image;
import thegame.Config;

import java.util.zip.CheckedOutputStream;

public class BossEnemy extends Enemy {
    public BossEnemy(double posX, double posY, int status) {
        super(posX, posY, status);
        this.img = new Image("file:image/towerDefense_tile268.png");
        this.gunImg = new Image("file:image/towerDefense_tile291.png");
        this.speed = Config.BOSS_ENEMY_SPEED;
        this.healthy = Config.BOSS_ENEMY_HEALTH;
        this.armor = Config.BOSS_ENEMY_ARMOR;
        this.reward  = Config.BOSS_ENEMY_REWARD;

    }
}
