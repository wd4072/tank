
public class SingleFireStrategy implements FireStrategyable {

	@Override
	public void fire(FireStrategyContext ct) {
		Tank tank = ct.getTank();
		ct.getTf().bullets.add(new Bullet(tank.getX(), tank.getY(), ct.getTf(), tank.getDir(), tank.getGroup()));
	}

}
