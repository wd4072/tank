import java.io.InputStream;
import java.util.List;

import javax.swing.Spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sun.corba.se.spi.activation.Server;
import com.wangdong.mapper.UserMapper;
import com.wangdong.pojo.User;
import com.wangdong.service.UserService;

import sun.print.resources.serviceui;

@Component
public class UserTest2 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service =(UserService)context.getBean("userServiceImpl");
		List<User> users = service.getAllUsers();
		for (User user : users) {
			System.out.println(user.toString());
		}
	
	}
	
}
