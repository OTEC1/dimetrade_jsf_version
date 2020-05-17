package EJBS_CONTROL;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped; //SessionScoped
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.swing.JPasswordField;

//import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class Main_Controller  implements Serializable{
				private static final long serialVersionUID = 1L;
			
			    public String productId,scroll_id,scroll_address,display,tstack,update,ids,eds,
			    productName,Group_name,reciever,ID,store_owner,
			 	log_in_user,pin,search,group_id,store_owner01,scroll_id01,address01,
			     stack_id,address;
		        public StreamedContent  late_Image,productImage,
		        walle_pro,scroll_imageAnchor,
		        scroll_image1,Wallet_img_search,scroll_image;
				@SuppressWarnings("unused")
				private List<Main_Controller> productList,
				group_stack_plate,scroll_query,
				wallet_run,
				wallet_search,
				scroll_query1;   
		      	public  byte[] image,images,iMG;
			     int f,k; int i;
				boolean fix_start;
         
				public  Main_Controller() throws IOException {
							
						   }
						
					@SuppressWarnings("unchecked")
				public List<Main_Controller> getWallet_search() throws IOException, SQLException {
				
					return new ProductListImageDAO().SearchwalleProductDetails(new Singleton().getStore_owner());
				}


				public void setWallet_search(List<Main_Controller> wallet_search) {
					this.wallet_search = wallet_search;
				}
				
				
				
			     public StreamedContent getWallet_img_search() {
						
	    	 	 
			    	 FacesContext context=FacesContext.getCurrentInstance();
						
			    	 if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
							return new DefaultStreamedContent();
						}else {
							
						 images=null;
							try {
			
								String fd=context.getExternalContext().getRequestParameterMap().get("pid");
									images	= new ProductListImageDAO().SearchwalletProductImage(fd);
							}catch (Exception e) {
							System.out.println(e);
							}
							
						}
						
						return new DefaultStreamedContent(new ByteArrayInputStream(images));
					}
			     public void setWallet_img_search(StreamedContent wallet_img_search) {
						Wallet_img_search = wallet_img_search;
					}
			     
			     
			     
			     
			     
				    public String getEds() {
						return eds;
					}


					public void setEds(String eds) {
						this.eds = eds;
					}

		

					public String getIds() {
						return ids;
					}


					public void setIds(String ids) {
						this.ids = ids;
					}
	
					
					
				
					
				
				public String getID() {
					return ID;
				}
				
				public void setID(String iD) {
					ID = iD;
				}
				
				public String getGroup_name() {
					return Group_name;
				}
				
				public void setGroup_name(String group_name) {
					Group_name = group_name;
				}
				
				
				
				public String getScroll_id() {
					return scroll_id;
				}
				
				public void setScroll_id(String scroll_id) {
					this.scroll_id = scroll_id;
				}
				
					
				    public String getStore_owner() {
								return store_owner;
							}


						public void setStore_owner(String store_owner) {
							this.store_owner = store_owner;
						}
						
						
						public String getAddress() {
							return address;
						}



						public void setAddress(String address) {
							this.address = address;
						}
						
						
						
						
						
						
						
						public String getStore_owner01() {
							return store_owner01;
						}

						public void setStore_owner01(String store_owner01) {
							this.store_owner01 = store_owner01;
						}

						public String getScroll_id01() {
							return scroll_id01;
						}

						public void setScroll_id01(String scroll_id01) {
							this.scroll_id01 = scroll_id01;
						}

						public String getAddress01() {
							return address01;
						}

						public void setAddress01(String address01) {
							this.address01 = address01;
						}

						
						
						
						
						
						
						
						
						
						
						public String getGroup_id() {
							return group_id;
						}


						public void setGroup_id(String group_id) {
							this.group_id = group_id;
						}

	
						public String getStack_id() {
							return stack_id;
						}


						public void setStack_id(String stack_id) {
							this.stack_id = stack_id;
						}

						 public String getScroll_address() {
								return scroll_address;
							}
			
			
							public void setScroll_address(String scroll_address) {
								this.scroll_address = scroll_address;
							}
						
                    
						   
							
							



	
						/////////////////////////////////////////////////////
						
						
						
					 
								
									public String getUpdate() {
										return update;
									}
								
									public void setUpdate(String update) {
										this.update = update;
									}
								
									public String getTstack() {
										return tstack;
									}
								
									public void setTstack(String tstack) {
										this.tstack = tstack;
									}
								
									public String getDisplay() {
										return display;
									}
								
									public void setDisplay(String display) {
										this.display = display;
									}
						
									public int getF() {
										return f;
									}
								
									public void setF(int f) {
										this.f = f;
									}
								
									public void RenderB() {
										fix_start=false;
										f=0;
										
									}
						




		
			
			
			
		
			public StreamedContent getWalle_pro() throws SQLException {
				FacesContext context = FacesContext.getCurrentInstance();
				
				if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
					return new DefaultStreamedContent();
				} else {
			
				
					image = null;
					
					 pin=context.getExternalContext().getRequestParameterMap().get("pid");
				
					image= new ProductListImageDAO().walletProductImage(pin);
					
					}
				
			
					return new DefaultStreamedContent(new ByteArrayInputStream(image));
			}

		
			public void setWalle_pro(StreamedContent walle_pro) {
				this.walle_pro = walle_pro;
			}
			
			protected int  min(int y) {
				return (int)(Math.random()*y);
			}
			

		    @SuppressWarnings("unchecked")
				public List<Main_Controller> getWallet_run() throws IOException, SQLException {
				                        
					                if(new Singleton().getRandom_odd()==0) {
					                    new Singleton().setRandom_odd(min(7));
					                    System.out.println("Max table"+new ProductListImageDAO().maxof_table()+"  Random Num "+new Singleton().getRandom_odd());
					                    }else {
					                    	System.out.println("Old Random  C"+new Singleton().getRandom_odd());
					                    }
					return new  ProductListImageDAO().walleProductDetails(new ProductListImageDAO().maxof_table(),new Singleton().getRandom_odd());
				}

				public void setWallet_run(List<Main_Controller> wallet_run) {
					this.wallet_run = wallet_run;
				}
				
				
			
							public String getProductId() {  
							    return productId;
							}
							
							public void setProductId(String productId) {
							    this.productId = productId;
							}
							   
							
							
							
							public void setProductList(List<Main_Controller> productList) {
								this.productList = productList;
							}
							
							@SuppressWarnings("unchecked")
							public List<Main_Controller> getProductList() throws IOException, SQLException {
							
								return new ProductListImageDAO().getProductDetails(new Singleton().getStore_owner());
							}
							
							
							
							public String getProductName() {
								return productName;
							}
							
							public void setProductName(String productName) {
								this.productName = productName;
							}
							
							
			
			
	
			
			
			
			
			public void setProductImage(StreamedContent productImage) {
				this.productImage = productImage;
			}
			
			public StreamedContent getProductImage() throws  SQLException, Exception {
			
				FacesContext context = FacesContext.getCurrentInstance();
			
				if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
					return new DefaultStreamedContent();
				}
			
				else {
			
					String id = context.getExternalContext().getRequestParameterMap()
							.get("pid");
			
					byte[] image = new ProductListImageDAO().etProductImage(id);
			
					return new DefaultStreamedContent(new ByteArrayInputStream(image));
			
				
			            }}
			
			
			
			public StreamedContent getScroll_image() throws SQLException {
				

				FacesContext context = FacesContext.getCurrentInstance();
			
				if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
					return new DefaultStreamedContent();
				}
			
				else {
			
					String id = context.getExternalContext().getRequestParameterMap()
							.get("sending");
			
					byte[] image = new WebAPI_CONSQ_Current_User_block().scroll_Image(id);
			
					return new DefaultStreamedContent(new ByteArrayInputStream(image));
			
				
			            }}
			
				public void setScroll_image(StreamedContent scroll_image) {
					this.scroll_image = scroll_image;
				}
				
				
				
				
				
			static	int y;
				
				@SuppressWarnings("unchecked")
				public List<Main_Controller> getScroll_query() throws SQLException, FileNotFoundException {
//			 y++;
//					 String p=String.valueOf(y);
//					NEXZZTVID(p);
					return new WebAPI_CONSQ_Current_User_block().Pass_all_update();
				}
				
				public void setScroll_query(List<Main_Controller> scroll_query) {
					this.scroll_query = scroll_query;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				//pass down query for debit too work with; 
				boolean flush=false;
				public boolean isFlush() {
					return flush;
				}


				public void setFlush(boolean flush) {
					this.flush = flush;
				}


				public String SEND_ODD_QUERY() {
					
					 FacesContext fc=FacesContext.getCurrentInstance();
				   String params=fc.getExternalContext().getRequestParameterMap().get("sds");
				    new Singleton().setGroup_odd_pick(params);
				    flush=true;
				    System.out.println(new Singleton().getGroup_odd_pick()+"[]A");
				    return null;}
				
				
				
				
				
				
				
				
				
				
				
				//Debit Current User for Stack

				String hs;  static int v;
				public String  hammer() throws IOException, SQLException { 
				    if(tstack.isEmpty()|tstack.equals("")|tstack.trim().length()==0|new Singleton().getGroup_odd_pick().trim().length()==0) {
						System.out.println("Empty");
						update=""; 
					//	new Singleton().setGroup_odd_pick("");
					new	Singleton().setV(727);
					}else if(new Singleton().getV()==1){
						FacesContext context = FacesContext.getCurrentInstance();
						hs=context.getExternalContext().getRequestParameterMap().get("xcx");
						new  Singleton().setOdd_bet_id(tstack.trim());
						 new Games_Faces().takeOut(new Singleton().getMatch_check());
						 new WebAPI_CONSQ_Current_User_block().constant_query(new Singleton().getEmail());
						    System.out.println("Amout  |"+new Singleton().getOdd_bet_id());
				     		System.out.println("GRPID|"+new Singleton().getGroup_odd_pick());
				     		new Singleton().setGroup_odd_pick("1010101");
				     		new	Singleton().setV(727);
				     		}
				     
				
				
			return "";	}
                  
				
				public void next() {
				  if(new Singleton().getV()==1) {
					update="Matched"; 
					tstack="";
				  }
				}
		
				public void clear() {    
					new Singleton().setMatch_check(tstack);
						
					if(new Singleton().getMatch_check().trim().equals("opo")) {
						update="Enter a Stack";
					
						new	Singleton().setV(727);
						System.out.println("a");
			  }else if(new Singleton().getMatch_check().trim().equals("0")
						    |new Singleton().getMatch_check().trim().equals("00")
							|new Singleton().getMatch_check().trim().equals("000")
							|new Singleton().getMatch_check().trim().equals("0000")
							|new Singleton().getMatch_check().trim().equals("00000")
							|new Singleton().getMatch_check().trim().equals("000000")){
				      
				       new 	 Singleton().setV(727);
						update="Stack too  low"; 
						System.out.println("b");
						}else  if(new Singleton().getMatch_check().trim().length()==0){
							
							
							
							new 	Singleton().setV(727);
							update="Stack too  low"; 
							System.out.println("c");
							
						}else if(!new QueDAO().Corrupt_char(new Singleton().getMatch_check().trim())){
							
							
							new 	Singleton().setV(727);
							update="Invalid  data"; 
							System.out.println("d");
							
						}else if(new Games_Faces().CheckIN()<=0) {
						
						
							new	 Singleton().setV(727);
							update="Too low On Gas"; 
						
						
				       } else  if(new Games_Faces().CheckIN()<new QueDAO().u( new Singleton().getMatch_check().trim())){
							
							new	 Singleton().setV(727);
							update="Oops Out Of Gas"; 
						}else if(new Singleton().getEmail().equals("-0000-")) {
						
							
							new	 Singleton().setV(727);
							update="Pls Sign in"; 
						
						}else if(new Singleton().getGroup_odd_pick().trim().equals("1010101")) {
						
							new	 Singleton().setV(727);
							update="Pls select a bubble"; 
						
						}	else {
						
							v=1;
							new Singleton().setV(v);
						//	new Singleton().getMatch_check().trim();
							update="Stack Ok"; 
								
						}
				}
           
			
				
				
				
				
			
				
				
				
			//m
			public StreamedContent getlate_Image() throws IOException, SQLException {
			
				FacesContext context = FacesContext.getCurrentInstance();
			
				if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
					return new DefaultStreamedContent();
				} else {
			
					//ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
					byte[] 	images = null;
				
						images = new WebAPI_CONSQ_Current_User_block().getGroupImages_info(new Singleton().getGroup_odd_pick());
				return new DefaultStreamedContent(new ByteArrayInputStream(images));
				}
				
			}
				
			
			
			public void setlate_Image(StreamedContent late_Image) {
				this.late_Image = late_Image;
			}
			
			
			//m2
			@SuppressWarnings("unchecked")
			public List<Main_Controller> getGroup_stack_plate() throws IOException, SQLException {
				return new WebAPI_CONSQ_Current_User_block().groupfinders(new Singleton().getGroup_odd_pick());
			}
			
			
			
			public void setGroup_stack_plate(List<Main_Controller> group_stack_plate) {
				this.group_stack_plate = group_stack_plate;
			}
			
			
			
			
			
		
			
			
	
			
			
		
			
			
			
		
			
			
			
			
			  public StreamedContent getScroll_image1() throws IOException {
					FacesContext context = FacesContext.getCurrentInstance();
					
					if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
						return new DefaultStreamedContent();
					} else {
				
						//ByteArrayOutputStream bos = new ByteArrayOutputStream();
				
				     	image = null;
						try {

						
							image = new WebAPI_CONSQ_Current_User_block().serach_query_img(new Singleton().getSearch_query());
						
						} catch (SQLException e) {  System.out.println(e);
						}}
				
						return new DefaultStreamedContent(new ByteArrayInputStream(image));
				
					}

				

				public void setScroll_image1(StreamedContent scroll_image1) {
					this.scroll_image1 = scroll_image1;
				}


				@SuppressWarnings("unchecked")
				public List<Main_Controller> getScroll_query1() throws SQLException, IOException {
				
					
					return  new WebAPI_CONSQ_Current_User_block().search_update(new Singleton().getSearch_query());
				}


				public void setScroll_query1(List<Main_Controller> scroll_query1) {
					this.scroll_query1 = scroll_query1;
				}
		    
				
			
						
							
						     public StreamedContent getScroll_imageAnchor() throws SQLException {
						    	 FacesContext context= FacesContext.getCurrentInstance();
						    	 if(context.getCurrentPhaseId()==PhaseId.RENDER_RESPONSE) {
						    		 return new DefaultStreamedContent();
						    	 }else {
						    	 
						    	
						    		 
						    		  String c=context.getExternalContext().getRequestParameterMap()
						    				  .get("storeowner");
						    		  byte []   img= new WebAPI_CONSQ_Current_User_block().getScrollAnchorimg(c);
						    	 
									return new DefaultStreamedContent(new ByteArrayInputStream(img));
								
						    	 }}







								public void setScroll_imageAnchor(StreamedContent scroll_imageAnchor) {
									this.scroll_imageAnchor = scroll_imageAnchor;
								}
								
								
								
								
								int d;
								private void NEXZZTVID(String h) throws FileNotFoundException {
									 for(int  y=0;y<h.length();y++) { 
									new Video().bVideo(d++);
								System.out.println("d"+d);
									 }
										
										}
								
								
								
												
								public String spam() throws IOException, SQLException {
								//	update="updated";
									new Singleton().setRandom_odd(min(7));
									  System.out.println("New Random B num"+new Singleton().getRandom_odd()+""+"Max table"+new ProductListImageDAO().maxof_table());
						             System.out.println(new Singleton().getMatch_check());
									System.out.println(new Singleton().getAddressing());
									new Singleton().setGroup_odd_pick("1010101");
							return "/Walleto.xhtml";	}		



						public String stake_ativate_wallet_clear() {
						int ysa= new ProductListImageDAO().stake_drop_check(new Singleton().getGroup_odd_pick());
						
						if(ysa==1) {
							
							update="Stack drop";
						}else  if(ysa==2){
							
							update="Zero Permisson ";
						}
						new	 Singleton().setV(727);
					    new Singleton().setGroup_odd_pick("1010101");
							   return "";}


						
						
						
						
}



