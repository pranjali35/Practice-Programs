import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient{
	public static void main(String[] args){
		try{
			Socket s = new Socket("afsaccess4.njit.edu", 8200);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			Scanner scan = new Scanner(System.in);
			
			boolean done = false;
			String fromUser = "";
			String fromServer = "";
			System.out.println(br.readLine());
			while(!done){
				fromUser = scan.nextLine();
				pw.println(fromUser);
				fromServer = br.readLine();
				System.out.println(fromServer);
							
			}
		}
		catch(UnknownHostException uhe){
			System.out.println(uhe.getMessage());
		}
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
}