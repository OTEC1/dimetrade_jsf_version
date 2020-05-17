package EJBS_CONTROL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CONFIGURE.Connec_Config;

public class ODD_ST {

	public ODD_ST() {
		
	}

	
					 
						public void name() {
							
							
							Connection cons=null;
							   cons=new Connec_Config().getConnection();
							try {
								
							
							PreparedStatement ps=cons.prepareStatement("select * from public.group_making where mail='"+new Singleton().getEmail()+"'");
							ResultSet rs=ps.executeQuery();
							while (rs.next()) {
							new Singleton().setS2(rs.getString("Keys"));	
							new Singleton().setS3(rs.getString("gname"));
							new Singleton().setU(rs.getBytes("img"));
							}
							
						
							} catch (Exception e) {
						
								System.out.println(e);
							
							}finally {
							
								try {
								cons.close();
							
								}catch (Exception e) {
									System.out.println(e);
								}
							}
							
							
							
							
						}
						
						
						
						
						
						
	
					           boolean sd;
								public boolean Check_if_group_exist(String j) {
								
									Connection cons;
									cons=new Connec_Config().getConnection();
									
									try {
									PreparedStatement ps=cons.prepareStatement("select * from  public.group_making where mail='"+j+"'");
									 ResultSet rs=ps.executeQuery();
									 while (rs.next()) {
								
										 String k=(rs.getString("mail"));	
										
									 if(k.trim().length()>0) {
									
												System.out.println("1");
								    
										 
									    	 sd= true;
										 
									 }else {
										 sd=false;
								
									 } }
								
									}catch (Exception e) {
										System.out.println(e);
								
									}finally {
										try {
											cons.close();
										} catch (SQLException e) {
											
											System.out.println(e);
										}
									}
									System.out.println("2");
							return 	sd ;
								}
				
				
								
								
								
								
				
	
					  protected String ADDRESS() {
						  String as="";
						  Connection cons;
						cons=new Connec_Config().getConnection();
						try {
							PreparedStatement ps=cons.prepareStatement("  select * from public.useraccounts where emailid='"+new Singleton().getEmail()+"'");
							ResultSet rs=ps.executeQuery();
							while (rs.next()) {
						 as=rs.getString("address");		
							}
						} catch (SQLException e) {
							
							System.out.println(e);
						}
						
						
					return as; }


				
					public void Buckets(String h,String f,String e,String k,byte [] y)  {
						
						 Connection cons=null;
						     
						     cons=new Connec_Config().getConnection();
						     try {
						     PreparedStatement ps=cons.prepareStatement("insert into public.group_stake_odd(address,nameid,group_id,stack_id,img)  values (?,?,?,?,?)");
						    ps.setString(1, f);
						     ps.setString(2, k);
						     ps.setString(3, e);
						     ps.setString(4, h);
						     ps.setBytes(5, y);
						     ps.executeUpdate();
						     
						     }catch (Exception ed) {
								System.out.println(ed);
								}finally {
									try {
										cons.close();
									
									} catch (SQLException e1) {
										
										System.out.println(e);
									
									}
								}
					}
					
	
	
	
					
					
					
					
				String xds;
				int fsq;
				protected void QUERY(String log_in_user) {
					
					
					
					Connection con;
					CONFIGURE.Connec_Config cons= new CONFIGURE.Connec_Config();
					con=cons.getConnection();
					
					try {
					PreparedStatement ps=con.prepareStatement("select * from public.dime_stack where email like '%"+log_in_user+"%'");
				  ResultSet rs=ps.executeQuery();
				  while(rs.next()) {
					   xds=rs.getString("dip");
				  }
				  System.out.println("CURRENT  "+xds);
				   fsq=Integer.parseInt(xds);
				  fsq++;
					 System.out.println(fsq);
					 System.out.println("________________________________");
					 SEND_IN(fsq);
					
					}catch (Exception e) {
						System.out.println(e);
					}finally {
						try {
							con.close();
							System.out.println("Done ALL !!! "+log_in_user);
						} catch (SQLException e) {
						System.out.println(e);
						} finally {
				        	  try {
				        		  con.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
					}
					}
	
					
				
				
				
				
				
				
					protected void SEND_IN(int y) {
						
						 Connection cons;
						cons= new CONFIGURE.Connec_Config().getConnection();
						
						PreparedStatement ps;
						try {
							ps = cons.prepareStatement("update  public.dime_stack  set dip= '"+y+"' where email  like '%"+new Singleton().getEmail()+"'");
					
							ps.execute();
						} catch (SQLException e) {
							
							System.out.println(e);
						
						} finally {
				       	  try {
				       		  cons.close();
							} catch (SQLException e) {
								System.out.println(e);
							}
						}
					}
					
					
					
					
	
					int top;
					public int   bit_check()  {
						
				 		
				 		
				 		Connection con;
						  con= new Connec_Config().getConnection();
						PreparedStatement ps;
						try {
							ps = con.prepareStatement("select * from  public.dime_stack where email like'"+new Singleton().getEmail()+"'");
					
					   ResultSet rs=ps.executeQuery();
					   while(rs.next()) {
				     	String	   mp=rs.getString("bits");
				     	 top=Integer.parseInt(mp);
				     	 
				     	 System.out.println("m before increments"+top);
				     	 
					   top++;
					   Mplus(top);
						  
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
						
						// HELPER();
				return 0;	}
					

					
					protected void Mplus(int m2) {
						
						 
							
						  System.out.println(new Singleton().getEmail());
					    Connection con;
						CONFIGURE.Connec_Config cons= new CONFIGURE.Connec_Config();
						con=cons.getConnection();
						try {
						PreparedStatement ps=con.prepareStatement("update public.dime_stack  set bits ='"+m2+"'  where email like '%"+new Singleton().getEmail()+"%'");	
						ps.executeUpdate();
						   System.out.println("m after increments"+top);
						   new Singleton().setM(top);
						   new Sub_controller().HELPER();
			
					
						}
						catch (Exception e) { System.out.println(e);
						}finally {
				    	  try {
				  		  con.close();
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
						 }
					
					
	
	
	
	
	
	
				//Member's Gather
				public byte [] getGrouplatestimg(String p) {
					int t=Integer.parseInt(p);
					
					byte [] img=null;						
				
					
					return img;
					}
			
				
				
			    	//Member's Gather
			     	@SuppressWarnings("rawtypes")
					public List  getGrouplatestodd(String k) {
				
			     		List<Main_Controller> main= new ArrayList<Main_Controller>();
				
				
				
			     	return main;}
			     	
			     	
			     	
			     	
			     	
			     	
			     	
			     	
					//friends Request 
					public byte [] Request_img(String p) {
						int t=Integer.parseInt(p);
						
						byte [] img=null;						
					
						
						return img;
						}
					
			     	
			     	//friends Request 
			     	@SuppressWarnings("rawtypes")
					public List  Request(String k) {
						List<Sub_controller> pack= new ArrayList<Sub_controller>();
						
					
			     	
						return pack;}
			     	
			     	
			     	
			     	
					//groups_created_gather_img
					public byte [] groups_created_gather_img(String p) {
						int t=Integer.parseInt(p);
						
						byte [] img=null;						
					
						
						return img;
						}
			     	
			     	
					//groups_created_gather_img
			    	@SuppressWarnings("rawtypes")
					public List  groups_created_gather(String j) {
						List<Sub_controller> pack= new ArrayList<Sub_controller>();
						
					
			     	
					return pack;}
			     	
			     	
			     	
			    	
			    	
			    	
			    	
			    	
			    	
			    	//List of group
					public byte [] list_group_img(String p) {
					int y=Integer.parseInt(p);
						
						byte [] img=null;						
						Connection con=new Connec_Config().getConnection();
						try {
						PreparedStatement ps=con.prepareStatement("SELECT * FROM public.group_making where  id="+y);
						ResultSet rs=ps.executeQuery();
						while (rs.next()) {
						
							img=rs.getBytes("img");
							
						}
						
						}catch (Exception e) {
							System.out.println(e);
						}
						return img;
						}
					
			    	
					
					
					
					
					//List of group
			    	@SuppressWarnings("rawtypes")
					public List  list_groupAD(String  l) {
						List<Sub_controller> pack= new ArrayList<Sub_controller>();
					 
						Connection con=new Connec_Config().getConnection();
						try {		
						PreparedStatement ps=con.prepareStatement("SELECT * FROM public.group_making where  address like '%"+l+"%'  order by id desc");
						ResultSet rs=ps.executeQuery();
						while (rs.next()) {
							Sub_controller	suController= new Sub_controller();
							suController.setIds(rs.getString(1));
							suController.setIndiviual_uniqe_group_id(rs.getString(2));
							suController.setGnames(rs.getString(3));
							suController.setMail(rs.getString(4));
							suController.setMember_count(rs.getString(6));
							pack.add(suController);
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
			    	
			    	
			    	
			    	
					    	//List of group
					    	@SuppressWarnings("rawtypes")
							public List  list_group(String  l) {
								List<Sub_controller> pack= new ArrayList<Sub_controller>();
							 
								Connection con=new Connec_Config().getConnection();
								try {			
								PreparedStatement ps=con.prepareStatement("SELECT * FROM public.group_making where  mail like '%"+l+"%'  order by id desc");
								ResultSet rs=ps.executeQuery();
								while (rs.next()) {
									Sub_controller	suController= new Sub_controller();
									suController.setIds(rs.getString(1));
									suController.setIndiviual_uniqe_group_id(rs.getString(2));
									suController.setGnames(rs.getString(3));
									suController.setMail(rs.getString(4));
									suController.setMember_count(rs.getString(6));
									pack.add(suController);
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
					     	
					     	
					    	
					    	
			     	protected byte [] Current_group_img(String k) {
			     		byte [] dsp=null;
			     		Connection cons=null;
			     		cons=new Connec_Config().getConnection();
			     		try {
			     		PreparedStatement ps=cons.prepareStatement("select * FROM public.group_making where id="+k);
			     		ResultSet rs=ps.executeQuery();
			     		while (rs.next()) {
			     			dsp=rs.getBytes(5);
						}
			     		}catch (Exception e) {
							
			     			System.out.println(e);
						
			     		
			     		}finally {
							
			     			
			     			try {
								cons.close();
							} catch (SQLException e) {
								
								System.out.println(e);
							}
						}
			     		return dsp;}
			     	

			     	
}
