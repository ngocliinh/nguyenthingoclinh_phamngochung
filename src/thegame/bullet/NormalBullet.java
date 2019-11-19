package thegame.bullet;

import thegame.Config;

public class NormalBullet extends Bullet {
    public NormalBullet(double posX, double posY) {
        super(posX, posY);
        this.damage = Config.NORMAL_BULLET_DAMAGE;
    }
}
