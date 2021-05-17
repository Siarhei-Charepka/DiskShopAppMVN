import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    private static Properties properties;

    static {

        properties = new Properties();
        InputStream is = Configurations.class.getResourceAsStream("/store.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
