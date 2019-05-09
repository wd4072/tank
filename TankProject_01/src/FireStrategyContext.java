
/**
 * 炮弹策略上下文
 * @author wangdong
 *
 */
public class FireStrategyContext {
	private FireStrategyable strategy;
	public FireStrategyContext(FireStrategyable strategy, TankFrame tf, Tank tank) {
		super();
		this.strategy = strategy;
		this.tf = tf;
		this.tank = tank;
	}
	private TankFrame tf;
	private Tank tank;
	/**
	 * 
	 */
	public void fire(){
		strategy.fire(this);
	}
	public TankFrame getTf() {
		return tf;
	}
	public void setTf(TankFrame tf) {
		this.tf = tf;
	}
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}
}
