package EJBS_CONTROL;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class Searchouse {
	 public Searchouse() {
	    }
	    
	    String search,st,x;
        boolean div_display=true;
        
        
	   
	    
//	    public Map<String, Object> getArributes(){
//	        Map<String,Object> atrributes = new HashMap<>();
//	        atrributes.put("type", "sea");
//	        atrributes.put("placeholder", "  Search");
//	        return atrributes;
//	    }
	    
	



		public String run_query() throws IOException {
	    	
				st=new Singleton().getNav_index();
			Integer b=Integer.parseInt(st);
	    	
	    	switch (b) {
			
	    	
	    	
	    	case 1:
	    		if(search.length()<=0) {
					System.out.println("2 no bing");
					
					 return"/index_Error.xhtml";
			 }
				else {
					
					 new Singleton().setStore_owner(search);
				
	    		return "/indexto_do_Cat.xhtml";}
	    		
		
	    	
	    	case  2:
				if(search.length()<=0) {
					System.out.println("2 no bing");
					
					 return"/index_Error.xhtml";
			 }
				else {
				
					 new Singleton().setStore_owner(search);
				
				
				return"/indexwalletoS.xhtml";
			}
			 
				
		           case  3:
		     
		        		if(search.length()<=0) {
							System.out.println("2 no bing");
							
							 return"/index_Error.xhtml";
					 }
						else {
							
							 new Singleton().setStore_owner(search);
		
		        	   return"/index_group_mining.xhtml"; }
		
		          case   4:
						
		        	  
		        		if(search.length()<=0) {
							System.out.println("2 no bing");
							
							 return"/index_Error.xhtml";
					 }
						else {
					
							 new Singleton().setStore_owner(search);
		        	 
		        	  return "/index_geomap.xhtml";}
						
		           case   5:
					
		        	   
		        		if(search.length()<=0) {
							System.out.println("2 no bing");
							
							 return"/index_Error.xhtml";
					 }
						else {
							 new Singleton().setStore_owner(search);
		
		        	   return"/indexwalleto.xhtml";}
		
		         
		           case  6:
		        		
		        
		        	   return""; 
						
		           case  00:
		        		if(search.length()<=0) {
							System.out.println("Home no bing");
							 return"/index_Error.xhtml";
					 }
		        		else { 
							
		        			 new Singleton().setStore_owner(search);
						
						return "/index_shopping.xhtml";
					
						
		        		}
					
		           case 111:
		        	   if(search.length()<=0) {
							System.out.println("Zero no bing");
							 return"/index_Error.xhtml";
					 }
		        		else { 
		        			
		        			 new Singleton().setStore_owner(search);
		        	   return"/index_shopping.xhtml";
			        	
		        		}
		                 default:
						
						 break;
							
						
			}
	    	
	    	//System.out.println(st);
	    
	    	return "/index_Error.xhtml";
	    }
	    
	    
	
	
	
		


		public boolean isDiv_display() {
			return div_display;
		}

		public void setDiv_display(boolean div_display) {
			this.div_display = div_display;
		}

		public String getSearch() {
	        return search;
	    }

	    public void setSearch(String search) {
	        this.search = search;
	    }

	    

	    	
		
	   
}
