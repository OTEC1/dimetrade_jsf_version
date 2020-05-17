package EJBS_CONTROL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LOCALS {

	
	
	  static String res,t1="Choose  Location",
			      t2="Biafra";
	   	
		
			  public String getT2() {
				return t2;
			}
		
			public void setT2(String t2) {
				this.t2 = t2;
			}



		
	  
	           public String getRes() {
					return res;
				}
			
				public void setRes(String res) {
					this.res = res;
				}



		String h="";
      public String getT1() {
		return t1;
	}

    public void setT1(String t1) {
		this.t1 = t1;
	
    }
    
    
    
    public String result() {
   
    	if(res.equals("a1")) {
    		res=t1;
    	}else if(res.equals("a2")){
    		res=t2;
    	}
    
    return res;}

}
