package EJBS_CONTROL;
import java.sql.*;
import CONFIGURE.Connec_Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Games_Faces {

	
	Connec_Config connect;
	 
    //private static final long serialVersionUID = 1L;
 
   
    public byte[] get_que_Image(String productId) throws IOException,
			SQLException {
        int asd=Integer.parseInt(productId);
    
          connect = new Connec_Config();
         
         Connection connection=null;
         byte[] productImage = null;
         
          try {
   connection = connect.getConnection();
  
  PreparedStatement    ps = connection
     .prepareStatement("select * from  sport where id="+asd);
             try (ResultSet rs = ps.executeQuery()) {
                 while(rs.next()){
                  
                   
                    productImage = rs.getBytes("image");
                
                     
                 }   }
     

       }catch(SQLException ex){System.out.println(ex);
         
         }  
          finally {
        	  connection.close();
		}
          
          return productImage;}


    
					    public List<QueDAO> getAllCre(String op) throws IOException, SQLException {
					 List<QueDAO> productList = new ArrayList<>();
					
					
					 Connec_Config connect = new Connec_Config();
					         
					         Connection connection=null;
					         
					 try {
					   connection = connect.getConnection();
					  
					   PreparedStatement ps = connection
					     .prepareStatement("select * from sport  where id="+op);
					 
					   
					
					    ResultSet rs = ps.executeQuery();
					        QueDAO controlle;
					
					        while (rs.next()) {
					
					        controlle = new QueDAO();
					
					      String name = rs.getString("qus");
					
					      controlle.setName(name.trim());
					      
					      String email = rs.getString("a1");
					       
					      controlle.setName1(email);
					      
					      
					       String account = rs.getString("a2");
					       
					      controlle.setName2(account);
					      
					      
					      String phone = rs.getString("a3");
					       
					      controlle.setName3(phone);
					      
					      String add = rs.getString("a4");
					       
					      controlle.setName4(add);
					      
					     new Singleton().setYo_was_right(rs.getString("sma"));
					       
					      
					      productList.add(controlle);
					         }
					
					   
					    
					     }catch(SQLException ex){System.out.println(ex);}
					 
					 finally {
			        	  connection.close();
					}
					  return productList;
					}

					    
					    
					    public void Updatedime_Stack(String j) {
					    	
					    }
     
					   
					    
					    
					    String h;
					    int y;
					    public int CheckIN() {
					    	
					    	Connec_Config config= new Connec_Config();
					    	Connection cons;
					    	cons=config.getConnection();
					    	try {
								
					    		PreparedStatement ps=cons.prepareStatement("select * from public.dime_Stack where email like '%"+new Singleton().getEmail()+"%'");
						    	ResultSet rs=ps.executeQuery();
						    	while (rs.next()) {
				     			y=Integer.parseInt(h=rs.getString("sip"));
									
								}
						
					    	} catch (Exception e) {
							
								System.out.println(e);
							}finally {
								try {
									cons.close();
								} catch (SQLException e) {
							
									System.out.println("fat"+e);
								}
							}
							return y;
					    	
					    }
					    
					    int jkl;
					   public void   takeOut(String hi) {
						   Connec_Config config= new Connec_Config();
					    	Connection cons;
					    	cons=config.getConnection();
					    	try {
								
					    		PreparedStatement ps=cons.prepareStatement("select * from public.dime_Stack where email like '%"+new Singleton().getEmail()+"%'");
						    	ResultSet rs=ps.executeQuery();
						    	while (rs.next()) {
						    		jkl=Integer.parseInt(h=rs.getString("sip"));
									int y=new WebAPI_CONSQ_Current_User_block().Compare(jkl);
								  
									jkl=y-new QueDAO().u(hi);	
									
									LeftOver(jkl);}
						    	
						
					    	} catch (Exception e) {
							
								System.out.println(e);
							}finally {
								try {
									cons.close();
								} catch (SQLException e) {
							
									System.out.println("55"+e);
								}
					   }
               }



					private void LeftOver(int y) {
						  Connec_Config config= new Connec_Config();
					    	Connection cons;
					    	cons=config.getConnection();
					    	try {
								
					    		PreparedStatement ps=cons.prepareStatement("update  public.dime_Stack  set sip='"+y+"' where email like '%"+new Singleton().getEmail()+"%'");
						    	ps.executeUpdate();
						    	System.out.println("Updated Plus");
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
					   

}
