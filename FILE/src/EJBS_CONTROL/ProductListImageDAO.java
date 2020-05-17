package EJBS_CONTROL;

import CONFIGURE.Connec_Config;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductListImageDAO {

	public byte[] etProductImage(String productId) throws SQLException   /////////////////
	 {
int pos=Integer.parseInt(productId);
    Connec_Config connect = new Connec_Config();
 
 Connection connection=null;
 byte[] productImage = null;
 
 
connection = connect.getConnection();

PreparedStatement ps = connection
.prepareStatement("select * from users_sales_products  where id =?");
ps.setInt(1, pos);
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                
                productImage = rs.getBytes("img");
                
            }     }
        finally {
      	  try {
      		  connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}





 
   return productImage;}


/////////////////



public List getProductDetails(String h) throws IOException, SQLException {/////////////
List<Main_Controller> productList = new ArrayList<>();


Connec_Config connect = new Connec_Config();
 
 Connection connection=null;
 
try {
connection = connect.getConnection();

PreparedStatement ps = connection
.prepareStatement("select * from users_sales_products where address like '%"+h+"%' order by id desc");



try (ResultSet rs = ps.executeQuery()) {
	Main_Controller controller;
 
 while (rs.next()) {
     
     controller = new Main_Controller();
     
     String productId = rs.getString("id");
     
     controller.setProductId(productId.trim());
     controller.setProductName(rs.getString("price"));
     productList.add(controller);
 }
}


}catch(SQLException ex){System.out.println(ex);}

finally {
	  try {
		  connection.close();
	} catch (SQLException e) {
		System.out.println(e);
	}
}


return productList;
}



					public byte[] walletProductImage(String productId) throws SQLException 
					{
					int pos=Integer.parseInt(productId);
					Connec_Config connect = new Connec_Config();
					Connection connection=null;
					byte[] productImage = null;
					
				
						
						  connection = connect.getConnection();
		                  PreparedStatement ps = connection
							.prepareStatement("select * from public.group_stake_odd  where ids= ?");
						ps.setInt(1, pos);
							   try (ResultSet rs = ps.executeQuery()) {
							       while(rs.next()){
							           
							           productImage = rs.getBytes("img");
							           
							       }      }
							   finally {
						        	  try {
						        		  connection.close();
									} catch (SQLException e) {
										System.out.println(e);
									}
								}
					

					
					    return productImage;}
					
					
					/////////////////
					
					int y;
					public int maxof_table() throws IOException, SQLException {
						
						List<Main_Controller> productList = new ArrayList<>();
						Connec_Config connect = new Connec_Config();
						Connection co=null;
				
							
				
							
							try {
								co = connect.getConnection();
								
								PreparedStatement ps = co
								.prepareStatement("select max(ids) as v from public.group_stake_odd");
								ResultSet rs=ps.executeQuery();
								while (rs.next()) {
								String 	hy=rs.getString("v");
								y=Integer.parseInt(hy);
									
								}
								
								
							}catch (Exception e) {
							
								System.out.println("one"+e);
							}
				return y;	}

					//////////<>1
					public List walleProductDetails(int y,int r) throws IOException, SQLException {
				
						List<Main_Controller> productList = new ArrayList<>();
						Connec_Config connect = new Connec_Config();
						Connection connection=null;
				
							
				
							
							try {
								connection = connect.getConnection();
								
								PreparedStatement ps = connection
								.prepareStatement("select * from public.group_stake_odd where ids<="+y+" and  ids>"+r);
								
								
								
								try (ResultSet rs = ps.executeQuery()) {
								Main_Controller controller;
								
								while (rs.next()) {
								
								controller = new Main_Controller();
								
								
								controller.setIds(rs.getString("ids"));
								controller.setProductId(rs.getString("nameid"));
								controller.setProductName(rs.getString("stack_id"));
								productList.add(controller);
								}
								}
							
								
								}catch(SQLException ex){System.out.println("two"+ex);}
							 finally {
					        	  try {
					        		  connection.close();
								} catch (SQLException e) {
									System.out.println(e);
								}
							}
				

						
					  	return productList;
					}
					


				
					/////////////////
					@SuppressWarnings("rawtypes")
					public List walleProductDetailsrandom(int k) throws IOException, SQLException {
						System.out.println(k);
						List<QueDAO> productList = new ArrayList<>();
						Connec_Config connect = new Connec_Config();
						Connection connection=null;
				
							
				
							
							try {
								connection = connect.getConnection();
								
								PreparedStatement ps = connection
								.prepareStatement("select * from public.group_stake_odd where  ids="+k);
								
								
								
								try (ResultSet rs = ps.executeQuery()) {
								QueDAO controller;
								
								while (rs.next()) {
								
								controller = new QueDAO();
								
								String productId = rs.getString("ids");
								
								controller.setIds(productId.trim());
								controller.setOdds(rs.getString("stack_id"));
								productList.add(controller);
								}
								}
								connection.close();
								
								}catch(SQLException ex){System.out.println(ex);
								
								 } finally {
						        	  try {
						        		  connection.close();
									} catch (SQLException e) {
										System.out.println(e);
									}
								}
					

						
					  	return productList;
					}
					
					
					
	                  //1
					
					public byte[] SearchwalletProductImage(String d) throws SQLException 
					{

					Connec_Config connect = new Connec_Config();
					Connection connection=null;
					byte[] productImage = null;
					
					connection = connect.getConnection();
		                  PreparedStatement ps = connection
							.prepareStatement("select * from public.group_stake_odd  where address like '%"+d+"%'");
							   try (ResultSet rs = ps.executeQuery()) {
							       while(rs.next()){
							           
							           productImage = rs.getBytes("img");
							           
							       }     }
							   finally {
						        	  try {
						        		  connection.close();
									} catch (SQLException e) {
										System.out.println("ZA"+e);
									}
								}
					

					
					    return productImage;}
					
					
					
					
					
					
					public List  SearchwalleProductDetails(String j) throws IOException, SQLException {
						
						List<Main_Controller> productList = new ArrayList<>();
						Connec_Config connect = new Connec_Config();
						Connection connection=null;
				
						try {
								connection = connect.getConnection();								
								PreparedStatement ps = connection
								.prepareStatement("select * from public.group_stake_odd where  address like'%"+j+"%'");
								
								
								
								try (ResultSet rs = ps.executeQuery()) {
								Main_Controller controller;
								
								while (rs.next()) {
								
								controller = new Main_Controller();
								
								controller.setEds(rs.getString("ids"));
								controller.setProductId(rs.getString("nameid").trim());
								controller.setProductName(rs.getString("stack_id").trim());
								productList.add(controller);
								}
								}
								
								
								}catch(SQLException ex){System.out.println("Z"+ex);
								  } finally {
						        	  try {
						        		  connection.close();
									} catch (SQLException e) {
										System.out.println(e);
									}
								}
					

						
					  	return productList;
					}
					
					
					
					String same; int ys;
					protected int stake_drop_check(String j) {
						int y=Integer.parseInt(j);
						Connection cons;
						cons=new Connec_Config().getConnection();
						
						try {
						PreparedStatement ps=cons.prepareStatement("select * from public.group_stake_odd where ids="+y);
						ResultSet rs=ps.executeQuery();
						while (rs.next()) {
							
							same=rs.getString("address");
							
						}
						
						if(new Singleton().getAddressing().equals(same)) {
							STAKE_DROP(y);
							ys=1;
							}else {
							
								System.out.println("NO PER");
								
							ys=2;
							}
							}catch (Exception e) {
							
							System.out.println(e);
						}
						
						finally {
							try {
								cons.close();
						
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
						return ys;
					}
					
					
				

					private void STAKE_DROP(int u) {
						System.out.println("DROP STAKE");
						Connection coms;
						coms=new Connec_Config().getConnection();
						try {
						
							PreparedStatement ps=coms.prepareStatement("delete from  public.group_stake_odd where ids="+u);
						   ps.executeUpdate();
						 
						} catch (SQLException e) {
							System.out.println(e);
						
						}finally {
							
							try {
								coms.close();
							
							} catch (SQLException e) {
								
								System.out.println(e);
							}
						}
						
					}
					
					
					
			
					
}





