import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	private int x, y;
	public static int WIDTH = ImagesMgr.bulletD.getWidth();
	public static int HEIGHT = ImagesMgr.bulletD.getHeight();
	private TankFrame tf = null;
	private int speed = 30;
	private Dir dir;
	private boolean living=true;
	private GROUP group=GROUP.BAD;

	public Bullet(int x ,int y, TankFrame tf,Dir dir,GROUP group) {
		this.x = x;
		this.y = y;
		this.tf = tf;
		this.dir = dir;
		this.group=group;
		
	}

	public void paint(Graphics g) {
		if(!living){
			tf.bullets.remove(this);
			return;
		}
		//子弹超出界面
		if(x>tf.WIDTH||x<0||y<0||y>tf.HEIGHT){
			living=false;
			return;
		}		
		Color c = g.getColor();
		g.setColor(Color.red);
		if(dir==Dir.UP){
			g.drawImage(ImagesMgr.bulletU,x, y,null);
		}
		if(dir==Dir.DOWN){
			g.drawImage(ImagesMgr.bulletD,x, y,null);
		}
		if(dir==Dir.LEFT){
			g.drawImage(ImagesMgr.bulletL,x, y,null);
		}
		if(dir==Dir.RIGHT){
			g.drawImage(ImagesMgr.bulletR,x, y,null);
		}
		g.setColor(c);
		move(dir);		
	}

	public void move(Dir dir) {
		switch (dir) {
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		default:
			break;
		}
	}

	public boolean collison(Tank tank) {
		if(this.group==tank.getGroup())return false;
		
		Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		return rect2.intersects(rect1);
		
	}

	public void dead() {
		living=false;
	}
}
