package EJBS_CONTROL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CONFIGURE.Connec_Config;

public class WebAPI_CONSQ_Current_User_block  {
	String l;
	int sd;
	Connection cons;
	public WebAPI_CONSQ_Current_User_block() {
		
	}
	
	
	@SuppressWarnings("rawtypes")
	public List constant_query(String h) throws IOException, SQLException  {
		
		List<Current_GraphicImageUser> line_up = new ArrayList<>();
		Current_GraphicImageUser pack= new Current_GraphicImageUser();
		Connection con;
		Connec_Config f=new Connec_Config();
		con=f.getConnection();
		try {
		PreparedStatement ps=con.prepareStatement("select * from  public.dime_stack where email like '%"+h+"%'");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			 
			  
			   String hp1=rs.getString("dip");
			 	 int sw1=Integer.parseInt(hp1);
				   NumberFormat nf1=NumberFormat.getNumberInstance();
				   nf1.setMinimumFractionDigits(1);
		    	String	 zx1=   nf1.format(sw1);
		         pack.setDime(zx1+" $");
			 
			 
			
		    	String hp2=rs.getString("lip");
	    	 int sw2=Integer.parseInt(hp2);
		   NumberFormat nf2=NumberFormat.getNumberInstance();
		   nf2.setMinimumFractionDigits(1);
    	String	 zx2=   nf2.format(sw2);
//        	 StringBuilder builder2= new StringBuilder(zx2);
//    	     String	 pzx2=new String(builder2.delete(0, 1).insert(0, "0"));
		        	pack.setRef(zx2+" Ref %");
			
			 
			
		        	String hp3=rs.getString("sip");
			    	 int sw3=Integer.parseInt(hp3);
				   NumberFormat nf3=NumberFormat.getNumberInstance();
				   nf3.setMinimumFractionDigits(1);
	        	String	 zx3=   nf3.format(sw3);
//	        	 StringBuilder builder3= new StringBuilder(zx3);
//	    	     String	 pzx3=new String(builder3.delete(0, 1).insert(0, "0"));
		           pack.setGas(zx3+" Gas");
			    	 
		
		}
		line_up.add(pack);
		
		}catch(Exception ex) {System.out.println("00"+ex);
		}finally {
     	   con.close();
        }

		
	
		
	return line_up;}
	
	
	
	public List groupfinders(String k) throws IOException, SQLException {
		
		
		Connec_Config vb= new Connec_Config();
      List<Main_Controller> packing= new  ArrayList<Main_Controller>();
   
      Main_Controller semi_hold= new Main_Controller();
   
		try {
		cons=vb.getConnection();
		PreparedStatement ps=cons.prepareStatement("select * from public.group_stake_odd  where ids="+k);
		ResultSet res=ps.executeQuery();
		while (res.next()) {
		
			semi_hold.setGroup_name(res.getString("nameid"));
			semi_hold.setID(res.getString("stack_id"));
			
		}
		packing.add(semi_hold);
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
     	   cons.close();
        }
		
		return packing;
		
	}

	
	
	public byte[] getGroupImages_info(String c) throws SQLException {
	
	    Connec_Config connect = new Connec_Config();
	 
	 Connection connection=null;
	 byte[] productImage = null;
	 
	 
	connection = connect.getConnection();

	 try {
	PreparedStatement ps = connection
	.prepareStatement("select * from public.group_stake_odd  where ids="+c);
	       ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	                
	                productImage = rs.getBytes("img");
	                
	            } rs.close();
	               }finally {
	            	   connection.close();
	               }

       return productImage;}
	
	
	
	 String b; int y;
		protected int SIZE_UP() {
			Connection cons;
			cons=new Connec_Config().getConnection();
			try {
				PreparedStatement ps=cons.prepareStatement("select max(id) as v from users_sales_products");
				  ResultSet rs=ps.executeQuery();
				  while (rs.next()) {
				y=Integer.parseInt(b=rs.getString("v"));
				
				 
				}
			} catch (SQLException e) {
				
				System.out.println(e);
			}
			finally {
				try {
					cons.close();
				} catch (SQLException e) {
				
					System.out.println(e);
				}
			}
		return y;}
		

		
	
	
	@SuppressWarnings("rawtypes")
	public List Pass_all_update() throws SQLException {
	  
		//System.out.println(SIZE_UP()+"Main");
		
		List<Main_Controller>  main_con= new ArrayList<Main_Controller>();
		Connection cons;
		Connec_Config conf= new Connec_Config();
		cons=conf.getConnection();
		Main_Controller cont;
		try {
			PreparedStatement ps=cons.prepareStatement("select * from users_sales_products where id<="+SIZE_UP()+" and id>="+new Random().nextInt(SIZE_UP())+"");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				cont= new Main_Controller();
				cont.setScroll_id(rs.getString("id"));
				cont.setStore_owner(rs.getString("store_owner_id"));
				cont.setAddress(rs.getString("address"));
				main_con.add(cont);
			}
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			cons.close();
		}
		
	return main_con;}
	
	
	public byte [] scroll_Image(String v) throws SQLException {
		int c=Integer.parseInt(v);
		Connection cons;
		Connec_Config conf= new Connec_Config();
		cons=conf.getConnection();
		byte [] xvz=null;
	
		try {
			PreparedStatement ps=cons.prepareStatement("select * from users_sales_products  where id="+c);
			ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			xvz=rs.getBytes("img");
		 }
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				cons.close();
			}
		return xvz;}

	
	
	
	
	             
					
					
					
					
					 
					
					
			
	
	
	
	 public byte [] getScrollAnchorimg(String h) throws SQLException {
		
		 
	
			Connection cons;
			Connec_Config conf= new Connec_Config();
			cons=conf.getConnection();
			byte [] img=null;
		
			try {
				PreparedStatement ps=cons.prepareStatement("select * from public.useraccounts  where emailid  like '%"+h+"%'");
				ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 img=rs.getBytes("dimage");
			 }
				}catch (Exception e) {
					System.out.println(e);
				}finally {
					cons.close();
				}
		
	 
		 return	 img;}

	
	@SuppressWarnings("rawtypes")
	public List search_update(String h) throws SQLException {
   
		List<Main_Controller>  main_con= new ArrayList<Main_Controller>();
		Connection cons;
		Connec_Config conf= new Connec_Config();
		cons=conf.getConnection();
		Main_Controller cont;
		try {
			PreparedStatement ps=cons.prepareStatement("select * from public.useraccounts  where  address like '%"+h+"%'");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				cont= new Main_Controller();
				cont.setScroll_id(rs.getString("sub_address"));
				main_con.add(cont);
			}
		
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			cons.close();
		}
		
	return main_con;}
	
	byte [] serach_query_img(String h) throws SQLException {
		Connection cons;
		Connec_Config conf= new Connec_Config();
		cons=conf.getConnection();
		byte [] xvz=null;
	
		try {
			PreparedStatement ps=cons.prepareStatement("select * from public.useraccounts where address  like '%"+h+"%'");
			ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			xvz=rs.getBytes("dimage");
		 }
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				cons.close();
			}
		return xvz;}
	
	
	
	public int Compare(int y) {
	  
		if(y>0) {
			System.out.println("higgggggggggggh "+y);
			return y;
		
		}else if(y<=0) {
		
			System.out.println("looooooooooooooow "+y);
			y=0;
			return y;
			
		}
	
	return y;}
}
	


