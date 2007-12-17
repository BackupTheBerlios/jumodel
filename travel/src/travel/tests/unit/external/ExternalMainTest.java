package travel.tests.unit.external;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import travel.business.facades.ExternalFacade;
import travel.test.MyBean;
import travel.tests.TestSpring;

public class ExternalMainTest {
	private ApplicationContext ctx=TestSpring.getCtx();
	
	@Test
	public void amountOfQuarters() {
		ExternalFacade facade= (ExternalFacade) ctx.getBean("externalFacade");
		assertNotNull("Lista jest null", facade.getQuarterList());
		System.out.println(facade.getQuarterList().get(0).getOffers());
	}
	
	@Test
	public void krotkiTest() {
		MyBean bean= (MyBean) ctx.getBean("bean");
		assertEquals("Dupa tam", bean.getName(), "Rafik");
	}
}
