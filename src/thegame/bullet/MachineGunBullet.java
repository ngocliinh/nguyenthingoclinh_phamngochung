package thegame.bullet;

import thegame.Config;

public class MachineGunBullet extends Bullet {
    public MachineGunBullet(double posX, double posY) {
        super(posX, posY);
        this.damage = Config.MACHINE_GUN_BULLET_DAMAGE;
    }
}
