package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.MeterGaugeChartModel;

import CONFIGURE.Connec_Config;
import net.sf.jasperreports.engine.xml.JRFontFactory.ChartFontFactory;
import net.sf.jasperreports.renderers.JFreeChartRenderer;

@ManagedBean
@RequestScoped
public class Sub_controller  implements Serializable{


    /**
	 *                      
	 */
					protected static final long serialVersionUID = 1L;
					protected String j,ojukwu,xer,gnames,
					mail,ids,indiviual_uniqe_group_id,gname,
					fill_all,stake,member_count;
					protected int xc,sw,qw,ko,top;
				    protected UploadedFile uploaded;
                  	protected DonutChartModel chart;
					 public boolean kit,kit1=false,saz,hide_main;
				    protected  StreamedContent 
					 Group_com2geter,current_group_involved,
                     created_group_img,
                     group_request_img,
                     Group_list_all_img;
				    protected   List<Sub_controller> 
                    group_com2geter_stack,
                    created_group_detail,
                    group_request,
                    Group_list_all;
                    boolean s1=true;
                       
                 
                    public     Sub_controller() {    SWAP();
				    chart=new DonutChartModel();
				  
				 
				 }
                    
					                    
					               	 public boolean isHide_main() {
											return hide_main;
										}
					
										public void setHide_main(boolean hide_main) {
											this.hide_main = hide_main;
										}
					                
										
									public boolean isSaz() {
										return saz;
									}
				
									public void setSaz(boolean saz) {
										this.saz = saz;
									}
                           
									public String getMember_count() {
										return member_count;
									}
				
									public void setMember_count(String member_count) {
										this.member_count = member_count;
									}
				                    
				                    
				                	public String getIds() {
										return ids;
									}
				
									public void setIds(String ids) {
										this.ids = ids;
									}
				                    
				                    public String getGnames() {
										return gnames;
									}
				
									public void setGnames(String gnames) {
										this.gnames = gnames;
									}
				
									   public String getMail() {
											return mail;
										}

										public void setMail(String mail) {
											this.mail = mail;
										}

				
									public String getIndiviual_uniqe_group_id() {
										return indiviual_uniqe_group_id;
									}
				
									public void setIndiviual_uniqe_group_id(String indiviual_uniqe_group_id) {
										this.indiviual_uniqe_group_id = indiviual_uniqe_group_id;
									}


                    
							
									public String getStake() {
										return stake;
									}
				
									public void setStake(String stake) {
										this.stake = stake;
									}
					
				                      
									  public boolean isKit1() {
											return kit1;
										}
				
										public void setKit1(boolean kit1) {
											this.kit1 = kit1;
										}
					
									
									public String getFill_all() {
										return fill_all;
									}
								
									public void setFill_all(String fill_all) {
										this.fill_all = fill_all;
									}
						
						    
								 public String getGname() {
										return gname;
									}
							
									public void setGname(String gname) {
										this.gname = gname;
									}
							
									public UploadedFile getUploaded() {
										return uploaded;
									}
							
									public void setUploaded(UploadedFile uploaded) {
										this.uploaded = uploaded;
									}
							
						
						
								    public String getOjukwu() {
								  		return ojukwu;
								  	}
								
								  	public void setOjukwu(String ojukwu) {
								  		this.ojukwu = ojukwu;
								  	}
								    
								    
								public boolean isKit() {
										return kit;
									}
								
									public void setKit(boolean kit) {
										this.kit = kit;
									}
								
								
						        
						     	  public String web_transfer() {
						     		
							        WRITE("1");
							     
							        return "/indexto_do_Cat.xhtml";}
							  
							  
							  
								  public String redirect(){
									  
						
								        
								   return"/Shopping.xhtml"; }
								    
								    
								    public String redirect2(){
								        
								    	WRITE("2");
								    	
								      return"/indexwalleto.xhtml"; }
								    
								
						
						     public String redirect2_Pha(){
						        
					     		WRITE("3");
					     	
						       return"/index_group_mining.xhtml"; }
						
						
						     public String redirect_loc1() {
									
							      WRITE("4");
							 
						       return "/index_geomap.xhtml";}
						     
						     
						     
					         	public String redirect_Location(){
						  
							    WRITE("5");
								
						         return"/index_delivery.xhtml";}
						
						
						        
				             public String redirect_dime(){
				        
				    	        WRITE("6");
				    	    	
				              return"/window.xhtml"; }
				    
				    
				             public String load() {
				            		
				            	 WRITE("00");
				            	
				    	    return"/index.xhtml";}
				    
				
				    
				            public String SUMALLA() {	 
				    	   
				    	   
				    	   
				    	   return"/Payment_method.xhtml"; }
					 
					        
				            public String SUMALLB() {
					   
					        
					        	 
						    return"/Payment_method.xhtml"; }
					 
				    
					        public String VCard() {
						
					         
					        return "/Payment_slip_Card.xhtml";}
						
					        
					        
