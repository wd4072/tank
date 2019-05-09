
public class TankMain {
	public static void main(String[] args) {
		TankFrame frame = new TankFrame();
		while (true) {
			try {
				Thread.sleep(50);
				frame.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
