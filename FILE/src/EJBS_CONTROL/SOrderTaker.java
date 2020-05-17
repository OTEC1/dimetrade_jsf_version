package EJBS_CONTROL;

import CONFIGURE.Connec_Config;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class SOrderTaker  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates a new instance of OrderTaker
     */
    
	     
           private  String reciever,pot;
		   private FirebaseDatabase firebasedatabase;
		   private String plate, lob,fix,csa;
		   int plus;
		   static String flows;
		
		   
	    public int getPlus() {
			return plus;
		}

		public void setPlus(int plus) {
			this.plus = plus;
		}

		public String getFix() {
	        return fix;
	    }

	    public void setFix(String fix) {
	        this.fix = fix;
	    }
	     
	     byte[] productImage = null;
	     public boolean pharse1=true,pharse2;

	       public void   OrderTaker() throws IOException{
	    
	              display();
	        
	         
	      }
	       
	    


	public String plus1() {
	
	plus++;
	
System.out.println(plus);
			
	return null;}

	
	public String minus1() {
		if(plus<0) {
			plus=1;
		}
		plus--;

		System.out.println(plus);		
		return null;}
	
	
	      public void GAMES() throws IOException{
	           Connec_Config config= new  Connec_Config();
	           Connection con=null;
	              FacesContext fc=FacesContext.getCurrentInstance();
	              Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
	              reciever=params.get("ridea");
	               
	              FacesContext fo=FacesContext.getCurrentInstance();
	              Map<String,String> param=fo.getExternalContext().getRequestParameterMap();
	               lob=param.get("rides");
	        
	               if(plus==0){
	                   System.out.println("empty");
	               }else if(plus>0){
	 
	            	   if(new Singleton().getUnique_buyer().equals("B")) {
	 
	                   int sd=q(956789097);
	              long gfs=System.currentTimeMillis();
	          
	              flows="W"+sd+gfs+"T".trim();
	            new Singleton().setUnique_buyer(flows);
	                
	                 ORDER_LIST(new  Singleton().getUnique_buyer());
	                 
	            	   }
	                       
	            	   System.out.println("web id "+flows);
	              
	            	 
	            
	            
	            
	            
					//firebase
					//MultiplyDAO ms=new MultiplyDAO();
					//ms.op(plus, reciever);
					//ms.setPrice(reciever);
					//ms.setQuantity(csa=String.valueOf(plus));
					// ms.setTotal(ms.carry);
					// ms.setPerson(pot);
			       // ms.setStoreowner("");
	              // System.out.println("firebase ::"+ms.carry);
	              //   System.out.println("firebase ::"+reciever);
	              //     PushALL_INTO_FIREBASE(ms);
	               
	          
	 
	       try{
	        con=config.getConnection();
	        
	        PreparedStatement ps=con.prepareStatement("select * from public.users_sales_products where id="+lob);
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next()){
	         productImage=   rs.getBytes("img");
	         System.out.println("ORDER_ID    "+lob);
	        }
	        
	           }catch(SQLException ex){System.out.println(ex);}
	             
	       
	       finally {
	        	  try {
	        		  con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
	                 
	       
	       
	          
	            //postgres
	       
	  
       		plate=new Singleton().getStore_owner();
       	
       
       	
	       MultiplyDAO ms=new MultiplyDAO();
	             ms.op(plus, reciever);
	              ms.setPrice(reciever);
	              ms.setQuantity(csa=String.valueOf(plus));
	              ms.setTotal(ms.carry);
	              ms.setPerson(new Singleton().getUnique_buyer());
	              ms.setStoreowner(plate);
	               ms.setItem(productImage);
	               System.out.println("postgers ::"+ms.carry);
	                 System.out.println("postgers ::"+reciever);
	                 System.out.println("Plate ::"+plate);
	                   PushALL_INTO_POSTGRES(ms.price,ms.Quantity,ms.total,ms.person,ms.storeowner,ms.item);
	               
	               
	              
	           
	       }}
	      
	     
	      
	

		public boolean isPharse1() {
	        return pharse1;
	    }

	    public void setPharse1(boolean pharse1) {
	        this.pharse1 = pharse1;
	    }

	    public boolean isPharse2() {
	        return pharse2;
	    }

	    public void setPharse2(boolean pharse2) {
	        this.pharse2 = pharse2;
	    }

//	  private void PushALL_INTO_FIREBASE(MultiplyDAO ms){
//	    
//	        if(ms!=null){
//	                  Path path=Paths.get("C:\\Users\\Public\\Downloads\\YuVfEeDCxWrHnkJvFdeEWEsFXsESsDXXcwWxXsEr.txt");
//	            try {
//	                Scanner sc= new Scanner(path);
//	                while(sc.hasNextLine()){
//	                     value=sc.nextLine();
//	                    
//	                     if(value.contains("One")){
//	            initFirebaseCall();
//	            
//	             FileWriter fw= new FileWriter(fi);
//	                fw.write("Two");
//	                fw.close();
//	                     }else if(value.contains("Two")){
//	            
//	                     }
//	                }
//	                sc.close();
//	            } catch (IOException ex) {
//	             System.out.println(ex);
//	            }
//	            
//	            DatabaseReference databaseReference = firebasedatabase.getReference("/");
//	            
//	            /* Get existing child or  created new child with name. */
//	            DatabaseReference crf = databaseReference.child("ORDERS");
//	            crf.push().setValue(ms);
//	            
//	        }
//	    } 
//
//	   private void initFirebaseCall() {
//	    
//	        try{
//	            FirebaseOptions firebaseoptios= new FirebaseOptions.Builder()
//	                    .setDatabaseUrl("https://wizard-85ef3.firebaseio.com")
//	                    .setServiceAccount(new FileInputStream(new File("C:\\Users\\User\\Desktop\\Firebase01\\wizard-85ef3-56e64629e7ff.json")))
//	                    .build();
//	          
//	      
//	                 FirebaseApp.initializeApp(firebaseoptios);
//	                 firebasedatabase = FirebaseDatabase.getInstance();
//	     
//	        }catch(FileNotFoundException e){System.out.println(e);}  
//	        }
	   
	   
	  public String delete() throws IOException{
	      
	    System.out.println("deleting...");
	 return ""; }

	    public String display() throws IOException{

	  
	   return"Invoice1.xhtml";
	    }
	   
	    




	    private void PushALL_INTO_POSTGRES( String price, String Quantity, String total, String person,String storeowner,byte [] item) {
	        
	        System.out.println(price+"|"+Quantity+"|"+total);
	        Connec_Config config= new  Connec_Config();
	        Connection con=null;
	     
	           try{
	        con=config.getConnection();
	     
	        String map="insert into  public.user_order(price,Quantity,total,person,wall_ownerid,img) values(?,?,?,?,?,?)";
	        PreparedStatement ps= con.prepareStatement(map);
	           
	             ps.setString(1, price);
	               ps.setString(2, Quantity);
	               int xca=Integer.parseInt(total);
	                ps.setInt(3, xca);
	                ps.setString(4, person);
	                ps.setString(5, storeowner);
	                ps.setBytes(6, item);
	                ps.executeUpdate();
	                plus=0;
	             con.close();
	       
	           }catch(Exception ex){System.out.println(ex);}
	           finally {
		        	  try {
		        		  con.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
	        
	    }

	    private int q(int i) {

	return (int)(Math.random()*i);
	    }

	   
	       private void ORDER_LIST(String flows2) {
			
	    	   
	    	
	          Connec_Config cons= new Connec_Config();
	    	  Connection con;
	    	  con=cons.getConnection();
	    	  
	    	  try {
	    	  PreparedStatement ps=con.prepareStatement("insert into UIIDSQL(ids,mail) values(?,?)");
	    	  ps.setString(1, flows2);
	    	  ps.setString(2, new Singleton().getStore_owner());
	    	 ps.execute();
	    	 con.close();
	    	 System.out.println("First id Hashed <>"+new Singleton().getUnique_buyer());
	    	  }catch (Exception e) {
				System.out.println(e);
			}
	    	  finally {
	        	  try {
	        		  con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
				
			}
}
