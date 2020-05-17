package EJBS_CONTROL;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import CONFIGURE.Connec_Config;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class RecipetDAO {

	  private static final long serialVersionUID = 1L;
	    
	   protected List <RecipetDAO> itemlist, itemlist_sum;
	   protected String price,broom,Quantity,total,Item,id,kok,cs,d; 
	   protected StreamedContent  Imagesender;
	   protected String wallet_address,address,phone,card_no,CCV,remarks,outputing; 
     
      
      
      
  	public String getOutputing() {
		return outputing;
	}



	public void setOutputing(String outputing) {
		this.outputing = outputing;
	}
	
	
	   public RecipetDAO(){
	 
	 }
	   
	   
	   
		public String getCard_no() {
			return card_no;
		}


		public void setCard_no(String card_no) {
			this.card_no = card_no;
		}
	  
	 
	   public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	 public String getCs() {
		return cs;
	}


	public void setCs(String cs) {
		this.cs = cs;
	}


	public String NEXT_FACEA() throws SQLException {
		 Connection cons;
		 CONFIGURE.Connec_Config bv= new CONFIGURE.Connec_Config();
		 
		 FacesContext faces=FacesContext.getCurrentInstance();
		 Map<String, String> pa=faces.getExternalContext().getRequestParameterMap();
		 kok=pa.get("sender1");
		 
		 cons=bv.getConnection();
		 PreparedStatement ps=cons.prepareStatement("delete  from public.user_order where id="+kok);
		 ps.executeUpdate();
		 cons.close();
		
		 
	 return"Invoice2.xhtml";}
	 
	 
	 public String NEXT_FACEB()  {
		 
		 
		 Connection cons;
		 CONFIGURE.Connec_Config bv= new CONFIGURE.Connec_Config();
		 
		 FacesContext faces=FacesContext.getCurrentInstance();
		 Map<String, String> pa=faces.getExternalContext().getRequestParameterMap();
		 kok=pa.get("sender1");
		 
		 cons=bv.getConnection();
		 try {
		 PreparedStatement ps=cons.prepareStatement("delete  from public.user_order where id="+kok);
		 ps.executeUpdate();
		 }catch (Exception e) {
			
			 System.out.println(e);
		}finally {
			 try {
				cons.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		 return"Invoice1.xhtml";}
	 
	 
	   
 
          public String getWallet_address() {
      		return wallet_address;
      	}



      	public void setWallet_address(String wallet_address) {
      		this.wallet_address = wallet_address;
      	}



      	public String getAddress() {
      		return address;
      	}



      	public void setAddress(String address) {
      		this.address = address;
      	}



      	public String getPhone() {
      		return phone;
      	}



      	public void setPhone(String phone) {
      		this.phone = phone;
      	}



      



      	public String getCCV() {
      		return CCV;
      	}



      	public void setCCV(String cCV) {
      		CCV = cCV;
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

	    

	    public String getQuantity() {
	        return Quantity;
	    }

	    public void setQuantity(String Quantity) {
	        this.Quantity = Quantity;
	    }

	    public String getTotal() {
	        return total;
	    }

	    public void setTotal(String total) {
	        this.total = total;
	    }

	    public String getItem() {
	        return Item;
	    }

	    public void setItem(String Item) {
	        this.Item = Item;
	    }
	    
	    @SuppressWarnings("unchecked")
		public List<RecipetDAO> getItemlist() {
	//  List vb= new  ArrayList();
	  
	                broom=  new Singleton().getUnique_buyer();
	          
					return new Order_reciever().query_in(broom);
				
	    }

	    public void setItemlist(List<RecipetDAO> itemlist) {
	        this.itemlist = itemlist;
	    }
	    
	   
	    
	    
	    
	    public void setImagesender(StreamedContent Imagesender) {
	        this.Imagesender = Imagesender;
	    }
	     public StreamedContent getImagesender() throws IOException, SQLException {
	  
	        FacesContext context = FacesContext.getCurrentInstance();

			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			} else {

				String ids=context.getExternalContext().getRequestParameterMap()
	                                                                                 .get("sender");
	                              
                   byte [] imges= new Order_reciever().getProductImage(ids);

                   return new DefaultStreamedContent(new ByteArrayInputStream(imges));


			}

	    }

	    
	    
		   @SuppressWarnings("unchecked")
		public List<RecipetDAO> getItemlist_sum() throws IOException {
			 
			    d=new Singleton().getUnique_buyer();
			    
		    	return new Order_reciever().total_Sum(d);
		     	}


			public void setItemlist_sum(List<RecipetDAO> itemlist_sum) {
				this.itemlist_sum = itemlist_sum;
			}
	    
	     
			
			public String user_details_Submit() {
				
			
				outputing="Order Sent";
				
				new Singleton().setUnique_buyer("B");
			
			return "/Payment_slip.xhtml";}
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
