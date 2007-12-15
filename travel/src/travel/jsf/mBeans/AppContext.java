package travel.jsf.mBeans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class AppContext {
	private String baseUrl;
	private String imgRes;
	private String cssRes;
	
	
	public String getBaseUrl() {
		if (baseUrl==null) {
			HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String path = request.getContextPath();
			baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		}
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getImgRes() {
		return imgRes;
	}
	public void setImgRes(String imgRes) {
		this.imgRes = imgRes;
	}

	public String getCssRes() {
		return cssRes;
	}
	public void setCssRes(String cssRes) {
		this.cssRes = cssRes;
	}
	
}
