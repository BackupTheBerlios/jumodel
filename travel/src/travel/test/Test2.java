package travel.test;

import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service("Test2")
@Configurable(autowire=Autowire.BY_TYPE, dependencyCheck=true)
public class Test2 {
	int in=new Random().nextInt(100);
	@Autowired
	private SessionFactory sessionFactory;
	
	public void metoda() {
		System.out.println(sessionFactory);
		System.out.println("ico");
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
