import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PageHandler implements HttpHandler {
    private static final Logger logger = LogManager.getLogger(PageHandler.class);

    public void handle(HttpExchange httpExchange) throws IOException {
        logger.debug("User agent is {}", httpExchange.getRequestHeaders().get("User-Agent").get(0));

        byte[] html = Files.readAllBytes(Paths.get("index.html"));

        httpExchange.sendResponseHeaders(200, html.length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(html);
        os.close();
    }
}
