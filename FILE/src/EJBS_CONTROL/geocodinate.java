package EJBS_CONTROL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class geocodinate {

	public String confim() {
		addMessage("","Refreash Page afterwards...");
		return "index";}

	private void  addMessage(String string, String ms) {
	
	
	FacesMessage  message=new FacesMessage(FacesMessage.SEVERITY_INFO,string, ms);
	FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
