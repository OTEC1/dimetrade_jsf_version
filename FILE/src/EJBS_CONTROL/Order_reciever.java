package EJBS_CONTROL;
import CONFIGURE.Connec_Config;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Order_reciever {

	

public Order_reciever(){
        
    }
   public byte[] getProductImage(String productId) throws IOException,
			SQLException {
	int pos=Integer.parseInt(productId);
            Connec_Config connect = new Connec_Config();
         
         Connection connection=null;
         byte[] productImage = null;
         
         
   connection = connect.getConnection();
  
   PreparedStatement ps = connection
     .prepareStatement("select * from user_order where id = ?");
   ps.setInt(1, pos);
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){
                        
                        productImage = rs.getBytes("img");
                        
                    }    }
                finally {
		        	  try {
		        		  connection.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
	

		
         
           return productImage;}
    

/////////////////


	
public List  query_in(String io)  {
 List<RecipetDAO> productList = new ArrayList<>();


 Connec_Config connect = new Connec_Config();
         
         Connection connection=null;
         
 try {
   connection = connect.getConnection();
  
   PreparedStatement ps = connection
     .prepareStatement("select * from user_order  where person like '%"+io+"%'");

   

     try (ResultSet rs = ps.executeQuery()) {
    	 RecipetDAO controller;
         
         while (rs.next()) {
             
             controller = new RecipetDAO();
             
             String productId = rs.getString("id");
            controller.setId(productId.trim());
            //set to list getter and setter
           controller.setPrice(rs.getString("price"));
           controller.setQuantity(rs.getString("Quantity"));
             controller.setTotal(rs.getString("Total"));
   
             
             
             
             productList.add(controller);
         }
     }
    
     }catch(SQLException ex){System.out.println(ex);
     
        }        
		            finally {
			  try {
				  connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}


 
 
  return productList;
}


@SuppressWarnings("rawtypes")
public List total_Sum(String person) {
	List<RecipetDAO> packings= new ArrayList<RecipetDAO>();
	 Connection cons;
	 CONFIGURE.Connec_Config bv= new CONFIGURE.Connec_Config();
	 cons=bv.getConnection();
	 RecipetDAO b= new RecipetDAO();
	 try {
		 PreparedStatement ps=cons.prepareStatement("select sum(total)  as v from public.user_order  where person like'"+person+"'");
		 ResultSet rs=ps.executeQuery();
		 
		 while(rs.next()) {
			 b.setCs(rs.getString("v"));
			 packings.add(b);
		 }
		 }catch(Exception ex) {System.out.println(ex);
		 
		 }        
			finally {
				  try {
					  cons.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}


	 
	 
return packings;}
}
