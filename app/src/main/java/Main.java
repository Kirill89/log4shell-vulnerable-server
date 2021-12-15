import java.io.IOException;

import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.Level;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Configurator.setRootLevel(Level.ALL);
        (new Server()).run();
    }
}
