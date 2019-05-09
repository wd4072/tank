import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author wangdong
 *
 */
public class TankFrame extends Frame {
	
	public List<Bullet> bullets =  new ArrayList<>();
	public static final int WIDTH = 800, HEIGHT = 600;
	//敌人坦克
	public List<Tank> tanks = new ArrayList<>();
	private Dir dir=Dir.DOWN;
	private int x, y;
	private Tank tank = new Tank(this,dir,GROUP.GOOD);
	private boolean dU = false, dD = false, dL = false, dR = false;
	private int tankcount = Integer.parseInt(PropetyMgr.getPropety("tankcount")+"");

	public TankFrame() {
		setSize(WIDTH, HEIGHT);
		setBackground(Color.BLACK);
		setVisible(true);
		for(int i=0;i<tankcount;i++){
			Tank t =new Tank(this,Dir.DOWN,GROUP.BAD);
			t.setSpeed(5);
			t.setX(380);
			t.setY(280);
			t.setMoving(true);
			Dir dir = Dir.values()[new Random().nextInt(4)];
			t.setDir(dir);
			tanks.add(t);
		}
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
		addKeyListener(new KeyListener() {			

			@Override
			public void keyReleased(KeyEvent e) {

				int key = e.getKeyCode();

				switch (key) {
				case KeyEvent.VK_UP:
					dU = false;
					break;
				case KeyEvent.VK_DOWN:
					dD = false;
					break;
				case KeyEvent.VK_LEFT:
					dL = false;
					break;
				case KeyEvent.VK_RIGHT:
					dR = false;
					break;
				default:
					break;
				}
				if(!dU&&!dD&&!dL&&!dR){
					tank.setMoving(false);
				}
				setMainTankDir();

			}

			@Override
			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();

				switch (key) {
				case KeyEvent.VK_UP:
					dU = true;
					break;
				case KeyEvent.VK_DOWN:
					dD = true;
					break;
				case KeyEvent.VK_LEFT:
					dL = true;
					break;
				case KeyEvent.VK_RIGHT:
					dR = true;
					break;
				case KeyEvent.VK_SPACE:
					tank.fire();
				default:
					break;
				}
				if(!dU&&!dD&&!dL&&!dR){
					tank.setMoving(false);
				}
				else {
					tank.setMoving(true);
				}
				setMainTankDir();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹数:"+bullets.size(),10, 50);
		g.setColor(c);
		tank.paint(g);
		
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).paint(g);
		}
		
		for(int i=0;i<bullets.size();i++){			
			for(int j=0;j<tanks.size();j++){
				if(bullets.get(i).collison(tanks.get(j))){
					bullets.get(i).dead();
					tanks.get(j).dead();
				}
			}			
		}
		for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);	
			
		}
	}
	/**
	 * 设置tank的方向
	 */
	private void setMainTankDir(){
		if(dU){
			dir=Dir.UP;
		}
		if(dD){
			dir=Dir.DOWN;
		}
		if(dL){
			dir=Dir.LEFT;
		}
		if(dR){
			dir=Dir.RIGHT;
		}
		tank.setDir(dir);
	}
}
