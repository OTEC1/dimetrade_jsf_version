package CONFIGURE;
import java.sql.*;
public class Connec_Config {

	
	Connection cons;
    String URL= "jdbc:postgresql://localhost:5432/postgres";
    String ps="vkw643211";
    String user="postgres";
    public Connection getConnection() {
        try{
        	
            Class.forName("org.postgresql.Driver");
         
            if(cons==null){
                cons= DriverManager.getConnection(URL, user,ps);
            }
        }catch(SQLException | ClassNotFoundException  e){System.out.println(e);
        
        
		}
        
    
    return cons;
    
}
	
}
