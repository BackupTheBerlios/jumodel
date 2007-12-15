package travel.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

//@Service("myBean")
//@Configurable
public class MyBean {
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
