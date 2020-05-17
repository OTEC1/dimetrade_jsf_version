package EJBS_CONTROL;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.UploadedFile;
import CONFIGURE.Connec_Config;


@ManagedBean
@SessionScoped
public class Register implements Serializable{

    /**
     * Default constructor. 
     */
	

	  private static final long serialVersionUID = 1L;
	  
                private UploadedFile upload;
                String name,address,password,phone,email,account,
				 flows1,flows,as,bigran,bigrans,a1,
				 a2,zx,keep,zxt,error,filename,ADS,h,vb,wq,State;
                 int ask, sd,fu,lo,ko,check,next,s;
                 boolean fix=false;
    			 long min,cb;
                 Integer mobile_agents;

             	public Register() {
					   
				} 





				public Integer getMobile_agents() {
					return mobile_agents;
				}



				public void setMobile_agents(Integer mobile_agents) {
					this.mobile_agents = mobile_agents;
				}


 
				 public boolean isFix() {
						return fix;
					}


	              public void setFix(boolean fix) {
						this.fix = fix;
					}

                
                public String getADS() {
					return ADS;
				}


				public void setADS(String aDS) {
					ADS = aDS;
				}

                  	public void Print() {
						 System.out.println(name);
				}

			
					
					
					public UploadedFile getUpload() {
						return upload;
					}
				
					public void setUpload(UploadedFile upload) {
						this.upload = upload;
					}
				
				
				 
				       public String getError() {
						return error;
					}
				
					public void setError(String error) {
						this.error = error;
					}
				
					
				       
				       public String getPhone() {
						return phone;
					}
				
				
				
					public void setPhone(String phone) {
						this.phone = phone;
					}
				
				
				
					public String getEmail() {
						return email;
					}
				
				
				
					public void setEmail(String email) {
						this.email = email;
					}
				
				
				
					public String getPassword() {
						return password;
					}
				
				
				
					public void setPassword(String password) {
						this.password = password;
					}
				
				
				
					public String getAccount() {
						return account;
					}
				
				
				
					public void setAccount(String account) {
						this.account = account;
					}
				
				
				
					public String getName() {
						return name;
					}
				
				
				
					public void setName(String name) {
						this.name = name;
					}
				
				
					  public String getState() {
							return State;
						}





						public void setState(String state) {
							State = state;
						}
				
					public String unfix() {
						fix=false;
						ADS="";
						error="";
					return "Register.xhtml";}
				
			

			public String Send() throws IOException {
		    	 
		    	   if(name.isEmpty()|name.trim().length()==0 
		    		  |password.isEmpty() |password.trim().length()==0
		    		  |phone.isEmpty()|phone.trim().length()==0
		    		  |email.isEmpty()|email.trim().length()==0 
		    		  |account.isEmpty()|account.trim().length()==0
		    		  |State.isEmpty()|State.trim().length()==0 ) {
		    		
		    		error=("Error Pls fill all  field's ");
		    		  zxt="/Register.xhtml";
		    	       System.out.println("1");
		      
		    	   }else  if(new LOCALS().result().equals("Choose  Location")){
		    	 
		    		   error=("Error Pls  Select Location");
			    		  zxt="/Register.xhtml";
		    	   
		    	   }else {
		               Pattern mask=null;  
		               mask=Pattern.compile(".+@.+\\.[a-z]+");
		                Matcher matcher=mask.matcher(email);
		                if(!matcher.matches()){
		                	error=("Pls enter a valid email"); 
		                	  System.out.println("2");
		              
		                
		                }else if(upload.getSize()==0) {
		                	error=("Pls upload a Photo ");
	                		zxt="/Register.xhtml";			                
	                		 System.out.println("3");       
									
		                }else  if(upload.getSize()!=0){
												                			handleFileUpload(upload,State,mobile_agents); 
																			 if(next==1) {
																				                	    
															                		error=("Successfully Registered ");
															                		zxt="/Register.xhtml";
															                		fix=true;
															                		
															                		name="";
															                		address="";
															                		password="";
															                		phone="";
															                		email="";
															                		account="";
															                		State="";
																				                	    }
												                	   }
		                                                        }
		  
		                             return zxt; }
	
	
	
	



				public void handleFileUpload(UploadedFile  upload, String State,Integer mobile_agents) throws IOException {		
				
					byte [] pics=org.apache.commons.io.IOUtils.toByteArray(upload.getInputstream());	
					addImage(pics, State,mobile_agents); 
					
				}


