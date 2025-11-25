import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection con=null;
    public static Connection connect(){
        
        try{
            String url="jdbc:mysql://localhost:3306/Bank";
            String user="root";
            String pass="28022004";

            con=DriverManager.getConnection(url, user, pass);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
