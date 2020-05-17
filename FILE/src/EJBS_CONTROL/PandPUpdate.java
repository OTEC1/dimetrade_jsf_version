package EJBS_CONTROL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.UploadedFile;

import CONFIGURE.Connec_Config;

public class PandPUpdate {

	
	
	
	
	

    public byte[] user_profile_Image(String g) {

		    	byte [] gt=null;
		    	Connection con=null;
		    	Connec_Config cons= new Connec_Config();
		    	con=cons.getConnection();
		    	
		    	  try {
						PreparedStatement ps= con.prepareStatement("select * from  public.useraccounts where emailid like '%"+g+"%'");
					    ResultSet rs=ps.executeQuery();
					    while (rs.next()) {
						
							gt=rs.getBytes(9);
						}
				    
				    } catch (SQLException e) {
					System.out.println(e);
					} finally {
			        	  try {
			        		  con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
		

    
    
    return gt;}
    
    
    public List user_profile_details(String h) {
		    	List<User_updater> pack= new ArrayList<User_updater>();
		    	Connection con=null;
		    	Connec_Config cons= new Connec_Config();
		    	con=cons.getConnection();
		    	User_updater update=null;
		    try {
				PreparedStatement ps= con.prepareStatement("select * from public.useraccounts where emailid like '%"+h+"%'");
			    ResultSet rs=ps.executeQuery();
			    while (rs.next()) {
				 update= new User_updater();
				
				 update.setIds(rs.getString(1));
				 update.setNameid(rs.getString(2));
				 update.setEmailid(rs.getString(3));					
				 update.setAccountid(rs.getString(4));
				 update.setPhoneid(rs.getString(5));
				 update.setAddress(rs.getString(6));
					pack.add(update);
				}
		    
		    } catch (SQLException e) {
		    
		    	System.out.println(e);
		
		    }finally {
				try {
					con.close();
				} catch (SQLException e) {
					
					System.out.println(e);
					
				}
			}
		    	
    	return pack; }
    
    
    
    
    
    public byte[] user_post_Image(String g) {
    
    	int y=Integer.parseInt(g);
    	byte [] gt=null;
    	Connection con=null;
    	Connec_Config cons= new Connec_Config();
    	con=cons.getConnection();
    	  try {
				PreparedStatement ps= con.prepareStatement("select * from  public.users_sales_products where id=?");
				ps.setInt(1, y);
			    ResultSet rs=ps.executeQuery();
			    while (rs.next()) {
				
			    	gt=rs.getBytes("img");
					
				}
		    
		    } catch (SQLException e) {
			System.out.println(e);
			} finally {
	        	  try {
	        		  con.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
			}


    
    return gt;}
    
    
    public List user_post_details(String h) {
    	List<User_updater> pack= new ArrayList<User_updater>();
    	Connection con=null;
    	Connec_Config cons= new Connec_Config();
    	con=cons.getConnection();
    	User_updater update=null;
    try {
		PreparedStatement ps= con.prepareStatement("select * from  public.users_sales_products where store_owner_id like '%"+h+"%' order by id desc");
	    ResultSet rs=ps.executeQuery();
	    while (rs.next()) {
		 update= new User_updater();
		
		 update.setId(rs.getString(1));
		 update.setStore_owner_id(rs.getString(2));					
		 update.setPrice(rs.getString(3));
			pack.add(update);
		}
    
    } catch (SQLException e) {
    
    	System.out.println(e);

    }finally {
		try {
			con.close();
		} catch (SQLException e) {
			
			System.out.println(e);
			
		}
	}
    	
return pack; }
    
    
    
    
    
    public void UpdatePost(String ids,String nameid, String emailid, String accountid, String phoneid, String address,  byte [] uploadedFile, String string) throws SQLException {
    	int g=Integer.parseInt(ids);   int f=Integer.parseInt(phoneid);
   
    	
    		Connec_Config config= new Connec_Config();
        	Connection cons;
        	cons=config.getConnection();
        	try {
    			
        		PreparedStatement ps=cons.prepareStatement("update public.useraccounts set id=?, nameid=?, emailid=?, accountid=?,  phoneid=?,   address=?,  dimage=?  where  emailid like '%"+string+"%'");                                                      
        		ps.setInt(1, g);
        		ps.setString(2, nameid);
    		    ps.setString(3, emailid);
    		    ps.setString(4, accountid);
    		    ps.setInt(5, f);
    		    ps.setString(6, address);
        		ps.setBytes(7, uploadedFile);
        		dime_stack(string,emailid);
        		ps.execute();
        		System.out.println("successfully Updated");
        	} catch (Exception e) {
    		
    			System.out.println(e);
    		}finally {
    			cons.close();
    		}
    		
    	
    }
    
    
    



	public void UpdatePosts(String ids,String nameid, String emailid, String accountid, String phoneid, String address,  String string) throws SQLException {
    	int g=Integer.parseInt(ids);   int f=Integer.parseInt(phoneid);
   
    	
    		Connec_Config config= new Connec_Config();
        	Connection cons;
        	cons=config.getConnection();
        	try {
    			
        		PreparedStatement ps=cons.prepareStatement("update public.useraccounts set id=?, nameid=?, emailid=?, accountid=?,  phoneid=?,   address=? where  emailid like '%"+string+"%'");                                                      
        		ps.setInt(1, g);
        		ps.setString(2, nameid);
    		    ps.setString(3, emailid);
    		    ps.setString(4, accountid);
    		    ps.setInt(5, f);
    		    ps.setString(6, address);
    		    dime_stack(string,emailid);
        		ps.execute();
        		System.out.println("successfully Updated");
        	} catch (Exception e) {
    		
    			System.out.println(e);
    		}finally {
    			cons.close();
    		}
    		
    	
    }
	
	
	
    private void dime_stack(String string, String h) {

		Connec_Config config= new Connec_Config();
    	Connection cons;
    	cons=config.getConnection();
    	try {
    		PreparedStatement ps=cons.prepareStatement("update public.dime_stack set  email=? where  id like '%"+string+"%'");                                                      
    		ps.setString(1, h);
    	
    	}catch (Exception e) {
			System.out.println(e);
		} finally {
      	  try {
    		  cons.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}


		
	}

}
