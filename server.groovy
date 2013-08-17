import javax.ws.rs.core.Response
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


	@Path("hello")
	@GET
	@Produces("text/plain")
	public String getHello() {
		return "Hello World";
	}


	@Path("test")
	@GET
	@Produces("text/plain")
	public Response test() {
		return  Response.ok("test").build();
	}
}


String BASE_URI = "http://localhost:9099/";

ResourceConfig rc = new ResourceConfig(HelloWorldResource.class);
URI endpoint = new URI(BASE_URI);

HttpServer server = JdkHttpServerFactory.createHttpServer(endpoint, rc);
System.out.println("console v2.0 : Press Enter to stop the server. ");
System.in.read();
server.stop(0);

