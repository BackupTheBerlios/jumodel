package travel.jsf.mBeans.main;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class AppContext {
	private String imgRes;
	private String cssRes;
	private String mainRes;
	private String clientRes;
	private String workerRes;
	private String managerRes;
	private boolean debug=false; 
	
	
	public String getMainRes() {
		return mainRes;
	}

	public void setMainRes(String mainRes) {
		this.mainRes = mainRes;
	}

	public String getClientRes() {
		return clientRes;
	}

	public void setClientRes(String clientRes) {
		this.clientRes = clientRes;
	}

	public String getWorkerRes() {
		return workerRes;
	}

	public void setWorkerRes(String workerRes) {
		this.workerRes = workerRes;
	}

	public String getManagerRes() {
		return managerRes;
	}

	public void setManagerRes(String managerRes) {
		this.managerRes = managerRes;
	}

	public String getBaseUrl() {
		HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String path = request.getContextPath();
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	}
	
	public String go2Home() {
		return "HOME";
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
}