						    public String MCard() {
							
					    	
						    	
						   return "/Payment_slip_Card.xhtml";}
						
						
						    public String PayPal() {
							
						    	
						    	
						    return "/Payment_slip_Card.xhtml";}
						
						
						     public String dime_wallet() {
							
							
						    	
						    	 
						    	 
						    return "/Payment_slip.xhtml";}
						
						
						       public String search_result1() throws IOException{
						        
						    	 
				
							    return"/Walleto.xhtml?faces-redirect=true"; }
							     
							     
								
						       public String search_result_location() throws IOException{
								        
							
						    	   
						    	   
							   return"/Location_Report.xhtml?faces-redirect=true"; }
								        
							
						       
						       public String path(){
								
						    	   
						    	   
								 return"/Bussiness_page.xhtml";}
									
									
								      
								 
								 public String chart_up() {
								 
									 
									 
								    return "/chart_up.xhtml";}
								        
								        
								        
				        
				      
				     
		
		
				    public String search_result() throws IOException{
				      
				  
				    	 
				    	FacesContext fcs=FacesContext.getCurrentInstance();
				    	String hs= fcs.getExternalContext().getRequestParameterMap().get("query_server");
				    	new Singleton().setClick_query(hs);
				    	
				    	  FacesContext context= FacesContext.getCurrentInstance();
				    	String vc=context.getExternalContext().getRequestParameterMap().get("owner");;
				    	   new Singleton().setStore_owner(vc);
				    	   System.out.println(hs+"N|N"+vc);
				    	   
				    	 return"/index_shopping.xhtml"; }
				   
	    
				    public String bean_result() throws IOException{
					      
					 	FacesContext fcs=FacesContext.getCurrentInstance();
				    	String hs= fcs.getExternalContext().getRequestParameterMap().get("wat");
				    	new Singleton().setClick_query(hs);
				    	
				    	  FacesContext context= FacesContext.getCurrentInstance();
				    	String vc=context.getExternalContext().getRequestParameterMap().get("up");;
				    	   new Singleton().setStore_owner(vc);
				    	  System.out.println(hs+"AND"+vc);
				    	 return"/index_shopping.xhtml"; }
	     
	        
	    
	    
	        
	        public String umark() throws IOException {
				kit=false;  new Singleton().setM(0);  ko=3;
	
				PassIn(ko);
				
			return"";}
	        
	        
	        public String mining() throws IOException {
	        	ko=1; PassIn(ko);    kit=true; ojukwu="Mining...";
	        if(new Singleton().getM()>0) {
	        	
	        }else {
				  Thread t= new Thread() {
				  public void run() {
					  for( xc=0; xc<999; xc++) { 	
					
						  System.out.println(xc);
						  
						 
						  
								 
					String ce=new Singleton().getGo_mining();
					ko=Integer.parseInt(ce);
						
						if(ko>2)
								break;
						
						  try {
								Thread.sleep(1000);
							
								
							
							} catch (Exception e) {
								System.out.println(e);
							}
						  
							
						
						
						  if(xc>=7) {
							  
							 
								  
							new ODD_ST().	bit_check();
								
						 qw=bot1(457869534);    sw=user1(280454179);
							  
							 		  if(qw==sw) {
				
							 new ODD_ST(). QUERY(new Singleton().getEmail());
					             	  }
							  xc=0;
							  System.out.println("bot <>"+qw+" user <>"+sw);
								
						  }
						  SWAP() ;
						  
				 
					  }
				  }
              };t.start();

	        }
	        return "";}
	        
	        
	        
							private int bot1(int i) {
								return (int)(Math.random()*i);
						 }
							
							private int user1(int i) {
								return (int)(Math.random()*i);
						 }

		
			  
							
							
							
							
		    	public String PASS_ON() {
					FacesContext context=FacesContext.getCurrentInstance();
					String j=context.getExternalContext().getRequestParameterMap().get("bs2");
					new Singleton().setCURGPID(j);
					
					FacesContext context1=FacesContext.getCurrentInstance();
					String j1=context1.getExternalContext().getRequestParameterMap().get("bs3");
		           new Singleton().setBse3(j1);
				
		          System.out.println(new Singleton().getCURGPID()+"###");
					saz=true;
				    s1=false;
				return "/Group_mining.xhtml";}
				
			
		    	
		
					public void  HELPER() {
						if(new Singleton().getM()>3607) {
							
						
						new ODD_ST().QUERY(new Singleton().getEmail());
  			
						new Singleton().setM(1);
							
						new ODD_ST().	Mplus(new Singleton().getM());
									}
									
								}
					
