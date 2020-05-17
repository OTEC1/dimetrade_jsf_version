package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
//import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import CONFIGURE.Connec_Config;

@ManagedBean
@SessionScoped
public class Current_GraphicImageUser  implements Serializable{

	
	  private static final long serialVersionUID = 1L;
	  public String name, phone,email,account_nu,dime_add,k,
	  address,AS,ref,dime,gas,kl,zx,c,l;
	  int o;
      public StreamedContent userImages,wallet_user_Images,
      One_wallet_user_image ;
     @SuppressWarnings("unused")
	  private List<Current_GraphicImageUser>credentialsList,
	  wallet_user_list;
       @SuppressWarnings("unused")
	   private List<Current_GraphicImageUser> figureRunner; 
  		
  		

  		
  		
  	  
	public Current_GraphicImageUser() throws IOException {
  	
  		 
  		 
  		 
  		 
  		 
  		
  	   }
  	
  	 
	   //Figure_Runner
       @SuppressWarnings("unchecked")
	     public List<Current_GraphicImageUser> getFigureRunner() throws IOException, SQLException{

    	   return new  WebAPI_CONSQ_Current_User_block().constant_query(new  Singleton().getEmail());
	    }

	public void setFigureRunner(List<Current_GraphicImageUser> figureRunner) {
		this.figureRunner = figureRunner;
	}
	
	
	


	@SuppressWarnings("unchecked")
	public List<Current_GraphicImageUser> getCredentialsList()throws IOException, SQLException {
       
     
		return  new CurrentUserImageDAO().getAllCre(new Singleton().getStore_owner());
    }

    public void setCredentialsList(List<Current_GraphicImageUser> credentialsList) {
        this.credentialsList = credentialsList;
    }
    
    

    public StreamedContent getUserImages() throws IOException, SQLException {
    	
    	FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {

			byte[] image = null;
			

			image = new CurrentUserImageDAO().getProductImage(new Singleton().getStore_owner());

			return new DefaultStreamedContent(new ByteArrayInputStream(image)
					);

		}
    
	}


	public void setUserImages(StreamedContent userImages) {
		this.userImages = userImages;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
   
	   @SuppressWarnings("unchecked")
	public List<Current_GraphicImageUser> getWallet_user_list() throws IOException, SQLException {
		
     					
		 return new CurrentUserImageDAO().usermining(new  Singleton().getEmail());
	}


	public void setWallet_user_list(List<Current_GraphicImageUser> wallet_user_list) {
		this.wallet_user_list = wallet_user_list;
	}
    
	
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAccount_nu() {
        return account_nu;
    }

    public void setAccount_nu(String account_nu) {
        this.account_nu = account_nu;
    }

    public String getDime_add() {
        return dime_add;
    }

    public void setDime_add(String dime_add) {
        this.dime_add = dime_add;
    }
    
    
    
    public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDime() {
		return dime;
	}

	public void setDime(String dime) {
		this.dime = dime;
	}

	public String getGas() {
		return gas;
	}

	public void setGas(String gas) {
		this.gas = gas;
	}



    public StreamedContent getOne_wallet_user_image() throws IOException, SQLException {
		FacesContext context= FacesContext.getCurrentInstance();
		if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		}else {

			byte [] img=null;

			img=new CurrentUserImageDAO().Wallet_user_image(new  Singleton().getEmail());
			return new DefaultStreamedContent(new ByteArrayInputStream(img));
		}
	}


	public void setWallet_user_image(StreamedContent One_wallet_user_image) {
		this.One_wallet_user_image = One_wallet_user_image;
	}

	
	
	
    

    
    
	
	   public StreamedContent getWallet_user_Images() throws IOException, SQLException {
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	
		   if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			} else {

			byte[] image = null;
			
						
				image = new CurrentUserImageDAO().getProduct(new  Singleton().getEmail());

				return new DefaultStreamedContent(new ByteArrayInputStream(image)
						);

			}
			}


			public void setWallet_user_Images(StreamedContent wallet_user_Images) {
				this.wallet_user_Images = wallet_user_Images;
			}
			
			
		
			
			public String print() {
				System.out.println(new Singleton().getStore_owner());
			return null;}
				
     
}
