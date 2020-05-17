package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class QueDAO implements Serializable{

				 private static final long serialVersionUID = 1L;
				 public String name,name1,name2,
				 name3,name4,name5,id_que,odds,ids,current_player,tstack,update;
				Thread sd;
			     boolean fix=true,render_input;
			 	@SuppressWarnings("unused")
				private List<QueDAO>credentialsList,random_shift;
			    int aw1,aw2,aw3,y,f;    
			    public String fox,mark1,mark2,mark3,mark7,
			    n1,n2,n3,c1,c2,c3,fleet; 
			    StreamedContent que_context_image;
			    boolean vbx;
			    
    





					public QueDAO(){
				           fix=false;
				           render_input=false;
				           current_player=new Singleton().getEmail();
				         }
				    
					
					public String getCurrent_player() {
						return current_player;
					}




					public void setCurrent_player(String current_player) {
						this.current_player = current_player;
					}
					
					public String getTstack() {
						return tstack;
					}


					public void setTstack(String tstack) {
						this.tstack = tstack;
					}


					public String getUpdate() {
						return update;
					}


					public void setUpdate(String update) {
						this.update = update;
					}

					

					public String getIds() {
						return ids;
					}



					public void setIds(String ids) {
						this.ids = ids;
					}

				    	
				    
						 public String getOdds() {
								return odds;
							}





						public void setOdds(String odds) {
							this.odds = odds;
						}
						
						
				     
				   public boolean isFix() {
				       return fix;
				   }
				
				   public void setFix(boolean fix) {
				       this.fix = fix;
				   }
				   
				   
				
					public String getN1() {
						return n1;
					}
				
					public void setN1(String n1) {
						this.n1 = n1;
					}
				
					public String getN2() {
						return n2;
					}
				
					public void setN2(String n2) {
						this.n2 = n2;
					}
				
					public String getN3() {
						return n3;
					}
				
					public void setN3(String n3) {
						this.n3 = n3;
					}
					
				   public String getName() {
				  
				       return name;
				   }
				
				   public void setName(String name) {
				       this.name = name;
				     
				       
				   }
				
				   public String getName1() {
				       return name1;
				   }
				
				   public void setName1(String name1) {
				       this.name1 = name1;
				   }
				
				   public String getName2() {
				       return name2;
				   }
				
				   public void setName2(String name2) {
				       this.name2 = name2;
				   }
				
				   public String getName3() {
				       return name3;
				   }
				
				   public void setName3(String name3) {
				       this.name3 = name3;
				   }
				
				   public String getName4() {
				       return name4;
				   }
				
				   public void setName4(String name4) {
				       this.name4 = name4;
				   }
				
				   public String getName5() {
				       return name5;
				   }
				
				   public void setName5(String name5) {
				       this.name5 = name5;
				   }
				   
				   public boolean isRender_input() {
						return render_input;
					}
				
					public void setRender_input(boolean render_input) {
						this.render_input = render_input;
					}
				    
				    public String getC1() {
						return c1;
					}
				
					public void setC1(String c1) {
						this.c1 = c1;
					}
				
					public String getC2() {
						return c2;
					}
				
					public void setC2(String c2) {
						this.c2 = c2;
					}
				
					public String getC3() {
						return c3;
					}
				
					public void setC3(String c3) {
						this.c3 = c3;
					}
				
					public boolean isVbx() {
						return vbx;
					}
				
					public void setVbx(boolean vbx) {
						this.vbx = vbx;
					}
					
					
					  public String getFleet() {
							return fleet;
						}
				
						public void setFleet(String fleet) {
							this.fleet = fleet;
						}
						
						
						public String que_finder() {
							int sop=Bos(100); 
							id_que=String.valueOf(sop);
							fix=true;  
						    Thread_Service();
						return "";}
				   
				   public StreamedContent getQue_context_image() throws IOException {
					   FacesContext context=FacesContext.getCurrentInstance();
				   
					   if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
							return new DefaultStreamedContent();
						} else {
				
							//ByteArrayOutputStream bos = new ByteArrayOutputStream();
				
					     byte[]	image = null;
							try {     id_que="1";
								image = new Games_Faces().get_que_Image(id_que);
							
							} catch (SQLException e) {  System.out.println(e);
							}
							return new DefaultStreamedContent(new ByteArrayInputStream(image));}
				}
				
						public void setQue_context_image(StreamedContent que_context_image) {
							this.que_context_image = que_context_image;
						}
						   
					       
						
						
						@SuppressWarnings("unchecked")
				    	public List<QueDAO> getCredentialsList()throws IOException, SQLException {
							// System.out.println("Query id:  "+id_que);
							id_que="1";
				          return  new   Games_Faces().getAllCre(id_que);
				       }
				
				       public void setCredentialsList(List<QueDAO> credentialsList){
				       this.credentialsList = credentialsList;
				      
				         }
				  
			
			
			
				    public int getF() {
						return f;
					}
			
					public void setF(int f) {
						this.f = f;
					}
			
						public  String gamea(){
					      FacesContext context= FacesContext.getCurrentInstance();
						      String vb=context.getExternalContext().getRequestParameterMap().get("sw1");
						   
						   if(vb.equals(new Singleton().getYo_was_right())) {
							   
							    System.out.println("right");
								 }else{
									    System.out.println(vb);
								 }
										fix=false;
						return"/window.xhtml?faces-redirect=true";}
						
						
						public  String gameb(){
						 FacesContext context= FacesContext.getCurrentInstance();
						      String vb=context.getExternalContext().getRequestParameterMap().get("sw2");
						      if(vb.equals(new Singleton().getYo_was_right())) {
						    	    System.out.println("right");
								 }else{
								     System.out.println(vb);
								 }
						   fix=false;
						return"/window.xhtml?faces-redirect=true";}
						
						
						public  String gamec(){
						 FacesContext context= FacesContext.getCurrentInstance();
						      String vb=context.getExternalContext().getRequestParameterMap().get("sw3");
						      if(vb.equals(new Singleton().getYo_was_right())) {
						    	     System.out.println("right");
								 }else{
								     System.out.println(vb);
								 }
						 
						      fix=false;
						return"/window.xhtml?faces-redirect=true";}
						
						
						public  String gamed(){
						FacesContext context= FacesContext.getCurrentInstance();
						    String vb=context.getExternalContext().getRequestParameterMap().get("sw4");
						    if(vb.equals(new Singleton().getYo_was_right())) {
						        System.out.println("right");
							 }else{
							     System.out.println(vb);
							 }
						   fix=false;
						return"/window.xhtml?faces-redirect=true";}
			
			
			
			
						
						
						
						private int Bos(int i) {
						    return (int)(Math.random()*i);
						 
						 }
						
					  private void Thread_Service() {
							if(y>0) {
								
							}else{
							  sd= new Thread() {
									public void run() {
										for( y=0; y<7; ++y) {
											try {
									Thread.sleep(1000);
										f++;
											System.out.println(y);
										}catch(Exception ex) {System.out.println(ex);}
										}
								
									}
							}; sd.start();
								}
			//				if(y==10) {
			//						y=0;
			//				}
							
						}
						   
						
					  
		  public String input_show() {
			 
			  render_input=true;
		 return ""; }
		  
		  
		  
		  
		  int bot1,bot2,bot3;
		  String b1,b2,b3;
		  public String read_value() {
		if(n1.isEmpty()|n2.isEmpty()|n3.isEmpty()) {
			System.out.println("empty");
		}else
			     if(n1.length()>0|n2.length()>0|n3.length()>0) {
			    	 bot1=qwe1(45);   bot2=qwe2(84);    bot3=qwe3(64);
			    	 b1=String.valueOf(bot1);   b2=String.valueOf(bot2);    b3=String.valueOf(bot3);
			    	 if(n1.equals(b1)|n1.equals(b2)|n1.equals(b3)
			    	   |n2.equals(b1)|n2.equals(b2)|n2.equals(b3)
			    	   |n3.equals(b1)|n3.equals(b2)|n3.equals(b3)) {
			    		 fleet="Win bot |"+b1+"|"+b2+"|"+b3+" You |"+n1+"|"+n2+"|"+n3;
			    	 }else {
			    		 fleet="Sorry  bot |"+b1+"|"+b2+"|"+b3+" You |"+n1+"|"+n2+"|"+n3;
						  
			    	 }
			    	
		}
		  return "";}
		  
		  
		   int ys;
			public void clear() {
				new Singleton().setOdd_bet_id_fast_v1(tstack);
				
				if(new Singleton().getOdd_bet_id_fast_v1().equals("opo")) {
					update="Enter a Stack";
					System.out.println("a");
		  }else if(Corrupt_char1(new Singleton().getOdd_bet_id_fast_v1())){
			
			         update="--------------------Stack too  low------------------"; 
			         new Singleton().setFile_flip(96);
					System.out.println("b");
						}else  if(new Singleton().getOdd_bet_id_fast_v1().trim().length()==0){
						
							update="--------------------Stack too  low------------------"; 
						System.out.println("c");
						new Singleton().setFile_flip(96);
						
					}else if(!Corrupt_char(new Singleton().getOdd_bet_id_fast_v1())){
						    
						update="-------------------Invaild value-------------------"; 
						System.out.println("d");
						new Singleton().setFile_flip(96);
					}
					else{update="-----"+tstack+" digidime would be debited-----"; 
					 ys=1;
					 new Singleton().setFile_flip(ys);
					}
			}
			
		
			
		  protected	 int u(String parseInt) {
					int y=	Integer.parseInt(parseInt.trim());
							return y;
						} 
			 
			 
			public void sendin() {
				if(new Singleton().getFile_flip()==1) {
					
				
				if(new Games_Faces().CheckIN()<=0) {
					
					update="------------------Too low On Gas-----------------"; 
					new Singleton().setFile_flip(96);
				
				}else	if(new WebAPI_CONSQ_Current_User_block().Compare(new Games_Faces().CheckIN())<u((new Singleton().getOdd_bet_id_fast_v1()))){
				
						update="----------Oops You ran Out Of Gas--------------"; 
						new Singleton().setFile_flip(96);
					}else  if(new Singleton().getEmail().equals("-0000-")){
						
						update="--------------- Pls Sign in ------------------";
						new Singleton().setFile_flip(96);
					}else  if(new Singleton().getFile_flip()==1){
				
						update="-------------You have been matched--------------"; 
							new Singleton().setFile_flip(96);
						
							new Games_Faces().takeOut(new Singleton().getOdd_bet_id_fast_v1());
							 
							tstack="";
                     System.out.println(ys);
				}}
			}

	


		public String show_value() {
			 
	    	 bot1=jwe1(47);   bot2=jwe2(37);    bot3=jwe3(67);
	    	 c1=String.valueOf(bot1);   c2=String.valueOf(bot2);    c3=String.valueOf(bot3);
	    	 c1=String.valueOf(bot1).replace("-", "").replace("+", "").replace(".", "") ;  
	    	 c2=String.valueOf(bot2).replace("-", "").replace("+", "").replace(".", "") ;    
	    	 c3=String.valueOf(bot3).replace("-", "").replace("+", "").replace(".", "") ;   
			  vbx=true;
		  return"";}
		  
		  public String uploadera() {
			  FacesContext context=FacesContext.getCurrentInstance();
			  Map<String,String> bs=context.getExternalContext().getRequestParameterMap();
			  c1=bs.get("wat1");
			  
			
			  
			  bot1=qwe1(37);   bot2=qwe2(47);    bot3=qwe3(87);
		    	 b1=String.valueOf(bot1);   b2=String.valueOf(bot2);    b3=String.valueOf(bot3);
		    	 b1=String.valueOf(bot1).replace("-", "").replace("+", "").replace(".", "") ;  
		    	 b2=String.valueOf(bot2).replace("-", "").replace("+", "").replace(".", "") ;    
		    	 b3=String.valueOf(bot3).replace("-", "").replace("+", "").replace(".", "") ;   

			    if(c1.equals(b1)|c1.equals(b2)|c1.equals(b3)) {
		    		 fleet="    Win bot |"+b1+"|"+b2+"|"+b3+" You |"+c1;
		    	 }else {
		    		 fleet="  Sorry  bot |"+b1+"|"+b2+"|"+b3+" You |"+c1;
					  
		    	  
			    	 }
			    	
			  
		  return "";}
		  
		  
		  
		  
		  
		  public String uploaderb() {
			 
			  
			  FacesContext contex=FacesContext.getCurrentInstance();
			  Map<String,String> bsd=contex.getExternalContext().getRequestParameterMap();
			  c2=bsd.get("wat2");
			  
			
			  
			  bot1=qwe1(42);   bot2=qwe2(23);    bot3=qwe3(58);
		    	 b1=String.valueOf(bot1);   b2=String.valueOf(bot2);    b3=String.valueOf(bot3);
		    	 b1=String.valueOf(bot1).replace("-", "").replace("+", "").replace(".", "") ;  
		    	 b2=String.valueOf(bot2).replace("-", "").replace("+", "").replace(".", "") ;    
		    	 b3=String.valueOf(bot3).replace("-", "").replace("+", "").replace(".", "") ;   

		    	  if(c2.equals(b1)|c2.equals(b2)|c2.equals(b3)) {
			    		 fleet="    Win bot |"+b1+"|"+b2+"|"+b3+" You |"+c2;
			    	 }else {
			    		 fleet="  Sorry  bot |"+b1+"|"+b2+"|"+b3+" You |"+c2;
						  
			    	 }
			    	
			  
		  return "";}
		  
		  
		  @SuppressWarnings("unchecked")
		public List<QueDAO> getRandom_shift() throws IOException, SQLException { ////rand
				return new ProductListImageDAO().walleProductDetailsrandom(27);
			}







			public void setRandom_shift(List<QueDAO> random_shift) {
				this.random_shift = random_shift;
			}
		  
		  
		  
		  public String uploaderc() {
			 
			  
			  FacesContext conte=FacesContext.getCurrentInstance();
			  Map<String,String> baw=conte.getExternalContext().getRequestParameterMap();
			  c3=baw.get("wat3");
			  
			     bot1=qwe1(102);   bot2=qwe2(37);    bot3=qwe3(87);
		    	 b1=String.valueOf(bot1).replace("-", "").replace("+", "").replace(".", "") ;  
		    	 b2=String.valueOf(bot2).replace("-", "").replace("+", "").replace(".", "") ;    
		    	 b3=String.valueOf(bot3).replace("-", "").replace("+", "").replace(".", "") ;   
		    	

			  if(c3.equals(b1)|c3.equals(b2)|c3.equals(b3)) {
			    		 fleet="    Win bot |"+b1+"|"+b2+"|"+b3+" You |"+c3;
			    	 }else {
			    		 fleet="  Sorry  bot |"+b1+"|"+b2+"|"+b3+" You |"+c3;
						  
			    	 }
			    	
			  
		  return "";}
		  
		  
		  private int qwe1(int i) {
			return (int)(Math.random()*i/9+87+1/8);
			}
		  
		  
		  
		  private int qwe2(int i) {
			  return (int)(Math.random()*i+27*3);
			}
		  
		  
		  private int qwe3(int i) {
			  return (int)(Math.random()*i+27*15/4);
			}
		  
		  
		  
		  private int jwe1(int i) {
				return (int)(Math.random()*i-87+16);
				}
			  
			  
			  
			  private int jwe2(int i) {
				  return (int)(Math.random()*i+2+54);
				}
			  
			  
			  private int jwe3(int i) {
				  return (int)(Math.random()*i+27+5);
				}
			  
			  
			  
			  protected boolean Corrupt_char(String h) {
				        if (h.startsWith("0")|h.contains("-")
							|h.contains("^")|h.contains("/")
							|h.contains(";")|h.contains(",")
							|h.contains("`")|h.contains("\\")
							|h.contains("~")|h.contains("{")
							|h.contains("}")|h.contains("[]")
							|h.contains("]")|h.contains("[")
							|h.contains("(")|h.contains(")")
							|h.contains("()")|h.contains("€")
							|h.contains("+")|h.contains("-")
							|h.contains("*")|h.contains("%")
							|h.contains("$")|h.contains("#")
							|h.contains("@")|h.contains("!")
							|h.contains(".")|h.contains("|")
							|h.contains("_")|h.contains("&")
							|h.contains("=")|h.contains("?")) {
					 return false;
				 }else {
					 return true;
				 }
			  }
			  
			  
			  protected boolean Corrupt_char1(String j) {
				 if (j.trim().equals("0")
						    |j.trim().equals("00")
							|j.trim().equals("000")
							|j.trim().equals("0000")
							|j.trim().equals("00000")
							|j.trim().equals("000000")){
			  return true;
					 }else {
						 return false;
					 }
				  }
			}
