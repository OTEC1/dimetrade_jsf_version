package EJBS_CONTROL;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ApplicationScoped
public class Video  {

	/**
	 * 
	 */
	         StreamedContent paths;
			String looped,looping,count;
			InputStream strea;
			public  void bVideo(int h) throws FileNotFoundException{
		      h=0;
			
		        count=String.valueOf(h);
		        	looping="C:\\Users\\User\\Videos\\Android\\hv.mp4";
		       looped=looping.replace("hv", count);
		    //  System.out.println("A"+looped);
		        	strea = this.getClass().getResourceAsStream(looped);
		        	paths= new DefaultStreamedContent(strea, "video/quicktime");
		        	
		                
		        
		      
				
			}
			
			
	       public StreamedContent getPaths() {
				return paths;
			}

	       public void setPaths(StreamedContent paths) {
				this.paths = paths;
			}



	




	public Video() {
		
	}







}
