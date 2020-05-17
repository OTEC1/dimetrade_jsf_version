package EJBS_CONTROL;
import CONFIGURE.Connec_Config;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CurrentUserImageDAO {

	
	 Connec_Config connect;
	 
	    private static final long serialVersionUID = 1L;
	 
	   
	    public byte[] getProductImage(String address) throws IOException,
				SQLException {
	        
	    
	          connect = new Connec_Config();
	         
	         Connection connection=null;
	         byte[] productImage = null;
	         
	          try {
	   connection = connect.getConnection();
	  
	  PreparedStatement    ps = connection
	     .prepareStatement("select * from  public.useraccounts where address like '%"+address+"%'");
	             try (ResultSet rs = ps.executeQuery()) {
	                 while(rs.next()){
	                
	                	 productImage = rs.getBytes("dimage");
	                 }   }
	     
		
	       }catch(SQLException ex){System.out.println(ex);
	         
	         }finally {
	        	  connection.close();
			}
	          
	          
	          return productImage;}


	    
	    public List getAllCre(String Id) throws IOException, SQLException {
	 List<Current_GraphicImageUser> productList = new ArrayList<>();


	 Connec_Config connect = new Connec_Config();
	         
	         Connection connection=null;
	         
	 try {
	   connection = connect.getConnection();
	  
	   PreparedStatement ps = connection
	     .prepareStatement("select * from public.useraccounts  where address like '%"+Id+"%'");
	 
	   

	    ResultSet rs = ps.executeQuery();
	    Current_GraphicImageUser controlle;

	        while (rs.next()) {

	        controlle = new Current_GraphicImageUser();

	      String name = rs.getString("nameid");

	      controlle.setName(name.trim());
	      
	      String email = rs.getString("emailid");
	       
	      controlle.setEmail(email);
	      
	      
	       String account = rs.getString("accountid");
	       
	      controlle.setAccount_nu(account);
	      
	      
	      String phone = rs.getString("phoneid");
	       
	      controlle.setPhone(phone);
	      
	      String add = rs.getString("address");
	       
	      controlle.setAddress(add);
	      
	      
	      productList.add(controlle);
	         }

	 
	    
	     }catch(SQLException ex){System.out.println(ex);}
	 finally {
   	  connection.close();
	}
	  return productList;
	}

	     
	    public byte[] getProduct(String sub_address) throws IOException,
		SQLException {
    

      connect = new Connec_Config();
     
     Connection connection=null;
     byte[] productImage = null;
     
      try {
connection = connect.getConnection();

PreparedStatement    ps = connection
 .prepareStatement("select * from  public.useraccounts where emailid='"+sub_address+"'");
         try (ResultSet rs = ps.executeQuery()) {
             while(rs.next()){
            
            	 productImage = rs.getBytes("dimage");
             }   }
 
  
   }catch(SQLException ex){System.out.println(ex);
     
     }  
      finally {
    	  connection.close();
	}
      
      return productImage;}
	    
	    
	    
	    
	    
	    
	    
	    
 public byte[] Wallet_user_image(String t) throws IOException,
		SQLException {
    
	    	connect = new Connec_Config();
     
     Connection connection=null;
     byte[] productImage = null;
     
      try {
connection = connect.getConnection();

PreparedStatement    ps = connection
 .prepareStatement("select * from  public.useraccounts where emailid like '%"+t+"%'");
         try (ResultSet rs = ps.executeQuery()) {
             while(rs.next()){
            
            	 productImage = rs.getBytes("dimage");
             }   }
 
  
   }catch(SQLException ex){System.out.println(ex);
     
     }  finally {
   	  connection.close();
	}
      
      
      
      return productImage;}
	    
	    
	   
 public List usermining(String a) throws IOException, SQLException {
	   	 List<Current_GraphicImageUser> productList = new ArrayList<>();


	   	 Connec_Config connect = new Connec_Config();
	   	         
	   	         Connection connection=null;
	   	         
	   	 try {
	   	   connection = connect.getConnection();
	   	  
	   	   PreparedStatement ps = connection
	   	     .prepareStatement("select * from public.useraccounts  where emailid like '%"+a+"%'");
	   	 
	   	   

	   	    ResultSet rs = ps.executeQuery();
	   	    Current_GraphicImageUser controlle;

	   	        while (rs.next()) {

	   	        controlle = new Current_GraphicImageUser();

	   	      String name = rs.getString("nameid");

	   	      controlle.setName(name.trim());
	   	      
	   	      String email = rs.getString("emailid");
	   	       
	   	      controlle.setEmail(email);
	   	      
	   	      
	   	       String account = rs.getString("accountid");
	   	       
	   	      controlle.setAccount_nu(account);
	   	      
	   	      
	   	      String phone = rs.getString("phoneid");
	   	       
	   	      controlle.setPhone(phone);
	   	      
	   	      String add = rs.getString("address");
	   	      
	   	       new Singleton().setAddressing(add);
	   	       
	   	      controlle.setAddress(add);
	   	      
	   	      
	   	      productList.add(controlle);
	   	         }

	   	     
	   	    
	   	     }catch(SQLException ex){System.out.println(ex);}
	   	 
	   	finally {
      	  connection.close();
		}
	   	  return productList;
	   	}
}
