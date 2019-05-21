
public class Main {
	public static void main(String[] args) {
		Child c = new Child();
		c.addObserver(new Dad());
		c.addObserver(new Dog());
		c.weakup();
	}
}	