								public void PassIn(int u) throws IOException {
									 xer=String.valueOf(u);
									 new Singleton().setGo_mining(xer);
								}
								
								
								
								public void SWAP() {
									
								String ce=new Singleton().getGo_mining();
								
								ko=Integer.parseInt(ce);
									
								
								   if(ko==1) {
									   kit=true; ojukwu="Mining...";
								   }else if(ko<1) {
									   kit=false; ojukwu="  ";
								   }
								
								}
			
				    	
					
				
						public void  WRITE(String i) {
						
							new Singleton().setNav_index(i);
						}
						
						public  void xzx() {
							System.out.println("pop");
						}
						
						
					
						 
						 
						
						 
						 
						 public DonutChartModel getChart() {
								return chart;
							}
						 
				 
					 
					     byte [] h;
					   public String  creating_group() {
							if(gname.trim().length()==0 | uploaded.getSize()==0) {
								fill_all="Fill  field and upload Pics";
								System.out.println("Empty");
						
							}else if(new Singleton().getEmail().equals("-0000-")) {
							
								fill_all="Pls  Sign in ";
							
					       }else {
								try {
								new user_file_sql_uploader().Create_G(new Singleton().getAddressing(),fill_all, h=IOUtils.toByteArray(uploaded.getInputstream()));
							
							           fill_all="New Group Created !";
							
								}catch (Exception e) {
									 
									fill_all="Unknow Error Occured !";
								}
								}
							
						 return "/Group_mining.xhtml";}
		 
					
					   
					   public String stake_ativate_clear() {
						   
						   new Singleton().setBse3("New bubble");
							 kit1=true;
					   return "/Group_mining.xhtml";}
					   
					   
						public boolean isS1() {
							return s1;
						}


						public void setS1(boolean s1) {
							this.s1 = s1;
						}
                     
		   
		                  public String stake_activate() {
		                	  if(new Singleton().getEmail().equals("-0000-")) {
		  		            
							    	kit1=false;
								   fill_all="---------Pls Sign in----------"; 
								
				   } else 
								  
						     if(!new Singleton().getCURGPID().trim().equals("969696969")) {
							
							fill_all=new Singleton().getBse3()+" would be Updated !";
							 kit1=true;
							  saz=true;	
							  
					}else 
						
						 if(new Singleton().getCURGPID().equals("969696969")) {
					    	   
					    	   fill_all="Pls Select a buble to Proceed";
			                	  
			        }else  
						
						if(new ODD_ST().Check_if_group_exist(new Singleton().getEmail())) {
						 	   kit1=true;
							
						}else {  
							   kit1=false;
							   fill_all="-No Currently Created Group-"; 
								
						}
					      return "/Group_mining.xhtml";}
					   
		            	  protected	 long u(String parseInt) {
		  					long y=	Long.parseLong(parseInt.trim());
		  							return y;
		  						} 
		            	  
