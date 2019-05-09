import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author wangdong
 *
 */
public class PropetyMgr {
	
	private static Properties property = new Properties();
	public static Object getPropety(String key){
		try {
			property.load(PropetyMgr.class.getResourceAsStream("config"));
			return property.get(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
