package EJBS_CONTROL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.UploadedFile;

import CONFIGURE.Connec_Config;

public class user_file_sql_uploader {

	
	
	protected void Pass_on(byte [] h,String em, String price,String addressing) {
		Connec_Config config= new Connec_Config();
		Connection cons=null;
		cons=config.getConnection();
		
		
		
		try {
			
			PreparedStatement ps=cons.prepareStatement("insert into  users_sales_products(price,store_owner_id,address,img) values (?,?,?,?)");
			ps.setString(1, price);
			ps.setString(2, em);
			ps.setString(3, addressing);
			ps.setBytes(4, h);
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
		
	
	}
	
	
	public List get_intro_query(String k){
				List<user_file_upload> pack= new ArrayList<>();
				Connec_Config cons= new Connec_Config();
				Connection co=null;
			
				
				try {
					co=cons.getConnection();
				PreparedStatement ps=co.prepareStatement("select * from  UIIDSQL where mail like '%"+k+"%' order by id desc");
			  try(ResultSet rs=ps.executeQuery()){
				  user_file_upload  file ;
			   while (rs.next()) {
				     file = new user_file_upload();
			        
			         file.setOrders(rs.getString("ids"));
			        
			        pack.add(file);
			   }
				}
				 co.close();
				}catch (Exception e) {
					System.out.println(e);
				}finally {
		        	  try {
		        		  co.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
				}
			
	
	
	return pack;}
	
	
	  public List  Unique_email_orders(String g) {
		  List<user_file_upload> pack= new ArrayList<>();
	
		  Connec_Config fs= new Connec_Config();
		  Connection con;
		  con=fs.getConnection();
		  try {
			  
			  PreparedStatement ps=con.prepareStatement("select * from  public.user_order where person like '%"+g+"%' order by id desc");
		     ResultSet rs=ps.executeQuery();
		     while (rs.next()) {
				   
		    	 user_file_upload   carry = new user_file_upload();
		    	 carry.setId(rs.getString("ID"));
		    	 carry.setPricess(rs.getString("price"));
		    	 carry.setQuantity(rs.getString("quantity"));
		    	 carry.setTotal(rs.getString("total"));
		    	 carry.setPerson(rs.getString("person"));
		    	 carry.setWall_ownerid(rs.getString("wall_ownerid"));
		    	 pack.add(carry);
		    	
			}
		  
		  }catch (Exception e) {
		System.out.println(e);
		}finally {
			 try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	  
	  
	  
	  
	  return pack;}
	
	
	
	  
	  public byte []  Unique_email_ordersimg(String g) {
		  int f=Integer.parseInt(g);
		 byte [] pack= null;
		  Connec_Config fs= new Connec_Config();
		  Connection con=null;
		
				  try {
					  con=fs.getConnection();
					  PreparedStatement ps=con.prepareStatement("select * from  public.user_order where id =?");
			         ps.setInt(1, f);
			         ResultSet rs=ps.executeQuery();
		             while (rs.next()) {
					
		            	 pack=rs.getBytes("img");
						
					}		  
				  
				  } catch (Exception e) {
			
                               System.out.println(e);
                    	}finally {
				   
                    		try {
						con.close();
					} catch (SQLException e) {
						System.out.println(e);
					}
                    		}
	  
	  
	  
	  
	             return pack;}
	
	
	  
	  
			  protected long ODO() {
				  long asa=System.currentTimeMillis();
				  long bas=System.nanoTime();
				  
				  long sa=asa*bas*1000;
			
				  return sa; }
			  
			  protected long ODO2() {
				  long asa=System.currentTimeMillis();
				  long bas=System.nanoTime();
				  
				  long sa=asa*bas*500;
			
				  return sa; }
			    
			  String h,uh;
			  public String Create_G(String d,String gname, byte [] uploaded) {
				
				 Connec_Config config= new Connec_Config();
				 Connection cons;
				 cons=config.getConnection();
				 try {
			       PreparedStatement ps= cons.prepareStatement("insert into  public.Group_making(keys,gname,mail,img,members,address)  values(?,?,?,?,?,?)");
			       ps.setString(1, h=String.valueOf(ODO()).replace("-","").concat(uh=String.valueOf(ODO2()).replace("-", "")));
			       ps.setString(2, gname);
			       ps.setString(3, new Singleton().getEmail());
			       ps.setBytes(4, uploaded);
			       ps.setString(5, "0");
			       ps.setString(6, d);
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
			  
			return h;  }
			
			
			
		
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
