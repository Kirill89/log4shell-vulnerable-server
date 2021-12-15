import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import static java.util.concurrent.Executors.newCachedThreadPool;

class Server {
    public void run() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new PageHandler());
        server.setExecutor(newCachedThreadPool());
        server.start();
    }
}
