package EJBS_CONTROL;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import CONFIGURE.Connec_Config;

@ManagedBean
@RequestScoped
public class Sign_in {

	
	 String email,pass,zap,error;
	 static boolean  User_acccount;
		

		
				 public Sign_in() {
					  
				  }
		
				 
					 
	    public boolean isUser_acccount() {
			return User_acccount;
		}
	
		public void setUser_acccount(boolean user_acccount) {
			this.User_acccount = user_acccount;
		}
				 
		 public String getError() {
			return error;
		}
	
		public void setError(String error) {
			this.error = error;
		}
	
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		public String getPass() {
			return pass;
		}
	
		public void setPass(String pass) {
			this.pass = pass;
		}

	
	
	
	public String check() throws IOException {
		if(email.isEmpty()|pass.isEmpty()) {

			zap="/Sign.xhtml"; 
			error="Pls  fill all Fields ";
		}else {
			   Pattern mask=null;  
               mask=Pattern.compile(".+@.+\\.[a-z]+");
                Matcher matcher=mask.matcher(email);
                if(!matcher.matches()){
                	error=("Pls enter a valid email"); 
                }else {
	
                	
                	
		           Connec_Config config= new Connec_Config();
					Connection cons;
					cons=config.getConnection();
					try {
					PreparedStatement ps= cons.prepareStatement("select * from public.useraccounts where emailid ='"+email.toLowerCase()+"' and password='"+pass+"'");
				  ResultSet rs=ps.executeQuery();
				  while(rs.next()) {
					  
				new Singleton().setEmail(email.toLowerCase());
				
				  FacesMessage  message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcme ", "User :"+email);
					FacesContext.getCurrentInstance().addMessage(null, message);
					new Sign_in().setUser_acccount(true);
					email="";
				return	  "/index.xhtml";
					  
					  
				  }while(!rs.next()) {
					  
				  FacesMessage  message=new FacesMessage(FacesMessage.SEVERITY_INFO,"Login failed ", "Username or password incorrect");
					FacesContext.getCurrentInstance().addMessage(null, message);

					return	  "/Sign_in.xhtml";
				  }
					}catch (Exception e) {
						
						System.out.println(e);
					} finally {
			        	  try {
			        		  cons.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
				
                }}
				
		return "";}
	
	


	public String Clear() throws IOException {
		new Singleton().setEmail("-0000-");
		new Singleton().setStore_owner(" ");
		new Singleton().setAddressing(" ");
		new Sign_in().setUser_acccount(false);
	 return null;}
	
	
	
}
