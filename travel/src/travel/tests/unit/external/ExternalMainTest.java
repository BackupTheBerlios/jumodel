package travel.tests.unit.external;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import travel.business.facades.ExternalFacade;
import travel.tests.TestSpringCtx;

public class ExternalMainTest {
	private ApplicationContext ctx=TestSpringCtx.getCtx();
	
	@Test
	public void amountOfQuarters() {
		ExternalFacade facade= (ExternalFacade) ctx.getBean("externalFacade");
		assertNotNull("Lista jest null", facade.getQuarterList());
		System.out.println(facade.getQuarterList().get(0).getOffers());
	}
	
	@Test
	public void krotkiTest() {
	
	}
}
