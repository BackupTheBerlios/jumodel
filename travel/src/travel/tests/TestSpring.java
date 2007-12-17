package travel.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring {
	private static ApplicationContext ctx;
	private static String pathBase="D:/programowanie/projekty/rhds3/";

	public static ApplicationContext getCtx() {
		if (ctx==null) {
			ctx=new FileSystemXmlApplicationContext(pathBase+"travel/WebContent/WEB-INF/tests/applicationContext*.xml");
		}
		return ctx;
	}

	public static void setCtx(ApplicationContext ctx) {
		TestSpring.ctx = ctx;
	}
	
}
