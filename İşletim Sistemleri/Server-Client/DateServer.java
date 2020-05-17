import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Date;
import java.net.Socket;

public class DateServer{
    
    
    public static void main(String[] args) throws IOException
    {
        ServerSocket listener=new ServerSocket(9090);
        
        while(true)
        {
            Socket socket=listener.accept();
            try
            {
                
                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                out.println("Operating Systems Course"/*new Date().toString()*/);
                System.out.println("Date is written ");
                
            }
            catch(IOException ex)
            {
                
                
            }
            catch(Exception ex)
            {
                
                
            }
            finally
            {
                
                listener.close();
                
            }
            
            
        }
        
        
    }
    
}
