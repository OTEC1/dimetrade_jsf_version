package EJBS_CONTROL;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Message  implements Serializable{

	
	private static final long serialVersionUID = 1L;
		String  value;
		static String value1;
		
		
		
		
		public String getValue1() {
			return value1;
		}

		public void setValue1(String value1) {
			this.value1 = value1;
		}

		public  Message() {
			
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
		public String leg_Over() {
			System.out.println("YUYUY  "+value);
	value1=value;
		return "";}
		
		public void clear() {
			value1=value;
			value="";
		}
		
	
	
}
