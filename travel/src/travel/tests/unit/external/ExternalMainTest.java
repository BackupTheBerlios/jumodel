package travel.tests.unit.external;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import travel.business.facades.ExternalFacade;
import travel.business.facades.impl.ExternalFacadeImpl;
import travel.test.MyBean;

public class ExternalMainTest {
	@Test
	public void amountOfQuarters() {
		ExternalFacade facade=new ExternalFacadeImpl();
		assertNotNull("Lista jest null", facade.getQuarterList());
	}
	
	@Test
	public void krotkiTest() {
		ApplicationContext ctx=new FileSystemXmlApplicationContext("D:/programowanie/projekty/rhds3/travel/WebContent/WEB-INF/applicationContext*.xml");
		//ExternalFacade bean= (ExternalFacade) ctx.getBean("externalFacade");
		MyBean bean= (MyBean) ctx.getBean("bean");
		assertEquals("Dupa tam", bean.getName(), "Rafik");
	}
}