					   public String stake_ativate_send() {
						  
						   new Singleton().setSTACK(stake);
						   if(new Singleton().getSTACK().trim().length()<0) {
							   fill_all="------No value Specifield------";
								
							   return "/Group_mining.xhtml";
							   
						   } else
							if(!new QueDAO().Corrupt_char(new Singleton().getSTACK())) {
								fill_all="------Corrupted Fomat------";
							
							}else 	if(new Games_Faces().CheckIN()<=0) {
								
								fill_all="--------Too low On Gas-------"; 
								new Singleton().setZERO_ODD(96);
							
							}else	if(new WebAPI_CONSQ_Current_User_block().Compare(new Games_Faces().CheckIN())<u((new Singleton().getSTACK()))){
							
								fill_all="--Oops You ran Out Of Gas--"; 
									new Singleton().setFile_flip(96);
								}else  if(new Singleton().getEmail().equals("-0000-")){
									
									fill_all="------- Pls Sign in --------";
									new Singleton().setZERO_ODD(96);
								
							 }else  {
								 new Singleton().setZERO_ODD(1);
								 ROAM();
							
								
							}
						
					
						return "/Group_mining.xhtml";}

							
					           private String ROAM() {
					        	   
								if(new Singleton().getZERO_ODD()==1) {
									try {
									
									new Games_Faces().takeOut(new Singleton().getSTACK());
									new ODD_ST().name();
									new ODD_ST().Buckets(new Singleton().getSTACK(),new ODD_ST().ADDRESS(), new Singleton().getS2(),new Singleton().getS3(),new Singleton().getU());
							       
									fill_all="------------Stacked-----------";
									
									}catch (Exception e) {
												System.out.println(e);
												fill_all="-Unknow Error Pls try again-";
											}
									
								}
								
								return "/Group_mining.xhtml";}
					   
					   
					  
					   
					           
					  
								//Member's Gather
								          public StreamedContent getGroup_com2geter() {
								        	  FacesContext context=FacesContext.getCurrentInstance();
												if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
													return new DefaultStreamedContent();
												}else {
												
													byte [] img=null;
													//String hj=context.getExternalContext().getRequestParameterMap().get("");
													img=new ODD_ST().getGrouplatestimg(new Singleton().getAddressing());
								        	  return new DefaultStreamedContent(new ByteArrayInputStream(img));
											}}
		
		
								        
											public void setGroup_com2geter(StreamedContent group_com2geter) {
												Group_com2geter = group_com2geter;
											}
											
											
											//Member's Gather
											@SuppressWarnings("unchecked") 
											public List<Sub_controller> getGroup_com2geter_stack() {
												return new ODD_ST().getGrouplatestodd(new Singleton().getAddressing());
											}



										public void setGroup_com2geter_stack(List<Sub_controller> group_com2geter_stack) {
											this.group_com2geter_stack = group_com2geter_stack;
										}
									
							
										
										
										
									
										
										
										
										
										
										
										//friends Request 
										 public StreamedContent getGroup_request_img() {
											FacesContext context=FacesContext.getCurrentInstance();
											if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
												return new DefaultStreamedContent();
											}else {
											
												byte [] img=null;
												//String hj=context.getExternalContext().getRequestParameterMap().get("");
												img=new ODD_ST().Request_img(new Singleton().getAddressing());
											return new DefaultStreamedContent(new ByteArrayInputStream(img));
											}
										 }
		
											public void setGroup_request_img(StreamedContent group_request_img) {
												this.group_request_img = group_request_img;
											}
								
										
											//friends Request 
											@SuppressWarnings("unchecked")
											public List<Sub_controller> getGroup_request() {
												return new ODD_ST().Request(new Singleton().getAddressing());
											}
	
											public void setGroup_request(List<Sub_controller> group_request) {
												this.group_request = group_request;
											}
											
										
										
										
										
										
										
										
										
										//groups_stake_gather
										@SuppressWarnings("unchecked")
										public List<Sub_controller> getCreated_group_detail() {
											return new ODD_ST().groups_created_gather(new Singleton().getAddressing());
										}
					
										public void setCreated_group_detail(List<Sub_controller> created_group_detail) {
											this.created_group_detail = created_group_detail;
										}

										
										//groups_stake_gather
										public StreamedContent getCreated_group_img() {
											FacesContext context=FacesContext.getCurrentInstance();
											if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
												return new DefaultStreamedContent();
											}else {
											
												byte [] img=null;
												//String hj=context.getExternalContext().getRequestParameterMap().get("");
												img=new ODD_ST().groups_created_gather_img(new Singleton().getAddressing());
											return new DefaultStreamedContent(new ByteArrayInputStream(img));
											}
										}
					
										public void setCreated_group_img(StreamedContent created_group_img) {
											this.created_group_img = created_group_img;
										}
					
										
										
										
										
										
										
									    	//List of group
										
										  public StreamedContent getGroup_list_all_img() {
												FacesContext context=FacesContext.getCurrentInstance();
												if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
													return new DefaultStreamedContent();
												}else {
												
													byte [] img=null;
													String hj=context.getExternalContext().getRequestParameterMap().get("gs1");
													img=new ODD_ST().list_group_img(hj);
												return new DefaultStreamedContent(new ByteArrayInputStream(img));
												}}
                                        
											public void setGroup_list_all_img(StreamedContent group_list_all_img) {
												Group_list_all_img = group_list_all_img;
											}

										
											
											
											//List of group
											@SuppressWarnings("unchecked")
											public List<Sub_controller> getGroup_list_all() {
												if(new Singleton().getStore_owner().trim().length()>0) {
													
													System.out.println(new Singleton().getStore_owner()+"!1");
													
													return new ODD_ST().list_groupAD(new Singleton().getStore_owner());
											
													
												}else
													
													if(new Singleton().getStore_owner().trim().length()<=0) 
												
													System.out.println(new Singleton().getEmail()+"!2"); 
													
												return new ODD_ST().list_group(new Singleton().getEmail());
												
											}

											public void setGroup_list_all(List<Sub_controller> group_list_all) {
												Group_list_all = group_list_all;
											}


											

											
											
											
											//Current group involved
											public StreamedContent getCurrent_group_involved() {
												FacesContext context=FacesContext.getCurrentInstance();
												if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
												 return new DefaultStreamedContent();
												}else {
													
												
												  byte [] img=null;
												  
												  img= new ODD_ST().Current_group_img(new Singleton().getCURGPID());
												
												return new DefaultStreamedContent(new ByteArrayInputStream(img));
											}}

											public void setCurrent_group_involved(StreamedContent current_group_involved) {
												this.current_group_involved = current_group_involved;
											}
		
											
											
											
		 }
		