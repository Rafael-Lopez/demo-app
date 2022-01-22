import domain.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class DemoApp {
    private static Logger logger = LoggerFactory.getLogger(DemoApp.class);
    private static final String FILE_PATH_ARG = "filePath";
    private static final String PRINT_KEYS_ARG = "printKeys";

    public static void main(String[] args) throws JAXBException, IOException {
        logger.info("*** Application started ***");
        Config config = XmlParser.parse(System.getProperty(FILE_PATH_ARG));

        JedisClient jedisClient = new JedisClient(config);
        jedisClient.exportContent();

        if (System.getProperty(PRINT_KEYS_ARG) != null) {
            jedisClient.printAllKeys();
        }
    }
}
