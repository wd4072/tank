import java.util.ArrayList;
import java.util.List;

/**
 * 事件源对象
 * @author wangdong
 *
 */
public class Child {
	public boolean weakup=false;
	List<Observer> observers =  new ArrayList<>();
	
	public void addObserver(Observer o){
		observers.add(o);
	}
	
	public void weakup() {
		System.out.println("我醒了, wawawawawawa.......");
		for(Observer item:observers){
			item.actionOnWeakup();
		}
	}
}
