package EJBS_CONTROL;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



public class MultiplyDAO {

	

	protected String Quantity;
	   protected String price;
	    protected String total;
	     protected String broom,carry,person;
	     protected byte [] item;
	   protected String itmes;
	   protected String storeowner;
	   protected  int k,o,i;
	    protected  long z;
	   
	        public MultiplyDAO() {
	        
	        	
	        }
	    
	    
			    public String getStoreowner() {
				return storeowner;
			}
		
			public void setStoreowner(String storeowner) {
				this.storeowner = storeowner;
			}
		
				public String getItmes() {
			        return itmes;
			    }
		
			    public void setItmes(String itmes) {
			        this.itmes = itmes;
			    }
			  
		
		
			    public byte[] getItem() {
			        return item;
			    }
		
			    public void setItem(byte[] item) {
			        this.item = item;
			    }
			  
			    public String getPerson() {
			        return person;
			    }
		
			    public void setPerson(String person) {
			        this.person = person;
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

	    public String getBroom() {
	        return broom;
	    }

	    public void setBroom(String broom) {
	        this.broom = broom;
	    }
	    
	 
	    protected String  op(int as, String ps){
	       o=Integer.parseInt(ps);
	       z=as*o;
	       carry=String.valueOf(z);
	      return carry;}
	    
}
