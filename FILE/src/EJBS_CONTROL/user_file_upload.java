package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import CONFIGURE.Connec_Config;

@ManagedBean
@RequestScoped
public class user_file_upload {

	     UploadedFile file;
	     String price, name,email,address,error,orders;
		Integer mobile_agents;
	     int increment;
	    List<user_file_upload> order_list,Second_orderlist;
	    StreamedContent 	order_list_img;
	    boolean a1=false;
	    boolean a2=false;
	    boolean a3=true;
	    boolean a4;
	    String  id,pricess,quantity,total,person,wall_ownerid,img;



		

	



		public user_file_upload() {
				
	    	 Quick_check();
	 		increment=2;

		  }
		
	
	
		
		
		
		
		public String getId() {
			return id;
		}






		public void setId(String id) {
			this.id = id;
		}






		public String getPricess() {
			return pricess;
		}






		public void setPricess(String pricess) {
			this.pricess = pricess;
		}






		public String getQuantity() {
			return quantity;
		}






		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}






		public String getTotal() {
			return total;
		}






		public void setTotal(String total) {
			this.total = total;
		}






		public String getPerson() {
			return person;
		}






		public void setPerson(String person) {
			this.person = person;
		}






		public String getWall_ownerid() {
			return wall_ownerid;
		}






		public void setWall_ownerid(String wall_ownerid) {
			this.wall_ownerid = wall_ownerid;
		}






		public String getImg() {
			return img;
		}






		public void setImg(String img) {
			this.img = img;
		}



		
		
		
				public boolean isA1() {
					return a1;
				}
		
		
		
		
				public void setA1(boolean a1) {
					this.a1 = a1;
				}
		
		
		
		
				public boolean isA2() {
					return a2;
				}
		
		
		
		
				public void setA2(boolean a2) {
					this.a2 = a2;
				}
		
		
		
		
				public boolean isA3() {
					return a3;
				}
		
		
		
		
				public void setA3(boolean a3) {
					this.a3 = a3;
				}
		
		
		
		
				public boolean isA4() {
					return a4;
				}
		
		
		
		
				public void setA4(boolean a4) {
					this.a4 = a4;
				}
		
		
		
			     
				public String getOrders() {
					return orders;
				}






				public void setOrders(String orders) {
					this.orders = orders;
				}
			     
					
					
					
					
			 	public Integer getIncrement() {
					return increment;
				}
		
		
				public void setIncrement(Integer increment) {
					this.increment = increment;
				}
			
			        public String getError() {
					return error;
				}
		
		
		
				public void setError(String error) {
					this.error = error;
				}
		
		
		
					public Integer getMobile_agents() {
					return mobile_agents;
				}
		
		
		
					public void setMobile_agents(Integer mobile_agents) {
					this.mobile_agents = mobile_agents;
				}
		
		
		
					public String getPrice() {
					return price;
				  }
		
		
		
				public void setPrice(String price) {
					this.price = price;
				}
		
		
		
				public String getName() {
					return name;
				}
		
		
		
				public void setName(String name) {
					this.name = name;
				}
		
		
		
				public String getEmail() {
					return email;
				}
		
		
		
				public void setEmail(String email) {
					this.email = email;
				}
		
		
		
				public String getAddress() {
					return address;
				}
		
		
		
				public void setAddress(String address) {
					this.address = address;
				}
		
		
		 
					public UploadedFile getFile() {
						return file;
					}
		
					public void setFile(UploadedFile file) {
						this.file = file;
					}
					
					
					
					public String send_in() {
					if(price.isEmpty()|price.length()==0) {
					
						error="Pls Enter a Price";
						return "/Profile_post_editable.xhtml";
						
					}else if(!new QueDAO().Corrupt_char(price)){
					
						error="Invalid data";
						return "/Profile_post_editable.xhtml";
					
					}else if(new Singleton().getEmail().trim().equals("-0000-")){
						 
						 error=" Pls  Sign in ";
							return "/Profile_post_editable.xhtml";
					 
					}else {
						try {
						UploadEvent(file);
						}catch (Exception e) {
							System.out.println(e);
						}
						
					}
					
					
					return "Profile_post_editable.xhtml";
				
					}
		
					
					
					
					
			
					
					
		     String h;
					 public  String UploadEvent(UploadedFile file){
						 if(file.getSize()==0) {
							 
								error="Pls  upload Pics";
								h="Profile_post_editable.xhtml";
						 }else {
							 try {
						 
								 byte f [] =IOUtils.toByteArray(file.getInputstream());
						 
								 email=new Singleton().getEmail();
							 
				
									 
								new user_file_sql_uploader().Pass_on(f,email,price,new Singleton().getAddressing());
								error="Uploaded Successfully";	
								h="Profile_post_editable.xhtml";	
								 }catch (Exception e) {
									 
								System.out.println(e);
								
								}
					 }
					return h; }
		
		
					
			   
			
		     	public  String view_order(){
		
		     		a1=true;
		     		 a3=false;
		     		System.out.println(new Singleton().getEmail());
				return "Profile_post_editable.xhtml";	
		
		     	}
				
			
			
		     @SuppressWarnings("unchecked")
			public List<user_file_upload> getOrder_list() {
					return new user_file_sql_uploader().get_intro_query(new Singleton().getAddressing());
				}





				public void setOrder_list(List<user_file_upload> order_list) {
					this.order_list = order_list;
				}
			
			
				
				
				
				public String send_ins() {
					FacesContext context=FacesContext.getCurrentInstance();
					String gogo=context.getExternalContext().getRequestParameterMap().get("XXX");
					new Singleton().setView_orders_idlist(gogo);
					
					 a1=false;
					 a2=true;
					 a3=false;
				return "Profile_post_editable.xhtml";}
				
				
				
			 	@SuppressWarnings("unchecked")
				public List<user_file_upload> getSecond_orderlist() {
					return new user_file_sql_uploader().Unique_email_orders(new Singleton().getView_orders_idlist());
				}






				public void setSecond_orderlist(List<user_file_upload> second_orderlist) {
					Second_orderlist = second_orderlist;
				}
				
				
				
				
				
				
				public StreamedContent getOrder_list_img() {
					
					FacesContext context=FacesContext.getCurrentInstance();
					if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
						return new DefaultStreamedContent();
					}else {
						
						byte [] img=null;
					
						String gh=context.getExternalContext().getRequestParameterMap().get("WEQ");
					 
					img= new user_file_sql_uploader().Unique_email_ordersimg(gh);
					return new DefaultStreamedContent(new ByteArrayInputStream(img));
				}}





				public void setOrder_list_img(StreamedContent order_list_img) {
					this.order_list_img = order_list_img;
				}
				
				
			
				
				
			
			private int Quick_check() {
				
				
				
				
				return 0;}
			
			
			
		

}
