import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    static {
        Configurator.setRootLevel(Level.ALL);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/", exchange -> {
            logger.debug("User agent is {}", exchange.getRequestHeaders().get("User-Agent").get(0));

            byte[] html = Files.readAllBytes(Paths.get("index.html"));

            exchange.sendResponseHeaders(200, html.length);
            OutputStream os = exchange.getResponseBody();
            os.write(html);
            os.close();
        });

        server.setExecutor(newCachedThreadPool());
        server.start();
    }
}
