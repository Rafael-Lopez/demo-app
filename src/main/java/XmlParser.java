import domain.Config;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

public class XmlParser {
    public static final String PATH_NULL_ERROR_MSG = "Path cannot be null";
    public static final String PATH_EMPTY_ERROR_MSG = "Path cannot be empty";

    public static Config parse(String path) throws JAXBException, IOException {
        if (path == null) {
            throw new IllegalArgumentException(PATH_NULL_ERROR_MSG);
        } else if (path.isEmpty()) {
            throw new IllegalArgumentException(PATH_EMPTY_ERROR_MSG);
        }

        JAXBContext context = JAXBContext.newInstance(Config.class);

        return (Config) context.createUnmarshaller().unmarshal(new FileReader(path));
    }
}
