package travel.tests.unit.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import travel.business.facades.UserFacade;
import travel.tests.TestSpringCtx;

public class UserMainTest {
	private ApplicationContext ctx=TestSpringCtx.getCtx();
	
	@Test
	public void authentication() {
		UserFacade facade= (UserFacade) ctx.getBean("userFacade");
		assertTrue(facade.authenticate("rafik", "ziutek"));
		assertFalse(facade.authenticate("rafik", "zlehaslo"));
		assertTrue(facade.authenticate("piotrek", "piotrek"));
		assertFalse(facade.authenticate("piotrek", "badpasswd"));
		assertFalse(facade.authenticate("noname", "nopass"));
	}
	
	@Test
	public void krotkiTest() {
	
	}
}
