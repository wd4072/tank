
public class TwoFireStrategy implements FireStrategyable{

	@Override
	public void fire(FireStrategyContext ct) {
		Tank tank = ct.getTank();
		Bullet bullet1 = new Bullet(tank.getX(), tank.getY(), ct.getTf(), tank.getDir(), tank.getGroup());
		Bullet bullet2 = new Bullet(tank.getX(), tank.getY(), ct.getTf(), tank.getDir(), tank.getGroup());
		Bullet bullet3 = new Bullet(tank.getX(), tank.getY(), ct.getTf(), tank.getDir(), tank.getGroup());
		ct.getTf().bullets.add(bullet1);
		ct.getTf().bullets.add(bullet2);
		ct.getTf().bullets.add(bullet3);


	}

}
