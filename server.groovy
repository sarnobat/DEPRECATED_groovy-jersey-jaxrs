import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;


@Path("helloworld")
public class HelloWorldResource {
	final String CLICHED_MESSAGE = "Hello World!";

	@GET
	@Produces("text/plain")
	public String getHello() {
		return CLICHED_MESSAGE;
	}
}


String BASE_URI = "http://localhost:9099/";

ResourceConfig rc = new ResourceConfig(HelloWorldResource.class);
URI endpoint = new URI(BASE_URI);

HttpServer server = JdkHttpServerFactory.createHttpServer(endpoint, rc);
System.out.println("console v2.0 : Press Enter to stop the server. ");
System.in.read();
server.stop(0);

