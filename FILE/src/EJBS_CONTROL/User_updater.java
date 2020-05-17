package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
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

@ManagedBean
@RequestScoped
public class User_updater {

	
			protected List <User_updater> userUpdatePost, userUpdateProfile;
			protected StreamedContent userUpdatePost_img,userUpdateProfile_img;
			protected   String price,store_owner_id,id,sign;	
		   protected UploadedFile uploadedFile;
	       protected static String nameid,emailid,accountid,phoneid,address,ids;
					
	   
							


								public User_updater() {
												    	
									     }
					
					
	
	          public  String user_editor() throws IOException {
				 FacesContext context= FacesContext.getCurrentInstance();
				 Map<String, String> gos= context.getExternalContext().getRequestParameterMap();
				 String bot=gos.get("");
				 
	             
			 
	        	return "/Profile_post_editable.xhtml";}
	
	
	
			
		            //Post Section
						
						@SuppressWarnings("unchecked")
						public List<User_updater> getUserUpdatePost() {
							return new PandPUpdate().user_post_details(new Singleton().getEmail());
						}





						public void setUserUpdatePost(List<User_updater> userUpdatePost) {
							this.userUpdatePost = userUpdatePost;
						}
						
						
						

						public StreamedContent getUserUpdatePost_img() {
							FacesContext context=FacesContext.getCurrentInstance();
							if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
								return new DefaultStreamedContent();
						
							}else {
							
							     	byte [] img=null;
							     	String cv=context.getExternalContext().getRequestParameterMap().get("POP");  	
							     
							     	img= new PandPUpdate().user_post_Image(cv);
							
							return new   DefaultStreamedContent(new ByteArrayInputStream(img));
							}
						}





						public void setUserUpdatePost_img(StreamedContent userUpdatePost_img) {
							this.userUpdatePost_img = userUpdatePost_img;
						}
						

						
								public String getId() {
									return id;
								}
							
							
							
								public void setId(String id) {
									this.id = id;
								}

						
						
						   public String getPrice() {
								return price;
							}
						
							public void setPrice(String price) {
								this.price = price;
							}
						
							public String getStore_owner_id() {
								return store_owner_id;
							}
						
							public void setStore_owner_id(String store_owner_id) {
								this.store_owner_id = store_owner_id;
							}


							
							
							public String getNameid() {
								return nameid;
							}



							public void setNameid(String nameid) {
								this.nameid = nameid;
							}



							public String getEmailid() {
								return emailid;
							}



							public void setEmailid(String emailid) {
								this.emailid = emailid;
							}



							public String getAccountid() {
								return accountid;
							}



							public void setAccountid(String accountid) {
								this.accountid = accountid;
							}



							public String getPhoneid() {
								return phoneid;
							}



							public void setPhoneid(String phoneid) {
								this.phoneid = phoneid;
							}



							public String getAddress() {
								return address;
							}



							public void setAddress(String address) {
								this.address = address;
							}


							
							public  String getIds() {
								return ids;
							}
					
					
					
							public  void setIds(String ids) {
								this.ids = ids;
							}

							
							public String getSign() {
								return sign;
							}



							public void setSign(String sign) {
								this.sign = sign;
							}

                      //Profile Section
						
						@SuppressWarnings("unchecked")
						public List<User_updater> getUserUpdateProfile() throws IOException {
							return new PandPUpdate().user_profile_details(new Singleton().getEmail());
						}





						public void setUserUpdateProfile(List<User_updater> userUpdateProfile) {
							this.userUpdateProfile = userUpdateProfile;
						}


						
						
						public StreamedContent getUserUpdateProfile_img() throws IOException {
							
							FacesContext context= FacesContext.getCurrentInstance();
							
						    if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
						    	return new DefaultStreamedContent();
						    }else {
							
							byte [] img=null;
							
						
							img= new PandPUpdate().user_profile_Image(new  Singleton().getEmail());
							
							return new  DefaultStreamedContent(new ByteArrayInputStream(img));}
						}





						public void setUserUpdateProfile_img(StreamedContent userUpdateProfile_img) {
							this.userUpdateProfile_img = userUpdateProfile_img;
						}

						
						

						public UploadedFile getUploadedFile() {
							return uploadedFile;
						}
					
					
					
						public void setUploadedFile(UploadedFile uploadedFile) {
							this.uploadedFile = uploadedFile;
						}
					
						
					
						
                      public String  Send_in_update() throws SQLException, IOException {
                    if(new Singleton().getEmail().equals("-0000-")) {
                    	  sign="Pls Sign in";
                    	return"/Profile_post_editable.xhtml";
                    	
                      } else   	  if(nameid.isEmpty()|nameid.trim().length()==0
                    	   |emailid.isEmpty()|emailid.trim().length()==0
                    	   |accountid.isEmpty()|accountid.trim().length()==0
                    	   |phoneid.isEmpty()|phoneid.trim().length()==0
                    	   |address.isEmpty()|address.trim().length()==0) {
                    		 System.out.println("Empty");
                    	 }else {
                    	  byte [] cv=IOUtils.toByteArray(uploadedFile.getInputstream());
                    	  if(uploadedFile.getSize()==0) {
                    			new  PandPUpdate().UpdatePosts(ids,nameid,emailid,accountid,phoneid,address,new Singleton().getEmail());
                                
                    	  }else {
							new  PandPUpdate().UpdatePost(ids,nameid,emailid,accountid,phoneid,address,cv,new Singleton().getEmail());
                    	 }}
                      return "/Profile_post_editable.xhtml";}
							
						

}
