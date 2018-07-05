package WebServer;
/*
 * @author Christoph Schallert
 * Simple web-server that accepts get-requests and responses to them.
 */
import java.io.BufferedReader;
import java.io.FileReader;
/*
 * @author Christoph Schallert
 * Simple Webserver (Manages a HTTP-get-request and shows the HTML-page)
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Webserver {
	
	public static void main(String[] args) {
		
		try {
			/* Server-socket standardized with the port 8080 */
			ServerSocket server = new ServerSocket(8080);
			System.out.println("Server was started.");
			
			/* Listens until a connection is found */
			Socket client = server.accept();
			System.out.println("Connected.");
		
			/* Reader to read a request, writer to write a response */
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			
			
			/* The server's response */
			writer.print("HTTP/1.1 200" + System.lineSeparator()); //Shows the HTTP-version + the status code
			writer.print("Content-Type: text/plain" +System.lineSeparator()); //Shows the content type
			writer.write("Connection: close" + System.lineSeparator()); //Closes the connection
			writer.write(System.lineSeparator()); //Separates the header
						
			/* Reads the pending request */
			String str;
			while((str = reader.readLine()) != null) {
				writer.print(str + System.lineSeparator());
				System.out.println(str); //Control
			}
			
			/* Reads the HTML-file */
			FileReader fr = new FileReader("Index.html");
			BufferedReader bufferedfr = new BufferedReader(fr);
			
			String page;
			while((page = bufferedfr.readLine()) != null) {
				writer.println(page);
				System.out.println(page);//Control
			}
			
			writer.flush();
			
			reader.close();
			writer.close();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
