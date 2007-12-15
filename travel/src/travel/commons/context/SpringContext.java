package travel.commons.context;

import javax.faces.context.FacesContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;


public class SpringContext {
	
	/*private static ServletContext servletContext;
	private static WebApplicationContext ctx;*/
	static {
		System.out.println("klasa zostala utworzona");
	}
	
	/*
	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static void setServletContext(ServletContext servletContext) {
		SpringContext.servletContext = servletContext;
	}
*/
	public static WebApplicationContext getCtx() {
		
	/*	if (ctx==null) {
			ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		}*/
		return FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance());
	}

}
