package thegame.bullet;

import thegame.Config;

public class SniperBullet extends Bullet {
    public SniperBullet(double posX, double posY) {
        super(posX, posY);
        this.damage = Config.NORMAL_BULLET_DAMAGE;
    }
}