		       public String addImage(byte[] img, String State,Integer mg)  {
		
		    	   keep=AddressHash().trim();
		    	   
		    	   
		    		
					if(mg==(null)) {
						mg=0;
					}else {
						mg=1;
					}
					
					String s;
					 Connec_Config connect = new Connec_Config();
				  		
					  Connection connection = null;
				
					  try {
				
					  connection = connect.getConnection();
					   PreparedStatement ps = connection.prepareStatement("insert into public.mobile_agent(address,indication,house_address,reg_local)  values (?,?,?,?)");
					   ps.setString(1, keep.trim());
					   ps.setString(2, mg.toString());
					   ps.setString(3, State);
					   ps.setString(4, s=new LOCALS().result());
					   
					   MOBILE_AGENT(img,State,mg,keep);
					   
					   ps.executeUpdate();
					   System.out.println("|dddbbb|"+s);
					  
					   
					 
					  }catch (Exception e) {
						  
							error=("Registration Failed Pls Check back Later");
				    		  zxt="/Register.xhtml";
				    		  System.out.println("4");
						System.out.println(e);
					} finally {
			        	  try {
			        		  connection.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
		

					
			
			
				  
				return zxt;
				    
				
				    }

		   
		     
		        
		       

				private String MOBILE_AGENT( byte[] img, String a,Integer mg,String k) {
				
				
					  
					  Connec_Config connect = new Connec_Config();
						
					  Connection connection = null;
				
					  try {
				
							   connection = connect.getConnection();
				   
					   PreparedStatement ps = connection
				
					     .prepareStatement("INSERT INTO userAccounts(nameid,emailid,accountid,Phoneid,address,sub_address,password,dimage) VALUES (?,?,?,?,?,?,?,?)");
				
					   ps.setString(1,name.toLowerCase()); //name
					    ps.setString(2, email.toLowerCase());//email
					     ps.setString(3, account);//account
					      ps.setInt(4, ask=Integer.parseInt(phone));//Phone    
					       ps.setString(5,  k.trim());//address
					        ps.setString(6, flows1.trim());//Sub_address
					        ps.setString(7, password);
					         ps.setBytes(8, img);
					  

						       WALLET_FUN(img ,State,mg,keep);
							
					        ps.executeUpdate();
					  
					     

						  } catch (SQLException e) {      
						
							  error=("Check Email Already in Use");
								
							  zxt="Register.xhtml";
							  System.out.println("6");
						 
						  } finally {
				        	  try {
				        		  connection.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
			

			 return zxt;	}
			       
			       
				
				
				
			     
		       
		       
		       
		      protected String  WALLET_FUN(byte[] img, String a,Integer mg,String y) {
		    	  Connec_Config connect = new Connec_Config();
		  		
				  Connection connection = null;
			
				  try {
			
				  connection = connect.getConnection();
				   PreparedStatement ps = connection.prepareStatement("insert into public.dime_stack(email,sip,lip,dip,bits) values (?,?,?,?,?)");
				   ps.setString(1, email.toLowerCase());
				   ps.setString(2, "0");
				   ps.setString(3, "0");
				   ps.setString(4, "0");
				   ps.setString(5, "0");
				   
				 
				   ps.executeUpdate();
				   error=("Registered Succesfully");
				   next=1;
				  }catch(Exception ex) {System.out.println(ex);  
				  System.out.println("5");
				  
				  error=("Error Ocurred Try Again");
					
				  zxt="Register.xhtml";
				  }
				  finally {
		        	  try {
		        		  connection.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
	

				 
			
		     
		      return zxt;}




		   




			int can;
	          public String AddressHash() {
	        
	        	  String sw= name.trim();
		        	 int s=sw.length();
		        	
		        	 if(s>6) {	 
		        		 can=5;
		        	   String hi=sw.substring(0, can).trim();
			    	    min=System.currentTimeMillis();
			    	    cb=System.nanoTime()+System.currentTimeMillis();
			    	    vb=String.valueOf(min);
			    	    wq=vb.substring(7, 13);
			    	   h=hi.concat("_"+wq.trim());
			    	   flows1=String.valueOf(cb);
			    	   ADS=h;
			    	    System.out.println("UNIQUE ID GEN<> "+h);
				    	   System.out.println("UNIQUE SUB_ID GEN<> "+wq);
		        	
		        	 }else if(s<=3) {
		        		 can=2;
		        		   String hi=sw.substring(0, can).trim();
				    	    min=System.currentTimeMillis();
				    	    cb=System.nanoTime()+System.currentTimeMillis();
				    	    vb=String.valueOf(min);
				    	    wq=vb.substring(7, 13);
				    	   h=hi.concat("_"+wq.trim());
				    	   flows1=String.valueOf(cb);
				    	   ADS=h;
				    	    System.out.println("UNIQUE ID GEN<> "+h);
					    	   System.out.println("UNIQUE SUB_ID GEN<> "+wq);
			        	
		        	 }else if(s<=6){
		        		 can=4;
		        		  String hi=sw.substring(0, can).trim();
				    	    min=System.currentTimeMillis();
				    	    cb=System.nanoTime()+System.currentTimeMillis();
				    	    vb=String.valueOf(min);
				    	    wq=vb.substring(7, 13);
				    	   h=hi.concat("_"+wq.trim());
				    	   flows1=String.valueOf(cb);
				    	   ADS=h;
				    	    System.out.println("UNIQUE ID GEN<> "+h);
					    	   System.out.println("UNIQUE SUB_ID GEN<> "+wq);
		        	 }
		           
		  return h; }
  
    
	          
	          
	       
		       
//		private void Uploaders(UploadedFile upload) throws IOException {
//        
//	
////       FileInputStream fis= null;
////        
//// try{
////            fis = new FileInputStream(upload));
////            ByteArrayOutputStream bos= new ByteArrayOutputStream();
////            byte[] buf = new byte[1024];
////            try{
////                for(int readNum; (readNum=fis.read(buf)) != -1;){
////                    bos.write(buf, 0, readNum);
////                    System.out.println("read"+readNum+ "byte");
////                }
////            }catch(IOException ex){
////                System.out.println("reading Error"+ex);
////                System.out.println( "Error Occured Pls Upload a Picture");
////         }
////          byte []  bytes=  bos.toByteArray();
//// 
////            addImage(bytes); 
//// }catch(FileNotFoundException e){
////	 zxt="Register";
////	 error="Uploading Error Try Again";
////
////     System.out.println("Error "+e);
////        }
//        }
	        

}
