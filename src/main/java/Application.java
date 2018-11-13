import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import rest.SQL;

import java.io.IOException;
import java.sql.SQLException;


public class Application {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, IllegalAccessException {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8081);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                SQL.class.getCanonicalName() +"," + SQL.class.getCanonicalName() );

        try {
            jettyServer.start();
            jettyServer.join();
        }
        catch(Exception e){
            System.out.println("\nОшибка:" + e.getLocalizedMessage());
        }
        finally {
            jettyServer.destroy();
        }
    }

}
