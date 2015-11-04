
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

	
public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		HttpServer server = HttpServer.create(new InetSocketAddress(83), 0);
		server.createContext("/", new MyHandler());
		server.setExecutor(null); // creates a default executor
		server.start();
	}

	static class MyHandler implements HttpHandler 
	{
		@Override
		public void handle(HttpExchange httpExchange)
		{
			try
			{
				String response = "Hello World"; 

				httpExchange.sendResponseHeaders(200, response.getBytes().length);

				OutputStream outputStream = httpExchange.getResponseBody();
				outputStream.write(response.getBytes());
				outputStream.close();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
	}
}

