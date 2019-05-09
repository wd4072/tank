import java.awt.Graphics;
import java.util.Random;

public class Tank {
	
	private int x;
	private int y;
	public static int WIDTH = ImagesMgr.tankD.getWidth();
	public static int HEIGHT = ImagesMgr.tankD.getHeight();
	private int speed=10;
	private TankFrame  tf=null;
	private boolean moving=false;
	private Dir dir=Dir.DOWN;
	public boolean living = true;
	private GROUP group=GROUP.BAD;
	private Random rondom = new Random();
	
	public Tank(TankFrame tf,Dir dir,GROUP group){
		this.dir=dir;
		this.tf=tf;
		this.group=group;
	}
	public void fire(){
		FireStrategyContext ct;
		if(rondom.nextInt(10)>5){
			ct=new FireStrategyContext(new TwoFireStrategy(),this.tf,this);
		}
		else {
			ct =new FireStrategyContext(new SingleFireStrategy(),this.tf,this);
		}
		ct.fire();
		//int bx=x+WIDTH/2-Bullet.WIDTH/2;
		//int by=y+HEIGHT/2-Bullet.HEIGHT/2;
		//tf.bullets.add(new Bullet(bx,by,tf,this.dir,this.group));
	}
	public void paint(Graphics g){
		
		if(!living){
			tf.tanks.remove(this);
			return;
		}
				
		if(dir==Dir.UP){
			g.drawImage(ImagesMgr.tankU, x, y, null);
		}
		if(dir==Dir.DOWN){
			g.drawImage(ImagesMgr.tankD, x, y, null);
		}
		if(dir==Dir.LEFT){
			g.drawImage(ImagesMgr.tankL, x, y, null);
		}
		if(dir==Dir.RIGHT){
			g.drawImage(ImagesMgr.tankR, x, y, null);
		}
		move(dir);
	}
	private void move(Dir dir){
		if(!moving)return;
		this.dir=dir;
		switch (dir) {
		case UP:
			y-=speed;
			break;
		case DOWN:
			y+=speed;
			break;
		case LEFT:
			x-=speed;
			break;
		case RIGHT:
			x+=speed;
			break;
		default:
			break;
		}
		if(group==GROUP.BAD){
			if(rondom.nextInt(100)>95){
				changeDir();
			}
		}
		//5%的概率发射子弹
		if(rondom.nextInt(100)>95&&group==group.BAD){
			this.fire();
		}
		boundCheck();
		
	}
	private void changeDir() {		
		dir=Dir.values()[rondom.nextInt(4)];		
	}
	private void boundCheck() {
		if(this.x<0)this.x=0;
		if(this.x>tf.WIDTH-WIDTH)this.x=tf.WIDTH- Tank.WIDTH;
		if(this.y<30)this.y=30;
		if(this.y>tf.HEIGHT-HEIGHT)this.y=tf.HEIGHT-Tank.HEIGHT;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void dead() {
		this.living = false;
	}
	public GROUP getGroup() {
		return group;
	}
	public void setGroup(GROUP group) {
		this.group = group;
	}
}
